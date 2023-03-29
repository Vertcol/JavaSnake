package org.example;

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
        field = new int[size][size];

        for (SnakePart snakePart: snake.getParts()) {
            Location loc = snakePart.getLocation();
            field[loc.y][loc.x] = 1;
        }

        field[Pickup.location.y][Pickup.location.x] = 2;

        for (int i = 0; i < 11; i++) {
            System.out.println();
        }

        for (int[] line: field) {
            for (int part: line) {
                if (part == 0) {
                    System.out.print("  ");
                } else if (part == 1) {
                    System.out.print("██");
                } else if (part == 2) {
                    System.out.print("░░");
                }
            }
            System.out.println();
        }
    }
}
