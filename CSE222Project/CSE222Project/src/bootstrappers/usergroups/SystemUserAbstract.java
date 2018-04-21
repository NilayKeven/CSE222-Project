package bootstrappers.usergroups;

import java.util.ArrayList;

public abstract class SystemUserAbstract implements SystemUser{

    private String name;

    private String surname;

    private String password;

    private String phoneNumber;

    private String email;

    private String userType;

    public SystemUserAbstract(String name, String surname, String password, String phoneNumber, String email, String userType) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public String getUserType(){
        return userType;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public abstract boolean login(ArrayList<SystemUserAbstract> userList);
}
