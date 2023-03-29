package org.example;


import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static int score;
    public static void main(String[] args) throws InterruptedException, IOException {



        InputManager input = new InputManager();
        input.start();

        Field field = new Field(8);

        Pickup pickup = new Pickup();

        Snake snake = new Snake();

        field.setSnake(snake);

        while (true) {

            field.render();
            System.out.println("Score: " + score);

            TimeUnit.MILLISECONDS.sleep(300);

            snake.move(input.getDir());
            if (snake.checkCollission(snake.getHead().getLocation())) {
                break;
            };
        }

        System.out.println("Thanks for playing! ");

    }


}