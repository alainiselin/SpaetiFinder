import javax.swing.JDialog;
import javax.swing.JLabel;

public class Dialog extends JDialog {
    /* private JDialog dialog = new JDialog(); */
    private JLabel message = new JLabelDesign("There is no corresponding Position for your address, please try again!");

    public Dialog() {
        this.setTitle("Attention");
        this.setBounds(200, 200, 500, 200);
        message.setBounds(0, 30, 500, 25);
        this.add(message);

    }

    public void setDialogVisible() {
        this.setVisible(true);
    }

    public void setDialogInvisible() {
        this.setVisible(false);
    }

    public void disposeDialog() {
        this.remove(message);
        this.dispose();
    }

}