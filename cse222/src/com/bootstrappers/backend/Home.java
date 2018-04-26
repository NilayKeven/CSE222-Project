package com.bootstrappers.backend;

public class Home implements Comparable<Home>{

    private String countOfRoom; // Count of room (2+1, 3+1 etc.)

    private String status; // For rent or for sale

    private String type; // Müstakil, Apartman, Villa

    private Address address; // com.bootstrappers.backend.Address detail

    private int adNumber;

    private Member owner;

    private int price;

    private int area; // evin metrekaresi

    public Home(String countOfRoom, String status, String type, Address address, int adNumber, Member owner, int area, int price) {
        this.countOfRoom = countOfRoom;
        this.status = status;
        this.type = type;
        this.address = address;
        this.adNumber = adNumber;
        this.owner = owner;
        this.area = area;
        this.price=price;
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

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Home temp) {
        if (this.price<temp.price)
            return -1;

        else if (this.price>temp.price)
            return 1;


        return 0;
    }
}
