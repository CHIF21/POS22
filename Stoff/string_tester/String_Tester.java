package string_tester;

public class String_Tester {
    public static void main(String[] args) {

        String s1 = "hello 2CHIF";
        String s2 = new String(", nice to meet you");
        System.out.println(s1);
        System.out.println(s2);

        String s3 = s1 + s2; // assignment allowed
        System.out.println(s3);

        // comparsion of two strings
        String s4 = "hello 2CHIF";
        String s5 = new String("hello 2CHIF");
        System.out.println(s1 == s4); // --> true       Comparison of storage address
        System.out.println(s1 == s5); // --> false
        System.out.println(s1.equals(s5)); // --> true  Comparison content

        // get the third letter of a string.
        System.out.format("The %d. letter is %c.\n", 3, s1.charAt(2));

        // print every character of a string.
        for (char letter: s1.toCharArray()) {
            System.out.println(letter);
        }
        System.out.println();

        String txt = "Today is Wed. 12.18.2022";
        String[] tokens = txt.split(" ");
        for(String word : tokens) {
            System.out.println(word);
        }

        System.out.println(txt.indexOf("is")); // 6
        System.out.println(txt.indexOf("abc")); // -1, means not found in the String "txt"
        System.out.println(txt.startsWith("To")); // true
    }
}
