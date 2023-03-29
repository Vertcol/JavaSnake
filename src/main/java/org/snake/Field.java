package org.snake;

public class Field {
    public int[][] field;
    public static int size;
    private Snake snake;

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }



    public Field(int size) {
        Field.size = size;
        field = new int[size][size];
    }
    public void render() {
        // Clear field
        field = new int[size][size];

        // Add snake to field
        for (SnakePart snakePart: snake.getParts()) {
            Location loc = snakePart.getLocation();
            field[loc.y][loc.x] = 1;
        }

        // Add pickup to field
        field[Pickup.location.y][Pickup.location.x] = 2;

        // Padding between last frame
        for (int i = 0; i < 11; i++) {
            System.out.println();
        }

        for (int[] line: field) {
            for (int part: line) {
                if (part == 0) {
                    System.out.print("  "); // Empty space (0)
                } else if (part == 1) {
                    System.out.print("██"); // Snake part (1)
                } else if (part == 2) {
                    System.out.print("░░"); // Pickup (2)
                }
            }
            System.out.println();
        }
    }
}
