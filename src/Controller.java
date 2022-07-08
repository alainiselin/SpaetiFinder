import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {

    private SpaetiFinderMainFrame mainFrame;
    private DbDao dbDao;
    private SpaetiFinderPanel spaetiFinderPanel = new SpaetiFinderPanel();
    private RndSpaetiSearchPanel rndSpaetiSearchPanel = new RndSpaetiSearchPanel();
    private NearestSpaetiSearchPanel nearestSpaetiSearchPanel = new NearestSpaetiSearchPanel();
    private DisplaySpaetiPanel displaySpaetiPanel = new DisplaySpaetiPanel();

    public Controller(SpaetiFinderMainFrame mainFrame, DbDao dbDao) {

        this.mainFrame = mainFrame;
        this.dbDao = dbDao;

        spaetiFinderPanel.addRNDChoiceButtonListener(new RNDChoiceButtonListener());
        spaetiFinderPanel.addNearestChoiceButtonListener(new NearestChoiceButtonListener());
        rndSpaetiSearchPanel.addFinalSearchButtonListenerRND(new FinalSearchButtonListenerRND());
        nearestSpaetiSearchPanel.addFinalSearchButtonListenerNearest(new FinalSearchButtonListenerNearest());
        rndSpaetiSearchPanel.addReturnHomeListener(new ReturnHomeListener());
        nearestSpaetiSearchPanel.addReturnHomeListener(new ReturnHomeListener());
        displaySpaetiPanel.addReturnHomeListener(new ReturnHomeListener());
    }

    public void init() {
        spaetiFinderPanel.addPanelToFrame(mainFrame);
        spaetiFinderPanel.setPanelVisible();
    }

    class RNDChoiceButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            spaetiFinderPanel.setPanelInvisible();
            rndSpaetiSearchPanel.addPanelToFrame(mainFrame);
            rndSpaetiSearchPanel.setPanelVisible();
        }
    }

    class NearestChoiceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            spaetiFinderPanel.setPanelInvisible();
            nearestSpaetiSearchPanel.addPanelToFrame(mainFrame);
            nearestSpaetiSearchPanel.setPanelVisible();
        }
    }

    public String getDistrictComboBoxInfo() {
        System.out.println(rndSpaetiSearchPanel.getDistrictComboBox().getSelectedItem().toString());
        return rndSpaetiSearchPanel.getDistrictComboBox().getSelectedItem().toString();
    }

    public String getTextFieldInfo() {
        System.out.println(nearestSpaetiSearchPanel.getAddressTextField().getText());
        return nearestSpaetiSearchPanel.getAddressTextField().getText();
    }

    public Position compareTextFieldInfoWithPositions(String address) {
        int counter = 0;
        try {
            for (Position position : dbDao.getPositionsList()) {
                if (address.equals(position.getAddress())) {
                    return dbDao.getPositionsList().get(counter);
                }
                counter++;
            }
        } catch (Exception e) {
            System.out.println("position does not exist!");
        }
        return null;
    }

    public void setTable(ArrayList<Spaeti> currentRequest) {
        Integer i = 1;
        for (Spaeti spaeti : currentRequest) {
            displaySpaetiPanel.getModel().addRow(new Object[] { i, spaeti.getNameSpaeti(), spaeti.getOpeningTimes(),
                    spaeti.getAddress(), spaeti.getDistrict(), spaeti.getLatitude(), spaeti.getLongitude() });
            i++;
        }

    }

    public void deleteTable() {
        while (displaySpaetiPanel.getModel().getRowCount() > 0) {
            displaySpaetiPanel.getModel().removeRow(0);
        }
    }

    class FinalSearchButtonListenerRND implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dbDao.requestSpaetiByDistrict(getDistrictComboBoxInfo());
            rndSpaetiSearchPanel.setPanelInvisible();
            displaySpaetiPanel.addPanelToFrame(mainFrame);
            displaySpaetiPanel.setPanelVisible();
            setTable(dbDao.getCurrentRequests());
        }
    }

    class FinalSearchButtonListenerNearest implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dbDao.requestSpaetiByAddress(compareTextFieldInfoWithPositions(getTextFieldInfo()));
            nearestSpaetiSearchPanel.setPanelInvisible();
            displaySpaetiPanel.addPanelToFrame(mainFrame);
            displaySpaetiPanel.setPanelVisible();
            setTable(dbDao.getCurrentRequests());
        }

    }

    class ReturnHomeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displaySpaetiPanel.setPanelInvisible();
            rndSpaetiSearchPanel.setPanelInvisible();
            nearestSpaetiSearchPanel.setPanelInvisible();
            deleteTable();
            dbDao.purgeCurrentRequests();
            spaetiFinderPanel.addPanelToFrame(mainFrame);
            spaetiFinderPanel.setPanelVisible();
        }

    }

}