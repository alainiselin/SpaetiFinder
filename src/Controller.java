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
            rndSpaetiSearchPanel.addPanelToFrame(mainFrame);
            rndSpaetiSearchPanel.setPanelVisible();
        }
    }

    public String getDistrictComboBoxInfo() {
        return rndSpaetiSearchPanel.getDistrictComboBox().getSelectedItem().toString();
    }

    public String getTextFieldInfo() {
        return nearestSpaetiSearchPanel.getAddressTextField().getText();
    }

    public void setTable(ArrayList<Spaeti> currentRequest) {
        /* displaySpaetiPanel.getResultsTable().addColumn(); */
    }

    class FinalSearchButtonListenerRND implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dbDao.requestSpaetiByDistrict(getDistrictComboBoxInfo());
            rndSpaetiSearchPanel.setPanelInvisible();
            displaySpaetiPanel.addPanelToFrame(mainFrame);
            displaySpaetiPanel.setPanelVisible();
            setTable(dbDao.getCurrentRequest());
        }
    }

    class FinalSearchButtonListenerNearest implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dbDao.requestSpaetiByAddress(getTextFieldInfo());
            nearestSpaetiSearchPanel.setPanelInvisible();
            displaySpaetiPanel.addPanelToFrame(mainFrame);
            displaySpaetiPanel.setPanelVisible();
            setTable(dbDao.getCurrentRequest());
        }

    }

    class ReturnHomeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displaySpaetiPanel.setPanelInvisible();
            rndSpaetiSearchPanel.setPanelInvisible();
            nearestSpaetiSearchPanel.setPanelInvisible();
            spaetiFinderPanel.addPanelToFrame(mainFrame);
            spaetiFinderPanel.setPanelVisible();
        }

    }

}