import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;

class NearestSpaetiSearchPanel extends GenericPanel {
    private JLabel descriptionNear = new JLabelDesign("Nächstgelegenen Spätkauf finden");
    private JTextField addressTextField = new JTextField(30);
    private JButton nearestSpaetiSearchButton = new JButtonDesign("Suche starten!");

    NearestSpaetiSearchPanel() {
        super();
        this.add(descriptionNear, BorderLayout.NORTH);
        this.add(addressTextField, BorderLayout.CENTER);
        this.add(nearestSpaetiSearchButton, BorderLayout.EAST);
    }

    // Method to connect Panel with Controller --> NearestSearchButton was
    // clicked
    public void addFinalSearchButtonListenerNearest(ActionListener listenForFinalSearchButton) {
        nearestSpaetiSearchButton.addActionListener(listenForFinalSearchButton);
    }

    public JTextField getAddressTextField() {
        return addressTextField;
    }

}