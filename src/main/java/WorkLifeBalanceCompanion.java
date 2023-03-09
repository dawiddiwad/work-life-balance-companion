import static javax.swing.JOptionPane.OK_OPTION;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class WorkLifeBalanceCompanion extends Frame implements KeyListener {
  public WorkLifeBalanceCompanion() {
    super(Labels.APP_NAME);
    this.addKeyListener(this);
  }

  public static void main(String[] args) {
    if (DialogHandler.showConfirm() != OK_OPTION) WorkLifeBalanceCompanion.close();
    try {
      ScreenSaver.onAllScreens();
      MouseMover.start();
    } catch (AWTException | InstantiationException e) {
      WorkLifeBalanceCompanion.close(e);
    }
  }

  public static void close() {
    System.exit(0);
  }

  public static void close(Throwable e) {
    Arrays.stream(ScreenSaver.localDevices()).forEach(screen -> screen.setFullScreenWindow(null));
    DialogHandler.showError(e.getLocalizedMessage());
    WorkLifeBalanceCompanion.close();
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {}

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == 27) WorkLifeBalanceCompanion.close();
  }
}
