package bootstrappers;

import bootstrappers.database.FileOperations;
import bootstrappers.usergroups.Admin;
import bootstrappers.usergroups.Member;
import bootstrappers.usergroups.SystemUser;
import bootstrappers.usergroups.SystemUserAbstract;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class BootStrappers extends BinarySearchTree<Integer>{

    private ArrayList<Home> homeArrayList = new ArrayList<>();
    private ArrayList<SystemUserAbstract> userArrayList = new ArrayList<>();

    private PriorityQueue<Home> homeQueue = new PriorityQueue<>();
    private BinarySearchTree<Integer> areaOfHomes = new BinarySearchTree<>();
    private ArrayList<Integer> descendingArea = new ArrayList<>();
    private ArrayList<Integer> ascendingArea = new ArrayList<>();
    private Map<String, Integer> homesInPlace;

    public BootStrappers() {
        FileOperations fileOperations = new FileOperations();
        fileOperations.readUserList(userArrayList);
        fileOperations.readHomeList(homeArrayList, userArrayList);

    }
    public ArrayList<Home> getHomeArrayList() {
        return homeArrayList;
    }

    public ArrayList<SystemUserAbstract> getUserArrayList() {
        return userArrayList;
    }

    public ArrayList<Home> filterHomes(String a, String b, String c, String d) {return homeArrayList;}

    public Stack<Home> generateDescendingOrderedStack(Stack<Home> home) {

        Stack<Home> home2 = new Stack<Home>();
        while(!home.isEmpty()) {
            Home temp = home.pop();
            while(!home2.isEmpty() && home2.peek().compareTo(temp) < 0) {
                home.push(home2.pop());
            }
            home2.push(temp);
        }
        return home;
    }

    public void displayStack(Stack<Home> home) {
        System.out.println("Size: " + home.size());
        while(!home.isEmpty())
            System.out.println(home.pop() + "->");

        System.out.println("end");
    }

    public PriorityQueue<Home> generateAscendingOrderedQueue() {return homeQueue;}

    /* home listinden area bilgisini çek, search tree oluştur, uygun yere koy. */
    public BinarySearchTree<Integer> generateBSTforArea(ArrayList<Home> homeArrayList) {

        for(int i=0; i<homeArrayList.size(); ++i) {
            areaOfHomes.insert(homeArrayList.get(i).getArea());
        }
        return areaOfHomes;
    }

    /* inorder traverse yap, arrayliste at */
    public ArrayList<Integer> generateDescendingArea() {

        Node temp = areaOfHomes.root;
        helperDescending(temp);
        return descendingArea;
    }

    public void helperDescending(Node root) {

        if (root == null)
            return;

        helperDescending(root.left);
        descendingArea.add(root.data);
        helperDescending(root.right);
    }

    public ArrayList<Integer> generateAscendingArea() {

        Node temp = areaOfHomes.root;
        helperAscending(temp);
        return ascendingArea;
    }

    public void helperAscending(Node root) {

        if (root == null)
            return;

        helperDescending(root.right);
        descendingArea.add(root.data);
        helperDescending(root.left);
    }

    /* neighborhood bilgisini key yap, value artsın */
    public Map<String,Integer> generateTotalHomesInPlace(ArrayList<Home> homeArrayList) {

        return homesInPlace;
    }
}