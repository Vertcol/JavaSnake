package org.snake;


import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;

public class InputManager extends Thread {
    private Direction dir;
    private NonBlockingReader reader;

    // Initialize relevant objects for input polling
    public InputManager() throws IOException {
        Terminal terminal = TerminalBuilder.builder().jna(true).system(true).build();
        terminal.enterRawMode();

        this.reader = terminal.reader();

        // Default direction
        dir = Direction.RIGHT;
    }

    public Direction getDir() {
        return dir;
    }

    // Polls for input
    public void run() {
        int input = -1;

        while (true) {

            try {
                input = reader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (input) {
                case 119 -> dir = Direction.UP; // w
                case 115 -> dir = Direction.DOWN; // s
                case 97 -> dir = Direction.LEFT; // a
                case 100 -> dir = Direction.RIGHT; // d
            }


        }
    }
}
