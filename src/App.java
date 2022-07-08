import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) throws FileNotFoundException {

        Position position1 = new Position("Neuweg 17", 29.99937, 84.81873);
        Position position2 = new Position("Vorhöllenallee 666", 53.16233, 72.61273);

        SpaetiFinderMainFrame frame = new SpaetiFinderMainFrame();
        DbDao dbDao = new DbDao();
        Controller theController = new Controller(frame, dbDao);
        theController.init();
        frame.setVisible(true);

        dbDao.addSpaetiToList();

        for (Spaeti spaeti : dbDao.getSpaetiListFromDb()) {
            System.out.println(spaeti.spaetiToString() + "---> was created");
        }

        dbDao.addPositionList(position1);
        dbDao.addPositionList(position2);

        /* System.out.println(position1.toString()); */

    }

}
