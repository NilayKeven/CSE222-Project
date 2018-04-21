
import java.util.*;


public class BootStrappers extends BinarySearchTree<Integer> implements Comparator<Home>{

    private ArrayList<Home> homeArrayList = new ArrayList<>();
    private ArrayList<SystemUserAbstract> userArrayList = new ArrayList<>();

    Comparator<Home> com = new MyComparator();
    PriorityQueue<Home> homeQueue = new PriorityQueue<Home>(10, com);
    Stack<Home> home = new Stack<Home>();
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

    public Stack<Home> generateDescendingOrderedStack() {
        Collections.sort(homeArrayList);
        for (int i=0;i<homeArrayList.size();i++) {
            home.push(homeArrayList.get(i));
        }
        return home;
    }

    public void displayStack() {
        System.out.println("Prices: " + home.size());
        while(!home.isEmpty())
            System.out.println(home.pop().getPrice() + "->");
    }

    public PriorityQueue<Home> generateAscendingOrderedQueue() {

        PriorityQueue<Home> sorted= new PriorityQueue<Home>();
        for (int i=0;i<homeArrayList.size();i++){
            homeQueue.add(homeArrayList.get(i));
        }
        while(homeQueue.size()!=0){
            Home temp = homeQueue.remove();
            sorted.offer(temp);

        }
        while(sorted.size()!=0)
        {
            homeQueue.offer(sorted.remove());
        }

    return homeQueue;
    }

    public void displayPriorityQueue() {
        System.out.println("Prices: " + homeQueue.size());
        while(!homeQueue.isEmpty())
            System.out.println("->"+homeQueue.poll().getPrice());

    }


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
       // helperDescending(temp);
        return descendingArea;
    }

    public void helperDescending(Node root) {

        if (root == null)
            return;

       /* helperDescending(root.left);
        descendingArea.add(root.data);
        helperDescending(root.right);*/
    }

    public ArrayList<Integer> generateAscendingArea() {

        Node temp = areaOfHomes.root;
       // helperAscending(temp);
        return ascendingArea;

    }

    public void helperAscending(Node root) {

        if (root == null)
            return;

       /* helperDescending(root.right);
        descendingArea.add(root.data);
        helperDescending(root.left);*/
    }

    /* neighborhood bilgisini key yap, value artsın */
    public Map<String,Integer> generateTotalHomesInPlace(ArrayList<Home> homeArrayList) {

        return homesInPlace;
    }

    @Override
    public int compare(Home o1, Home o2) {
        if (o1.getPrice()<o2.getPrice())
            return -1;
        else if (o1.getPrice()==o2.getPrice())
            return 0;

        return 1;
    }
}