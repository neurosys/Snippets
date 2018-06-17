
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;

/**
 * Hello world!
 *
 */
public class App 
{
    // Recursivly list dirs
    public static void listDir(File dir) {
        if (dir.isDirectory()) {
            System.out.println(dir.getName() + "/");
            File[] files = dir.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    listDir(f);
                }
                else {
                    System.out.println(f.getName());
                }
            }
        }
        else {
            System.out.println(dir.getName());
            return;
        }
    }

    public static void listDir(String dir_name) {
        File dir = new File(dir_name);
        listDir(dir);
    }

    // Rename / Move file
    public static void moveFile(String f1_name, String f2_name) {
        File f1 = new File(f1_name);
        f1.renameTo(new File(f2_name));
    }

    // Remove file
    public static void removeFile(String f_name) {
        File f = new File(f_name);
        f.delete();
    }

    // Create directory
    public static void mkdir(String dir_name) {
        new File(dir_name).mkdirs();
    }

    // Write text to file line by line (OBS: it overwrites the file each time you open it)
    public static void writeTextToFile(String file_name) {
        try {
            PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    public static void writeBinaryToFile(String file_name) {
        byte data[] = ...
            FileOutputStream out = new FileOutputStream("the-file-name");
        out.write(data);
        out.close();
    }
    */

    // Read text from file line by line
    public static void printLinesOfFile(String file_name) {
        try {
            FileReader fr = new FileReader(file_name);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args )
    {
        System.out.println("Received " + Integer.toString(args.length) + " arguments");
        for (int i = 0; i < args.length; i++) {
            System.out.println("arg[" + Integer.toString(i) + "] = '" + args[i] + "'");
        }

        /*
        if (args.length == 0) {
            System.out.println("Start listing the content of ./");
            listDir(".");
        } else {
            for (int i = 0; i < args.length; i++) {
                listDir(args[i]);
            }
        }
        */

        /*
        mkdir("bibi");
        moveFile("bibi", "bibileanu");
        removeFile("bibileanu");
        */

        //writeTextToFile("bibi.txt");
        //printLinesOfFile("App.java");
    }
}
