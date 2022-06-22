import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvReader {
    private String[] names;
    private String[] openingTimes;
    private String[] adresses;
    private double[] latitudes;
    private double[] longitudes;

    public void readData() throws FileNotFoundException {
        File file = new File(
                "/Users/alainiselin/STUDIUM/Semester 4 [Ausland]/OOP2/SpätiFinder/CsvData/SpaetiCsvData.csv");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        
        scan.close();
    }
}
