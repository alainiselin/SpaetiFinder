import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) throws FileNotFoundException {

        View view = new View();
        CsvDao csvDao = new CsvDao();
        DbDao dbDao = new DbDao();
        Controller theController = new Controller(view, csvDao, dbDao);
        theController.init();

        /*
         * CsvReader csvReader = new CsvReader();
         * csvReader.readData();
         */

    }

}
