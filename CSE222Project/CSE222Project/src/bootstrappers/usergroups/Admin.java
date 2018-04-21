package bootstrappers.usergroups;

import java.util.ArrayList;

public class Admin extends SystemUserAbstract {


    public Admin(String name, String surname, String password, String phoneNumber, String email, String userType) {
        super(name, surname, password, phoneNumber, email, userType);
    }

    @Override
    public boolean login(ArrayList<SystemUserAbstract> userList) {

        for (SystemUserAbstract target: userList) {
            if (target.getUserType().equals("Admin")){
                if (target.getEmail().equals(this.getEmail())){
                    if (target.getPassword().equals(this.getPassword()))
                        return true;
                }
            }
        }
        return false;
    }


}
