import java.util.*;

public class BeverageList {
    private String[] softdrinks = new String[]{"Coca Cola", "Fanta", "Sprite", "Eistee", "Almdudler"};
    private List<String> softdrinkList = new ArrayList<>();

    public BeverageList(int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int option = rand.nextInt(0, softdrinks.length);
            this.softdrinkList.add(softdrinks[option]);
        }
    }

    public void printList() {
        for(int i = 0; i < softdrinkList.size(); i++) {
            System.out.print(softdrinkList.get(i) + ",");
        }
        System.out.println();
    }

    public void printOccurence() {
        for(String label : softdrinks) {
            int count = 0;
            for(String labelList : softdrinkList) {
                if(labelList.equals(label)) {
                    count++;
                }
            }
            System.out.print(label + String.format("(%d)", count) + ",");
        }
        System.out.println();
    }

    public void sortList() {
        Collections.sort(softdrinkList);
    }

    public void removeDuplicates() {
        sortList();
        for(int i = softdrinkList.size() - 1; i > 0; i--) {
            int count = 0;
            for(int j = 0; j < softdrinkList.size() - 1; j++) {
                if(softdrinkList.get(i).equals(softdrinkList.get(j))) {
                    count++;
                }
            }
            if(count > 1) {
                softdrinkList.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of softdrinks: ");
        int size = sc.nextInt();

        BeverageList list = new BeverageList(size);
        System.out.println("List of 10 softdrinks:");
        list.printList();
        System.out.println("Occurence of softdrinks:");
        list.printOccurence();
        System.out.println("Sorted list of softdrinks:");
        list.sortList();
        list.printList();
        System.out.println("Sorted list without duplicates:");
        list.removeDuplicates();
        list.printList();
    }
}
