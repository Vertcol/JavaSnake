package org.example;

public class Location {
    public int x;
    public int y;

    public Location(int x, int y) {
        this.x = inside_bounds(x);
        this.y = inside_bounds(y);
    }

    public boolean equals(Location obj) {
        return this.x == obj.x && this.y == obj.y;
    }

    public int inside_bounds(int location) {
        if (location < 0) {
            return Field.size - 1;
        } else if (location >= Field.size) {
            return 0;
        }
        return location;
    }
}
