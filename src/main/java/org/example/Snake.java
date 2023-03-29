package org.example;

import java.util.ArrayList;
import java.util.List;

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
        Location new_loc = new Location(1,1);
        switch (dir) {
            case UP -> new_loc = new Location(this.head.getLocation().x, this.head.getLocation().y - 1);
            case DOWN -> new_loc = new Location(this.head.getLocation().x % Field.size, this.head.getLocation().y + 1);
            case LEFT -> new_loc = new Location(this.head.getLocation().x - 1 % Field.size, this.head.getLocation().y);
            case RIGHT -> new_loc = new Location(this.head.getLocation().x + 1 % Field.size, this.head.getLocation().y);
        }

        // Check if pickup is touched
        if (new_loc.equals(Pickup.location)) {
            // Create a new snake part and place it between the head and its next part
            SnakePart new_head = new SnakePart(new_loc,head.getNextPart());
            head.setNextPart(new_head);
            parts.add(new_head);
            head = new_head;

            // Update pickup position
            Pickup.setPos();
        } else {
            // Cycle through linked list
            // The head always has the back of the snake as the next part
            head = head.getNextPart();
            head.setLocation(new_loc);
        }
    }

    // Checks if snake collides with itself based on the head position
    public boolean checkCollission(Location location) {
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
}
