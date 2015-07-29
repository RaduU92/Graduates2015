/**
 * Created by rursu on 7/22/2015.
 */
public class BackAround {
    public static String backAround(String s) {
        return s.charAt(s.length()-1) + s + s.charAt(s.length()-1);
    }

    public static void main(String args[]) {
        System.out.println(backAround("cat"));
        System.out.println(backAround("Hello"));
        System.out.println(backAround("a"));
    }
}
