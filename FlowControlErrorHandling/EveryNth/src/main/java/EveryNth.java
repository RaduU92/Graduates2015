/**
 * Created by rursu on 7/22/2015.
 */
public class EveryNth {
    public static String everyNth(String s, int n) {
        String str = new String();
        for(int i = 0; i < s.length(); i = i + n) {
            str = str + s.charAt(i);
        }
        return str;
    }

    public static void main(String args[]) {
        System.out.println(everyNth("Miracle",2));
        System.out.println(everyNth("abcdefg",2));
        System.out.println(everyNth("abcdefg",3));
    }
}
