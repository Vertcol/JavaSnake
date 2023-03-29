package org.example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static int score;
    public static void main(String[] args) throws InterruptedException, IOException {


        // Gets the direction in realtime from the terminal, runs on a seperate thread for constant input processing
        InputManager input = new InputManager();
        input.start();

        // The pickup which grows the snake and gives you points
        Pickup pickup = new Pickup();

        // The snake, which is made of multiple SnakeParts
        Snake snake = new Snake();

        // Playfield with a configurable size
        Field field = new Field(8);
        field.setSnake(snake);

        while (true) {
            // Print out the field and the current score
            field.render();
            System.out.println("Score: " + score);

            // Wait before next move
            TimeUnit.MILLISECONDS.sleep(300);

            // Move based on the most recent direction
            snake.move(input.getDir());
            if (snake.checkCollission(snake.getHead().getLocation())) {
                break;
            };
        }

        System.out.println("Thanks for playing! ");

    }


}