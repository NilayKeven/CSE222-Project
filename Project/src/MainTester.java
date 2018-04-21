public class MainTester {
    public static void main(String arg[]){
        BootStrappers test = new BootStrappers();
        for (SystemUserAbstract user: test.getUserArrayList()) {
            System.out.println(user.getName());
        }
        for (Home home: test.getHomeArrayList()) {
            System.out.println(home.getAddress().getNeighborhood());
        }
        test.generateAscendingOrderedQueue();
        test.displayPriorityQueue();

        test.generateDescendingOrderedStack();
        test.displayStack();

    }

}
