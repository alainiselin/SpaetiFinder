import java.sql.*;

import java.util.ArrayList;

public class DbDao implements spaetiDao {

    private ArrayList<Spaeti> spaetiListFromDb = new ArrayList<Spaeti>();
    private ArrayList<Spaeti> currentRequest = new ArrayList<Spaeti>();

    public void addSpaetiToList() {
        OracleDsSingleton ora = OracleDsSingleton.getInstance();
        try {
            Connection con = ora.getConnection();

            String query = "select * from SPAETI";
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String nameSpaeti = rs.getString("NAMESPAETI");
                    String openingTimes = rs.getString("OPENINGTIMES");
                    String adress = rs.getString("ADRESS");
                    Float latitude = rs.getFloat("LATITUDE");
                    Float longitude = rs.getFloat("LONGITUDE");

                    spaetiListFromDb.add(new Spaeti(nameSpaeti, openingTimes, adress, latitude, longitude));
                    System.out.println("Spaeti:" + nameSpaeti + ", with opening Times: " + openingTimes
                            + ", at adress: " + adress +
                            ", and coordinates: " + latitude + ", " + longitude + ", got created!");
                    System.out.println("");

                }
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
        }
    }

    public ArrayList<Spaeti> getCurrentRequest() {
        return this.currentRequest;
    }
}
