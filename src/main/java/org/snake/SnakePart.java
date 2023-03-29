package org.snake;

public class SnakePart {
    private Location location;
    private SnakePart next_part;

    public SnakePart(Location location, SnakePart next_part) {
        this.location = location;
        this.next_part = next_part;
    }

    public SnakePart(Location location) {
        this.location = location;
        this.next_part = this;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setNextPart(SnakePart part) {
        this.next_part = part;
    }

    public SnakePart getNextPart() {
        return next_part;
    }
}
