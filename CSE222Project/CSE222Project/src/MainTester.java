import bootstrappers.BootStrappers;
import bootstrappers.Home;
import bootstrappers.usergroups.SystemUserAbstract;

public class MainTester {
    public static void main(String arg[]){
        BootStrappers test = new BootStrappers();
        for (SystemUserAbstract user: test.getUserArrayList()) {
            System.out.println(user.getName());
        }
        for (Home home: test.getHomeArrayList()) {
            System.out.println(home.getAddress().getNeighborhood());
        }
    }

}
