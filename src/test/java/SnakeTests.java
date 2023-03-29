import org.snake.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTests {
    @Test
    public void stay_within_bounds() {
        // Create field, locations rely on field size
        Field field = new Field(16);

        // Ensure locations are limited to field
        assertTrue(new Location(0,0).equals(new Location(16,16)));
        assertTrue(new Location(-1,-1).equals(new Location(15,15)));
    }

    @Test
    public void self_collision() {
        // Create field, locations rely on field size
        Field field = new Field(8);


        Snake snake = new Snake();
        assertFalse(snake.checkCollission(snake.getHead().getLocation()));

        // Make snake collide with itself
        snake.increase_length(Direction.RIGHT);
        snake.increase_length(Direction.UP);
        snake.increase_length(Direction.LEFT);
        snake.increase_length(Direction.DOWN);

        assertTrue(snake.checkCollission(snake.getHead().getLocation()));
    }
}
