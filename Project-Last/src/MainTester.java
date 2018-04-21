import java.util.HashMap;
import java.util.Map;

public class MainTester {
    public static void main(String arg[]){
        BootStrappers test = new BootStrappers();
        for (SystemUserAbstract user: test.getUserArrayList()) {
            System.out.println(user.getName());
        }
        for (Home home: test.getHomeArrayList()) {
            System.out.println(home.getAddress().getNeighborhood());
        }
        System.out.println("\nTest of Priority Queue:");
        test.generateAscendingOrderedQueue();
        test.displayPriorityQueue();

        test.generateDescendingOrderedStack();
        test.displayStack();

        System.out.println("\nTest of Binary Search Tree: ");
        test.generateBSTforArea(test.getHomeArrayList());
        test.generateDescendingArea();
        System.out.println("Descending Area: " + test.getDescendingArea());
        test.generateAscendingArea();
        System.out.println("Ascending Area: " + test.getAscendingArea());


        System.out.println("\nTest of filterHomes(..) method:");
        System.out.println("Find: " + test.filterHomes("Sisli", null, null,null,
                                        null, null));

        System.out.println("Find: " + test.filterHomes("Sisli", "1+1", null,null,
                null, null));

        System.out.println("Find: " + test.filterHomes("Fatih", null, null,null,
                null, null));

        System.out.println("Find: " + test.filterHomes(null, null, null,null,
                null, null));

   		System.out.println("\nTest of Map: ");
   		Map<String,Integer> map = new HashMap<>();
        map = test.generateTotalHomesInPlace(test.getHomeArrayList());
        System.out.println("##################################################");
        System.out.println("MAP Size : " + map.size());
        for (int i = 0; i < map.size(); ++i)
        {
            System.out.println(map.keySet().toArray()[i] + " -> " + map.get(map.keySet().toArray()[i]));
        }
        System.out.println("##################################################");


    }

}
