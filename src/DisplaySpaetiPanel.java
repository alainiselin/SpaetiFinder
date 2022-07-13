import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class DisplaySpaetiPanel extends GenericPanel {
    private JLabel resultsLabel = new JLabelDesign("Ihre Suche hat folgende Ergebnisse erzielt:");

    DefaultTableModel model = new DefaultTableModel();
    JTable resultsTable = new JTable(model);

    public DisplaySpaetiPanel() {
        super();
        this.add(resultsLabel, BorderLayout.NORTH);
        model.addColumn("ID");
        model.addColumn("NAMESPAETI");
        model.addColumn("OPENINGTIMES");
        model.addColumn("ADDRESS");
        model.addColumn("DISTRICT");
        this.add(new JScrollPane(resultsTable));
    }

    

    public DefaultTableModel getModel() {
        return model;
    }

    public JTable getResultsTable() {
        return resultsTable;
    }

}
