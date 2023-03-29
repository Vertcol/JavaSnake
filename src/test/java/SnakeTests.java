import org.example.Location;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SnakeTests {

    public void stay_within_bounds() {
        assertEquals(new Location(0,0), new Location(16,16));
    }
}
