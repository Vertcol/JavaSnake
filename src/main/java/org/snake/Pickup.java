package org.snake;
import java.util.concurrent.ThreadLocalRandom;
public class Pickup {
    public static Location location;

    public Pickup() {
        location = new Location(5,5);
    }

    public static void setPos() {

        int randomNum = ThreadLocalRandom.current().nextInt(0, Field.size);
        location.x = randomNum;
        location.y = randomNum;
        Main.score += 1;
    }
}
