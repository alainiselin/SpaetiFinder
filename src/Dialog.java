import javax.swing.JDialog;
import javax.swing.JLabel;

public class Dialog extends JDialog {
    /* private JDialog dialog = new JDialog(); */
    private JLabel message = new JLabelDesign("Adress doesn't exist!");

    public Dialog() {
        this.setTitle("Attention");
        this.setLocationRelativeTo(null);
        this.setSize(200, 50);
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