import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;

class RndSpaetiSearchPanel extends GenericPanel {
    private JLabel descriptionRnd = new JLabel("Beliebigen Spätkauf finden");
    private String[] choices = { "Kreuzberg", "Mitte", "Neukölln" };
    private JComboBox<String> districtComboBox = new JComboBox<String>(choices);
    private JButton rndDistrictSearchButton = new JButton("Suche starten!");

    RndSpaetiSearchPanel() {
        super();
        this.add(descriptionRnd, BorderLayout.NORTH);
        this.add(districtComboBox, BorderLayout.CENTER);
        this.add(rndDistrictSearchButton, BorderLayout.EAST);
    }

    // Method to connect Panel with Controller --> rndDistrictSearchButton was
    // clicked
    public void addFinalSearchButtonListenerRND(ActionListener listenForFinalSearchButton) {
        rndDistrictSearchButton.addActionListener(listenForFinalSearchButton);
    }

}