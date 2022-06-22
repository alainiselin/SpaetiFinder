import java.sql.*;

import java.util.ArrayList;

public class DbDao implements genericDao {

    private ArrayList<Spaeti> spaetiListFromDb;

    public void addSpaetiToList() {
        OracleDsSingleton ora = OracleDsSingleton.getInstance();
        try {
            Connection con = ora.getConnection();

            String query = "select NAMESPAETI, OPENINGTIMES, ADRESS, LATITUDE, LONGITUDE from SPAETI";
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String nameSpaeti = rs.getString("NAMESPAETI");
                    String openingTimes = rs.getString("OPENINGTIMES");
                    String adress = rs.getString("ADRESS");
                    Float latitude = rs.getFloat("LATITUDE");
                    Float longitude = rs.getFloat("LONGITUDE");
                    System.out.println(nameSpaeti + ", " + openingTimes + ", " + adress +
                            ", " + latitude + ", " + longitude);
                }
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
        }

    }
}
