public class Address {

    private String province;

    private String country; /* gerek yok */

    private String neighborhood; /* semt */

    public Address(String province, String country, String neighborhood) {
        this.province = province;
        this.country = country;
        this.neighborhood = neighborhood;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

}
