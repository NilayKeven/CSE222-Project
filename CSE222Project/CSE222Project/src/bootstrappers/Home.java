package bootstrappers;

import bootstrappers.usergroups.Member;

public class Home {

    private String countOfRoom; // Count of room (2+1, 3+1 etc.)

    private String status; // For rent or for sale

    private String type; // Müstakil, Apartman, Villa

    private Address address; // Address detail

    private int adNumber;

    private Member owner;

    private int area; // evin metrekaresi

    public Home(String countOfRoom, String status, String type, Address address, int adNumber, Member owner, int area) {
        this.countOfRoom = countOfRoom;
        this.status = status;
        this.type = type;
        this.address = address;
        this.adNumber = adNumber;
        this.owner = owner;
        this.area = area;
    }

    public String getCountOfRoom() {
        return countOfRoom;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public Address getAddress() {
        return address;
    }

    public int  getAdNumber() {
        return adNumber;
    }

    public Member getOwner() {
        return owner;
    }

    public int getArea() { return area; }

    public int compareTo(Home temp) {
        return 0;
    }
}
