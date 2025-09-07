package university.jala.capstonelegion.sortStrategy;

import java.io.IOException;

public class TimeManagerGame {
    private volatile boolean stopRequested = false;

    public void stopGame() {
        Thread stopThread = new Thread(() -> {
            try {
                System.out.println("\n(Press ENTER to stop)");
                System.in.read();
                this.stopRequested = true;
                System.out.println("\nDeteniendo el juego...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        stopThread.setDaemon(true);
        stopThread.start();
    }

    public void sleepSpeed(int speed) {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isStopRequested() {
        return stopRequested;
    }
}
