import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;

class RndSpaetiSearchPanel extends GenericPanel {
    private JLabel descriptionRnd = new JLabelDesign("Beliebigen Spätkauf finden");
    private String[] choices = { "Treptow-Köpenick", "Tempelhof-Schöneberg", "Neukölln", "Steglitz-Zehlendorf",
            "Spandau", "Reinickendorf", "Pankow", "Lichtenberg Hohenschönhausen", "Mitte", "Marzahn-Hellersdorf",
            "Friedrichshain-Kreuzberg", "Charlottenburg-Wilmersdorf" };
    private JComboBox<String> districtComboBox = new JComboBox<String>(choices);
    private JButton rndDistrictSearchButton = new JButtonDesign("Suche starten!");

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

    public JComboBox<String> getDistrictComboBox() {
        return districtComboBox;
    }

}