import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    public void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(1000, true);


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(1_000_000, true);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 500;
        boolean registered = false;
        long expected = 5;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 10000;
        boolean registered = false;
        long expected = 100;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }
}
