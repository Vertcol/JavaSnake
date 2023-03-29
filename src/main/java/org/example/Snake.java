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

    public void move(Direction dir) {
        Location new_loc = new Location(1,1);

        switch (dir) {
            case UP -> new_loc = new Location(this.head.getLocation().x, this.head.getLocation().y - 1);
            case DOWN -> new_loc = new Location(this.head.getLocation().x % Field.size, this.head.getLocation().y + 1);
            case LEFT -> new_loc = new Location(this.head.getLocation().x - 1 % Field.size, this.head.getLocation().y);
            case RIGHT -> new_loc = new Location(this.head.getLocation().x + 1 % Field.size, this.head.getLocation().y);
        }

//        // Self-collission check
//        for (SnakePart part : parts) {
//            // Ignore head colliding with itself
//            if (part.equals(head)) {
//                continue;
//            }
//
//            // Collission with other snake part
//            if (part.getLocation().equals(head.getLocation())) {
//                System.out.println("GG!");
//            }
//        }

        if (new_loc.equals(Pickup.location)) {
            // Add new part to linked list
            SnakePart new_head = new SnakePart(new_loc,head.getNextPart());
            head.setNextPart(new_head);
            parts.add(new_head);
            head = new_head;

            Pickup.setPos();
        } else {
            head = head.getNextPart();
            head.setLocation(new_loc);
        }
    }

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
