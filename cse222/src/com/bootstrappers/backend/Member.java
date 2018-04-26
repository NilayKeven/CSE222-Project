package com.bootstrappers.backend;

import java.util.ArrayList;

public class Member extends SystemUserAbstract {
    public Member(String name, String surname, String password, String phoneNumber, String email, String userType) {
        super(name, surname, password, phoneNumber, email,userType);
    }

    @Override
    public boolean login(ArrayList<SystemUserAbstract> userList) {
        for (SystemUserAbstract target: userList) {
            if (target.getUserType().equals("com.bootstrappers.backend.Member")){
                if (target.getEmail().equals(this.getEmail())) {
                    if (target.getPassword().equals(this.getPassword()))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean registeration(ArrayList<SystemUserAbstract> userList){
        for (SystemUserAbstract target : userList) {
            if (target.getEmail().equals(this.getEmail())){
                return false;
            }
        }
        userList.add(this);
        FileOperations fo = new FileOperations();
        fo.writeUserList(userList);
        return true;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getSurname();
    }
}
