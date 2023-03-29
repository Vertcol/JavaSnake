package org.snake;

import java.util.ArrayList;
import java.util.List;

import static org.snake.Direction.*;

public class Snake {
    public SnakePart getHead() {
        return head;
    }

    private SnakePart head;

    public List<SnakePart> getParts() {
        return parts;
    }

    private List<SnakePart> parts = new ArrayList<SnakePart>();

    public Snake() {
        head = new SnakePart(new Location(1,1));
        parts.add(head);
    }

    // Moves snake by one step, also appends a new snakepart to linked list if a pickup is touched
    public void move(Direction dir) {

        // Get new location based on input
        Location next_loc = next_location(dir);

        // Check if pickup is touched
        if (next_loc.equals(Pickup.location)) {
            increase_length(dir);

            // Update pickup position, ensure it doesn't collide with snake
            while (true) {
                Location pickupLocation = Pickup.setPos();
                if (!checkCollission(pickupLocation)) {
                    break;
                }
            }

        } else {
            // Cycle through linked list
            // The head always has the back of the snake as the next part
            head = head.getNextPart();
            head.setLocation(next_loc);
        }
    }

    public Location next_location(Direction dir) {
        Location new_loc = new Location(1,1);
        switch (dir) {
            case UP -> new_loc = new Location(this.head.getLocation().x, this.head.getLocation().y - 1);
            case DOWN -> new_loc = new Location(this.head.getLocation().x, this.head.getLocation().y + 1);
            case LEFT -> new_loc = new Location(this.head.getLocation().x - 1, this.head.getLocation().y);
            case RIGHT -> new_loc = new Location(this.head.getLocation().x + 1, this.head.getLocation().y);
        }
        return new_loc;
    }

    public void increase_length(Direction dir) {
        Location location = next_location(dir);
        // Create a new snake part and place it between the head and its next part
        SnakePart new_head = new SnakePart(location,head.getNextPart());
        head.setNextPart(new_head);
        parts.add(new_head);
        head = new_head;
    }



    // Checks if snake collides with itself based on the head position
    public boolean checkSelfCollission(Location location) {
        for (SnakePart part : parts) {
            if (part.equals(head)) {
                continue;
            }
            if (part.getLocation().equals(location)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCollission(Location location) {
        for (SnakePart part : parts) {
            if (part.getLocation().equals(location)) {
                return true;
            }
        }
        return false;
    }
}
