import java.util.ArrayList;

public interface spaetiDao {
    public double calculateDistance(Position position, Spaeti spaeti);

    public Spaeti evaluateNearestSpaetiToPosition(Position position);

    public void addSpaetiToList();

    public ArrayList<Spaeti> requestSpaetiByAddress(String address);

    public ArrayList<Spaeti> requestSpaetiByDistrict(String district);

    public ArrayList<Spaeti> getCurrentRequest();
}
