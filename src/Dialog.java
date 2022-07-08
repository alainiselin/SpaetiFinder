import javax.swing.JDialog;
import javax.swing.JLabel;

public class Dialog extends JDialog {
    private JDialog dialog = new JDialog();
    private JLabel message = new JLabel("There is no corresponding Position for your address, please try again!");

    public void createDialog() {
        dialog.setTitle("Attention");
        message.setBounds(0, 30, 500, 25);
        dialog.add(message);
        dialog.setBounds(200, 200, 500, 200);

    }

    public void setDialogVisible() {
        Dialog dialogWindow = new Dialog();
        dialogWindow.createDialog();
        dialog.setVisible(true);
    }

    public void setDialogInvisible() {
        dialog.setVisible(false);
    }

    public void disposeDialog() {
        dialog.remove(message);
        dialog.dispose();
    }

}