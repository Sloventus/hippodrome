import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class HorseTest {

    @Test
    public void notNullTest() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null,1.1));
    }

    @Test
    public void nameCanNotBeNull() {
        try {
            new Horse(null,1.1);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Name cannot be null.");
        }
    }

    //не работает параметризированный тест
    @Test
    @DisplayName("НЕДОДЕЛАННЫЙ ТЕСТ")
    public void nameIsBlank() {
        try {
            new Horse("  ",1.1);
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals(e.getMessage(), "Name cannot be blank.");
        }
    }

    @Test
    public void negativeSpeed() {
        try {
            new Horse("qwer",-1.1);
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals(e.getMessage(), "Speed cannot be negative.");
        }
    }

    @Test
    public void negativeDistance() {
        try {
            new Horse("qwer",1.1, -1.1);
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals(e.getMessage(), "Distance cannot be negative.");
        }
    }

    @Test
    public void moveTest() {
        try (MockedStatic mockStaticHorse = mockStatic(Horse.class)) {
            mockStaticHorse.when(() -> Horse.getRandomDouble(anyDouble(), anyDouble())).thenReturn(0.5);

            double distance = Horse.getRandomDouble(1,2) + 1 + 0.5;
            mockStaticHorse.verify( () -> { Horse.getRandomDouble(anyDouble(), anyDouble()); } );
            assertEquals(2,distance);
        }
    }
}
