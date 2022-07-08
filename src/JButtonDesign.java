
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.border.Border;

public class JButtonDesign extends JButton {

    private static final long serialVersionUID = 1L;
    private Font font = new Font("Dialog", Font.PLAIN, 14);

    public JButtonDesign(String text) {
        super(text);
        this.setFont(font);
        this.setBorder(new RoundBtn(10)); // 10 is the radius
        this.setBackground(new Color(171, 130, 255));
    }
    
    class RoundBtn implements Border {
        private int r;

        RoundBtn(int r) {
            this.r = r;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.r + 1, this.r + 1, this.r + 2, this.r);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, r, r);
        }
    }
}
