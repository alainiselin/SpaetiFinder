import java.awt.*;
import javax.swing.*;

public class View extends JFrame {

    // Layout for Frame
    protected BorderLayout borderLayoutFrame = new BorderLayout();

    View() {
        // set Frame Title
        this.setTitle("Späti-Finder");

        // Frame configuration
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(600, 200);
        this.setLayout(borderLayoutFrame);

        // Frame Layout configuration
        borderLayoutFrame.setHgap(10);
        borderLayoutFrame.setVgap(10);

    }

}
