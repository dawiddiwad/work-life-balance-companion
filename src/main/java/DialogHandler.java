import static javax.swing.JOptionPane.*;

public class DialogHandler {
  static int showConfirm() {
    return showConfirmDialog(null, Labels.CONFIRM_DIALOG_MSG, Labels.APP_NAME, OK_CANCEL_OPTION);
  }

  static void showError(String message) {
    showMessageDialog(null, message, Labels.ERROR_DIALOG_TITLE, ERROR_MESSAGE, null);
  }
}
