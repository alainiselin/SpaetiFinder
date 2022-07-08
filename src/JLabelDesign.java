import java.awt.Font;

import javax.swing.JLabel;

public class JLabelDesign extends JLabel {
    private static final long serialVersionUID = 1L;
    private Font font = new Font("Dialog", Font.PLAIN, 14);

    public JLabelDesign(String text) {
        super(text);
        this.setFont(font);
    }
}