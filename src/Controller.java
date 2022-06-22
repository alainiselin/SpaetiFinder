import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private View theView;
    private CsvDao csvDao;
    private DbDao dbDao;
    private SpaetiFinderPanel spaetiFinderPanel = new SpaetiFinderPanel();
    private RndSpaetiSearchPanel rndSpaetiSearchPanel = new RndSpaetiSearchPanel();
    private NearestSpaetiSearchPanel nearestSpaetiSearchPanel = new NearestSpaetiSearchPanel();
    private DisplaySpaetiPanel displaySpaetiPanel = new DisplaySpaetiPanel();

    public Controller(View theView, CsvDao csvDao, DbDao dbDao) {

        this.theView = theView;
        this.csvDao = csvDao;
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
        spaetiFinderPanel.addPanelToFrame(theView);
        spaetiFinderPanel.setPanelVisible();
    }

    class RNDChoiceButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            spaetiFinderPanel.setPanelInvisible();
            rndSpaetiSearchPanel.addPanelToFrame(theView);
            rndSpaetiSearchPanel.setPanelVisible();
        }
    }

    class NearestChoiceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            spaetiFinderPanel.setPanelInvisible();
            rndSpaetiSearchPanel.addPanelToFrame(theView);
            rndSpaetiSearchPanel.setPanelVisible();
        }
    }

    class FinalSearchButtonListenerRND implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            rndSpaetiSearchPanel.setPanelInvisible();
            displaySpaetiPanel.addPanelToFrame(theView);
            displaySpaetiPanel.setPanelVisible();
        }
    }

    class FinalSearchButtonListenerNearest implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            nearestSpaetiSearchPanel.setPanelInvisible();
            displaySpaetiPanel.addPanelToFrame(theView);
            displaySpaetiPanel.setPanelVisible();
        }

    }

    class ReturnHomeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displaySpaetiPanel.setPanelInvisible();
            rndSpaetiSearchPanel.setPanelInvisible();
            nearestSpaetiSearchPanel.setPanelInvisible();
            spaetiFinderPanel.addPanelToFrame(theView);
            spaetiFinderPanel.setPanelVisible();
        }

    }

}