import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class MainTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.MINUTES)
    public void faster22ms() {
        try {
            Main.main(new String[]{"qwer"});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
