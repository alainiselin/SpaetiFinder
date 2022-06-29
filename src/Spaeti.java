public class Spaeti {

    private String nameSpaeti;
    private String openingTimes;
    private String address;
    private String district;
    private double latitude;
    private double longitude;

    public Spaeti(String nameSpaeti, String openingTimes, String address, String district, double latitude,
            double longitude) {
        this.nameSpaeti = nameSpaeti;
        this.openingTimes = openingTimes;
        this.address = address;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String spaetiToString() {
        return "Spaeti: " + nameSpaeti + ", with opening Times: " + openingTimes
                + ", in district: " + district + ", at address: " + address +
                ", and coordinates: " + latitude + ", " + longitude;
    }

    public String getNameSpaeti() {
        return nameSpaeti;
    }

    public String getOpeningTimes() {
        return openingTimes;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
