import java.util.ArrayList;

public class Member extends SystemUserAbstract {
    public Member(String name, String surname, String password, String phoneNumber, String email, String userType) {
        super(name, surname, password, phoneNumber, email,userType);
    }

    @Override
    public boolean login(ArrayList<SystemUserAbstract> userList) {
        for (SystemUserAbstract target: userList) {
            if (target.getUserType().equals("Member")){
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
                System.out.println("Zaten kayıtlısın! ");
                return false;
            }
            userList.add(this);
        }
        return true;
    }
}
