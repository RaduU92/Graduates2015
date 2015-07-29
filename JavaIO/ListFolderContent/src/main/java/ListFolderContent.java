import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rursu on 7/27/2015.
 */
public class ListFolderContent {
    // Functie recursiva ce returneaza dimensiunea folderului "directory" ca suma tuturor fisierelor componente
//    private static long sizeOfDirectory(File directory) {
//        long size = 0;
//        if (!directory.exists()) {
//            System.out.println("Fisierul nu exista!");
//        } else {
//            ArrayList<File> files = new ArrayList<File>(Arrays.asList(directory.listFiles()));
//            //for (File f : directory.listFiles()) {
//            for (File f : files) {
//                if (f.isFile()) {
//                    size += f.length();
//                } else
//                    size += sizeOfDirectory(f);
//            }
//        }
//        return size;
//    }

    // Scriu in fisierul "fileName" continutul unui folder cu calea "path"
    public static void listFolderContent(String path, String fileName) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            File f = new File(path);
            if (!f.exists()) {
                bw.write("Folderul specificat nu exista!");
                System.out.println("Folderul specificat nu exista!");
            } else {

                File[] theFiles = f.listFiles();
                Arrays.sort(theFiles, new FileSizeComparator());

                ArrayList<File> files = new ArrayList<File>(Arrays.asList(theFiles));
                for (File ff : files) {

                    bw.write(ff.getName() + "\n");
                    if (ff.isFile()) {
                        bw.write(" -Type: File, ");
                    } else {
                        bw.write(" -Type: Directory, ");
                    }
                    if (ff.canRead()) {
                        bw.write("R, ");
                    } else {
                        bw.write("-, ");
                    }
                    if (ff.canWrite()) {
                        bw.write("W, ");
                    } else {
                        bw.write("-, ");
                    }
                    if (ff.canExecute()) {
                        bw.write("X, ");
                    } else {
                        bw.write("-, ");
                    }
                    if (ff.isHidden()) {
                        bw.write("Hidden, ");
                    } else {
                        bw.write("Not Hidden, ");
                    }
                    if (ff.isDirectory()) {
                        //bw.write(", Size: " + /*+sizeOfDirectory(ff) +*/ "\n\n");
                        bw.write(", Size: " + ff.length() + "\n\n");
                    } else {
                        bw.write(", Size: " + ff.length() + "\n\n");
                    }
                }

            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        //String path = "D:\\rursu\\IdeaProjects\\JavaIO";
        String path = "C:\\Windows";
        String fileName = ".\\ListFolderContent\\src\\main\\resources\\out.txt";

        listFolderContent(path, fileName);
    }
}
