public class Position {
    private String address;
    private double latitude;
    private double longitude;

    public Position(String address, double latitude, double longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Späeti mit adresse: " + address + ", an Position: " + latitude + ", " + longitude;
    }

}
