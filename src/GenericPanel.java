import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;

public class GenericPanel extends JPanel {
    protected BorderLayout borderLayoutPanel = new BorderLayout();
    protected JButton returnHome = new JButtonDesign("zur Startseite");

    GenericPanel() {
        // Panel Layout configuration
        this.setLayout(borderLayoutPanel);
        borderLayoutPanel.setHgap(20);
        borderLayoutPanel.setVgap(20);
        this.setBackground(new Color(240, 225, 250));
        this.add(returnHome, BorderLayout.SOUTH);

    }

    // Method to connect Panel with Controller --> returnPageButton was clicked
    public void addReturnHomeListener(ActionListener listenForReturnHomeButton) {
        returnHome.addActionListener(listenForReturnHomeButton);
    }

    // Method to add Panel to Frame
    public void addPanelToFrame(SpaetiFinderMainFrame theView) {
        theView.add(this);
    }

    // Method to Set Panel visible
    public void setPanelVisible() {
        this.setVisible(true);
    }

    // Method to Set Panel invisible
    public void setPanelInvisible() {
        this.setVisible(false);
    }

}
