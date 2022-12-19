import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyApp {
    public static void main(String[] args) {

        FileNavigator fileNavigator = new FileNavigator();

// 1).  //Create data
        //Adding data to an object fileNavigator
        System.out.println("+++ Adding data to an object fileNavigator");
        initial(fileNavigator);

// 2).  Add file with invalid key
        System.out.println("\n+++ Add file with invalid key");
        String key = "d:\\ua.hillel\\";
        FileData file = new FileData("jarRepositories.xml", 864, "d:\\ua.hillel\\dictionary\\.idea\\");
        fileNavigator.add(key, file);

// 3).  Find files matching a given key
        System.out.println("\n+++ Find files matching a given key");
        List<FileData> files = fileNavigator.find("d:\\ua.hillel\\dictionary\\");
        for (FileData f: files) System.out.println(f);

        System.out.println("\n+++ Return file name matching a given key");
        System.out.println(fileNavigator.getFileName("d:\\ua.hillel\\dictionary\\"));                            //additional functionality

// 4).  Selection of files that meet the specified criteria - file size
        System.out.println("\n+++ Selection of files that meet the specified criteria - file size");
        fileNavigator.filterBySize(660).forEach(System.out::println);

// 5).  Deleting files in the specified path
        String path = "d:\\ua.hillel\\dictionary\\.idea\\";
        System.out.printf("\n+++ Deleting files in the specified path : %s - ", path);
        if (fileNavigator.remove(path)) System.out.println("done");

// 6).  Sort by file size
        System.out.println("\n+++ Sort by file size");
        fileNavigator.sortBySize().forEach(System.out::println);
    }


    static void initial(FileNavigator fileNavigator) {
        //create data
        List<FileData> fileData = new ArrayList<>(Arrays.asList(
                new FileData(".gitignore", 757, "d:\\ua.hillel\\dictionary\\"),
                new FileData("pom.xml", 651, "d:\\ua.hillel\\dictionary\\"),
                new FileData("README.md", 2500, "d:\\ua.hillel\\dictionary\\"),
                new FileData("FileData.java", 304, "d:\\ua.hillel\\dictionary\\src\\main\\java\\"),
                new FileData("FileNavigator.java", 663, "d:\\ua.hillel\\dictionary\\src\\main\\java\\"),
                new FileData("MyApp.java", 950, "d:\\ua.hillel\\dictionary\\src\\main\\java\\"),
                new FileData("compiler.xml", 543, "d:\\ua.hillel\\dictionary\\.idea\\")
        ));
        for (int i = 0; i < fileData.size(); i++) {
            String filePatch = fileData.get(i).getFilePatch();
            fileNavigator.add(filePatch, fileData.get(i));
        }
    }
}
