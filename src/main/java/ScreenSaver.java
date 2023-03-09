import java.awt.*;

class ScreenSaver extends WorkLifeBalanceCompanion {
  public ScreenSaver(GraphicsDevice device) throws InstantiationException {
    if (!device.isFullScreenSupported())
      throw new InstantiationException(Labels.FULL_SCREEN_NOT_SUPPORTED_MSG);
    this.setUndecorated(true);
    this.setBackground(Color.BLACK);
    device.setFullScreenWindow(this);
  }

  public static GraphicsDevice[] localDevices() {
    return GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
  }

  public static void onAllScreens() throws InstantiationException {
    for (GraphicsDevice screen : ScreenSaver.localDevices()) {
      new ScreenSaver(screen);
    }
  }
}
