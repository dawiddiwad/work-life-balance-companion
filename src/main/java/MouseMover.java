import java.awt.*;
import java.util.Random;

class MouseMover implements Runnable {
  public static final int CADENCE_MILLIS = 5_000;
  Random random;
  Robot robot;

  MouseMover() throws AWTException {
    random = new Random();
    robot = new Robot();
  }

  public static void start() throws AWTException {
    new Thread(new MouseMover()).start();
  }

  Dimension getScreenDimensions() {
    DisplayMode displayMode =
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
    return new Dimension(displayMode.getWidth(), displayMode.getHeight());
  }

  @Override
  public void run() {
    try {
      while (true) {
        Dimension screen = getScreenDimensions();
        int x = random.nextInt((int) screen.getWidth());
        int y = random.nextInt((int) screen.getHeight());
        robot.mouseMove(x, y);
        Thread.sleep(CADENCE_MILLIS);
      }
    } catch (InterruptedException e) {
      WorkLifeBalanceCompanion.close(e);
    }
  }
}
