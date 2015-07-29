/**
 * Created by rursu on 7/20/2015.
 */
public class MainClass {
    public static void main(String args[]) {
//        long start = System.nanoTime();
//        new Integer(2+3);
//        System.out.println(System.nanoTime() - start);
//
//        System.out.println(".............................");
//
//        long start2 = System.nanoTime();
//        int x;
//        x= 2+3;
//        System.out.println(System.nanoTime() - start2);

        long usedMem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        //String a = new String("abc");
        long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(usedMem1 - usedMem);
    }
}
