import java.awt.*;
import javax.swing.*;

class DisplaySpaetiPanel extends GenericPanel {
    private JLabel resultsLabel = new JLabel("Ihre Suche hat folgende Ergebnisse erzielt:");

    public DisplaySpaetiPanel() {
        super();
        this.add(resultsLabel, BorderLayout.NORTH);
    }

}
