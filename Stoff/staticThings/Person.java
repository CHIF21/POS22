package staticThings;

public class Person {
    private String name;
    private String mail;
    private static int count = 0; // Alle Personen teilen sich diese Variable und gibt es nur einmal im Objekt

    public Person(String name, String mail) {
        this.name = name;
        this.mail = mail;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void printCOunt() {
        System.out.format("%d people were created.", getCount());
    }

    public static void main(String[] args) {
        Person person1 = new Person("Adrian", "bakadc21@htl-kaindorf.at");
        Person person2 = new Person("John", "john@gmail.com");
        Person person3 = new Person("Oliver", "ol@htl-kaindorf.at");

        Person.printCOunt();
    }
}
