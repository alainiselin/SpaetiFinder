import java.awt.*;
import javax.swing.*;

class DisplaySpaetiPanel extends GenericPanel {
    private JLabel resultsLabel = new JLabel("Ihre Suche hat folgende Ergebnisse erzielt:");
    String column[] = { "ID", "NAMESPAETI", "OPENINGTIMES", "ADDRESS", "DISTRICT", "LATITUDE", "LONGITUDE" };
    private JTable resultsTable = new JTable();

    public DisplaySpaetiPanel() {
        super();
        this.add(resultsLabel, BorderLayout.NORTH);
        this.add(resultsTable, BorderLayout.CENTER);

    }

    public JTable getResultsTable() {
        return resultsTable;
    }

}
