import Utility.Colors.BackgroundColor;
import Utility.Colors.FontColor;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static Utility.Colors.Ansi_ColorCode.printInverse;
import static Utility.Colors.Ansi_ColorCode.printWithColor;
import static Utility.Utility_Methods.*;

/**
 * @author Sir-Photch on GitHub
 */
public class JavaList {

    public static void main(String[] args) throws IOException {

        // Call args-parser to get filePath. If it is null, stop the program.
        String pathString = inputParser(args);
        if (pathString == null) return;

        // create DirectoryStream to be iterated over in the printMap()-call
        Path path = Paths.get(pathString);
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
        printMap(
                manageEntryList(directoryStream.iterator(), pathString)
        );

        directoryStream.close();
    }

    /**
     * "Most important Method"
     * here, the sorting by type takes place
     * TODO apps sometimes being recognized as folders and vice versa
     *
     * @param pathIterator the provided directoryStream.iterator to iterate
     *                     over every entry in the provided directory
     * @param pathString   the String providing the Path
     *                     for the entries to be cut off
     * @return calls the sortData()-Method from abstract Class Utility_Methods in package .Utility,
     * to sort the given Lists in the HashMap alphabetically
     */
    private static Map<String, List<String>> manageEntryList(Iterator<Path> pathIterator, String pathString) {

        // Check if anything present
        if (!pathIterator.hasNext()) return null;

        // Make Lists for Folders and Files
        List<String> folderList = new ArrayList<>();
        List<String> fileList = new ArrayList<>();
        while (pathIterator.hasNext()) {
            Path path = pathIterator.next();
            String shortPathString = path.toString().substring(pathString.length());

            if (Files.isDirectory(path)) folderList.add(shortPathString);
            else fileList.add(shortPathString);
        }

        // create predefined Hash-Structure for Lists to be stored in divided by filetype
        Map<String, List<String>> sortedEntryList = new HashMap<>();

        // add all Folders, if present
        if (!folderList.isEmpty())
            sortedEntryList.computeIfAbsent("fldr", k -> new ArrayList<>()).addAll(folderList);

        // add Files sorted by File-Type, if present
        Iterator<String> e = fileList.iterator();
        while (e.hasNext()) {
            String entry = e.next();
            filterDataTypeAndAppend(entry, sortedEntryList);
            e.remove(); // Remove entry to prevent double entries
        }

        return sortData(sortedEntryList);
    }

    /**
     * Prints given Map to console, sorted by Filetype.
     *
     * @param sortedFileList sorted Map to Print. If {@code null}, prints out that no entries were found.
     */
    private static void printMap(Map<String, List<String>> sortedFileList) {

        if (sortedFileList != null) {

            emptyLine();
            if (sortedFileList.containsKey("fldr") && !sortedFileList.get("fldr").isEmpty()) {
                printInverse("___ Folders ");
                for (String path : sortedFileList.get("fldr")) {
                    System.out.println(path);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("text") && !sortedFileList.get("text").isEmpty()) {
                printInverse("___ TEXT Files ");
                for (String path : sortedFileList.get("text")) {
                    printWithColor(path, FontColor.BLUE, BackgroundColor.BLACK);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("data") && !sortedFileList.get("data").isEmpty()) {
                printInverse("___ DATA Files ");
                for (String path : sortedFileList.get("data")) {
                    printWithColor(path, FontColor.WHITE, BackgroundColor.RED);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("audio") && !sortedFileList.get("audio").isEmpty()) {
                printInverse("___ AUDIO Files ");
                for (String path : sortedFileList.get("audio")) {
                    printWithColor(path, FontColor.BLACK, BackgroundColor.CYAN);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("video") && !sortedFileList.get("video").isEmpty()) {
                printInverse("___ VIDEO Files ");
                for (String path : sortedFileList.get("video")) {
                    printWithColor(path, FontColor.PURPLE, BackgroundColor.BLACK);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("image") && !sortedFileList.get("image").isEmpty()) {
                printInverse("___ IMAGE Files");
                for (String path : sortedFileList.get("image")) {
                    System.out.println(path);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("spreadsheet") && !sortedFileList.get("spreadsheet").isEmpty()) {
                printInverse("___ SPREADSHEET Files");
                for (String path : sortedFileList.get("spreadsheet")) {
                    System.out.println(path);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("database") && !sortedFileList.get("database").isEmpty()) {
                printInverse("___ DATABASE Files");
                for (String path : sortedFileList.get("database")) {
                    System.out.println(path);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("executable") && !sortedFileList.get("executable").isEmpty()) {
                printInverse("___ EXECUTABLE Files");
                for (String path : sortedFileList.get("executable")) {
                    System.out.println(path);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("web") && !sortedFileList.get("web").isEmpty()) {
                printInverse("___ WEB Files");
                for (String path : sortedFileList.get("web")) {
                    System.out.println(path);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("system") && !sortedFileList.get("system").isEmpty()) {
                printInverse("___ SYSTEM Files");
                for (String path : sortedFileList.get("system")) {
                    System.out.println(path);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("compressed") && !sortedFileList.get("compressed").isEmpty()) {
                printInverse("___ COMPRESSED Files");
                for (String path : sortedFileList.get("compressed")) {
                    System.out.println(path);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("diskimage") && !sortedFileList.get("diskimage").isEmpty()) {
                printInverse("___ DISKIMAGE Files");
                for (String path : sortedFileList.get("diskimage")) {
                    System.out.println(path);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("dev") && !sortedFileList.get("dev").isEmpty()) {
                printInverse("___ DEVELOPER Files");
                for (String path : sortedFileList.get("dev")) {
                    System.out.println(path);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("misc") && !sortedFileList.get("misc").isEmpty()) {
                printInverse("___ OTHER Files");
                for (String path : sortedFileList.get("misc")) {
                    System.out.println(path);
                }
                emptyLine();
            }

        } else {
            printWithColor(" No Entries found. Try different Directory ", FontColor.RED, BackgroundColor.WHITE);
        }
    }

}
