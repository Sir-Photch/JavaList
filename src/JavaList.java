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

    private static void filterDataTypeAndAppend(String entry, Map<String, List<String>> sortedEntryList) {

        if (entry.contains(".txt")) {
            checkAdd("txt", entry, sortedEntryList);
        } else if (entry.contains(".pdf")) {
            checkAdd("pdf", entry, sortedEntryList);
        } else if (entry.contains(".jpg") ||
                entry.contains(".JPG") ||
                entry.contains(".jpeg") ||
                entry.contains(".HEIC")) {
            checkAdd("pic", entry, sortedEntryList);
        } else if (entry.contains(".app")) {
            checkAdd("app", entry, sortedEntryList);
        }

        // Not specified Data-Types
        else {
            checkAdd("misc", entry, sortedEntryList);
        }

    }

    private static void checkAdd(String key, String entry, Map<String, List<String>> map) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(entry);
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
                for (String folderPath : sortedFileList.get("fldr")) {
                    System.out.println(folderPath);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("txt") && !sortedFileList.get("txt").isEmpty()) {
                printInverse("___ *.txt Files ");
                for (String txtPath : sortedFileList.get("txt")) {
                    printWithColor(txtPath, FontColor.BLUE, BackgroundColor.BLACK);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("pdf") && !sortedFileList.get("pdf").isEmpty()) {
                printInverse("___ *.pdf Files ");
                for (String pdfPath : sortedFileList.get("pdf")) {
                    printWithColor(pdfPath, FontColor.WHITE, BackgroundColor.RED);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("pic") && !sortedFileList.get("pic").isEmpty()) {
                printInverse("___ Pictures ");
                for (String picturePath : sortedFileList.get("pic")) {
                    printWithColor(picturePath, FontColor.BLACK, BackgroundColor.CYAN);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("app") && !sortedFileList.get("app").isEmpty()) {
                printInverse("___ Applications ");
                for (String appPath : sortedFileList.get("app")) {
                    printWithColor(appPath, FontColor.PURPLE, BackgroundColor.BLACK);
                }
                emptyLine();
            }
            if (sortedFileList.containsKey("misc") && !sortedFileList.get("misc").isEmpty()) {
                printInverse("___ Miscellaneous");
                for (String miscPath : sortedFileList.get("misc")) {
                    System.out.println(miscPath);
                }
                emptyLine();
            }

        } else {
            printWithColor(" No Entries found. Try different Directory ", FontColor.RED, BackgroundColor.WHITE);
        }
    }

}
