import java.sql.*;

import java.util.ArrayList;

public class DbDao implements spaetiDao {

    private ArrayList<Spaeti> spaetiListFromDb = new ArrayList<Spaeti>();
    private ArrayList<Spaeti> currentRequests = new ArrayList<Spaeti>();
    private ArrayList<Position> positionsList = new ArrayList<Position>();

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
                    String address = rs.getString("ADDRESS");
                    String district = rs.getString("DISTRICT");
                    Float latitude = rs.getFloat("LATITUDE");
                    Float longitude = rs.getFloat("LONGITUDE");

                    spaetiListFromDb.add(new Spaeti(nameSpaeti, openingTimes, address, district, latitude, longitude));

                }
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
        }
    }

    public ArrayList<Spaeti> requestSpaetiByDistrict(String district) {
        for (Spaeti spaeti : spaetiListFromDb) {
            if (spaeti.getDistrict().equals(district)) {
                currentRequests.add(spaeti);
            }
        }
        return currentRequests;
    }

    public ArrayList<Spaeti> requestSpaetiByAddress(String address) {
        for (Spaeti spaeti : spaetiListFromDb) {
            if (spaeti.getAddress().equals(address))
                currentRequests.add(spaeti);
        }
        return currentRequests;
    }

    public ArrayList<Spaeti> getCurrentRequests() {
        return this.currentRequests;
    }

    public double calculateDistance(Position position, Spaeti spaeti) {

        double distance = 0;

        int radius = 6371;

        double lat = Math.toRadians(position.getLatitude() - spaeti.getLatitude());
        double lon = Math.toRadians(position.getLongitude() - spaeti.getLongitude());

        double a = Math.sin(lat / 2) * Math.sin(lat / 2) + Math.cos(Math.toRadians(spaeti.getLatitude()))
                * Math.cos(Math.toRadians(position.getLatitude())) * Math.sin(lon / 2) * Math.sin(lon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        distance = radius * c;

        return Math.abs(distance);

    }

    public Spaeti evaluateNearestSpaetiToPosition(Position position) {

        double currentLowestDistance = 999999;
        int spaetiAtLowestDistanceIndex = 0;

        for (int i = 0; i < spaetiListFromDb.size(); i++) {
            if (calculateDistance(position, spaetiListFromDb.get(i)) < currentLowestDistance) {
                currentLowestDistance = calculateDistance(position, spaetiListFromDb.get(i));
                spaetiAtLowestDistanceIndex = i;
            }
        }
        return spaetiListFromDb.get(spaetiAtLowestDistanceIndex);
    }

    public ArrayList<Spaeti> getSpaetiListFromDb() {
        return spaetiListFromDb;
    }

    public void purgeCurrentRequests() {
        currentRequests.removeAll(currentRequests);
    }

}
