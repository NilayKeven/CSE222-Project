package com.bootstrappers.backend;

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
    private Map<String, Integer> homesInPlace = new HashMap<>();

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

    public ArrayList<Home> filterHomes(String neighborhood, String countOfRoom, String status,
                                       String type, Integer area, Integer price) {

        /*if(neighborhood!=null && countOfRoom==null && status==null && type==null && area==null && price==null) {
            generateTotalHomesInPlace(homeArrayList);
            return null;
        }*/
        ArrayList<Home> tempList = new ArrayList<Home>();
        for(int i=0; i<homeArrayList.size(); ++i)
            tempList.add(homeArrayList.get(i));

        for(int i=0; i<homeArrayList.size(); ++i) {

            if(neighborhood!=null && !homeArrayList.get(i).getAddress().getNeighborhood().equals(neighborhood))
                tempList.set(i, null);

            else if(countOfRoom!=null && !homeArrayList.get(i).getCountOfRoom().equals(countOfRoom))
                tempList.set(i, null);

            else if(status!=null && !homeArrayList.get(i).getStatus().equals(status))
                tempList.set(i, null);

            else if(type!=null && !homeArrayList.get(i).getType().equals(type))
                tempList.set(i, null);

            else if(area!=null && !(homeArrayList.get(i).getArea()==area))
                tempList.set(i, null);

            else if(price!=null && !(homeArrayList.get(i).getPrice()==(price)))
                tempList.set(i, null);
        }
        ArrayList<Home> returnList = new ArrayList<Home>();
        for(int i=0; i<tempList.size(); ++i) {
            if(tempList.get(i) != null)
                returnList.add(tempList.get(i));
        }
        return returnList;
    }

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
    public ArrayList<Integer> getDescendingArea() { return descendingArea; }
    public ArrayList<Integer> generateAscendingArea() {

        Node temp = areaOfHomes.root;
        helperAscending(temp);
        return ascendingArea;
    }
    public void helperAscending(Node root) {

        if (root == null)
            return;

        helperAscending(root.right);
        ascendingArea.add(root.data);
        helperAscending(root.left);
    }
    public ArrayList<Integer> getAscendingArea() { return ascendingArea; }
    /* neighborhood bilgisini key yap, value artsın */
    public Map<String,Integer> generateTotalHomesInPlace(ArrayList<Home> homeArrayList) {

        int found = -1;

        for(int i = 0; i < homeArrayList.size(); ++i) {

            String tempNeighborhood = homeArrayList.get(i).getAddress().getNeighborhood();
            for (int j = 0; j < homesInPlace.size(); ++j) {
                if(homesInPlace.keySet().toArray()[j].equals(tempNeighborhood)) {
                    found = 1;
                }
            }
            if(found == -1) {
                homesInPlace.put(tempNeighborhood,1);
            }
            else if(found == 1) {
                homesInPlace.put(tempNeighborhood,homesInPlace.get(tempNeighborhood) + 1);
            }
            found = -1;
        }
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