import java.awt.*;
import javax.swing.*;

public class SpaetiFinderMainFrame extends JFrame {

    // Layout for Frame
    protected BorderLayout borderLayoutFrame = new BorderLayout();

    SpaetiFinderMainFrame() {
        // set Frame Title
        this.setTitle("Späti-Finder");

        // Frame configuration
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 200);
        this.setLayout(borderLayoutFrame);

        // Frame Layout configuration
        borderLayoutFrame.setHgap(20);
        borderLayoutFrame.setVgap(20);

    }

}
