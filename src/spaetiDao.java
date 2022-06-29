import java.util.ArrayList;

public interface spaetiDao {
    public double calculateDistance();

    public void addSpaetiToList();

    public ArrayList<Spaeti> requestSpaetiByAddress(String adress);

    public ArrayList<Spaeti> requestSpaetiByDistrict(String district);

    public ArrayList<Spaeti> getCurrentRequest();
}
