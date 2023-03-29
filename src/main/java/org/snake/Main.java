package org.snake;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static int score;
    public static void main(String[] args) throws InterruptedException, IOException {


        // Gets the direction in realtime from the terminal, runs on a seperate thread for constant input processing
        InputManager input = new InputManager();
        input.start();

        // Playfield with a configurable size
        Field field = new Field(32);
        field.setSnake(new Snake());
        field.setPickup(new Pickup());

        while (true) {
            // Print out the field and the current score
            field.render();
            System.out.println("Score: " + score);

            // Wait before next move
            TimeUnit.MILLISECONDS.sleep(300);

            // Move based on the most recent direction
            field.getSnake().move(input.getDir());
            if (field.getSnake().checkSelfCollission(field.getSnake().getHead().getLocation())) {
                break;
            };
        }

        System.out.println("Thanks for playing! ");

    }


}