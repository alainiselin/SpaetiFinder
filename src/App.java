import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) throws FileNotFoundException {

        SpaetiFinderMainFrame frame = new SpaetiFinderMainFrame();
        DbDao dbDao = new DbDao();
        Controller theController = new Controller(frame, dbDao);
        theController.init();

        /*
         * CsvReader csvReader = new CsvReader();
         * csvReader.readData();
         */

        dbDao.addSpaetiToList();

    }

}
