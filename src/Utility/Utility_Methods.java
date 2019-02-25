package Utility;

import Utility.Colors.BackgroundColor;
import Utility.Colors.FontColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static Utility.Colors.Ansi_ColorCode.printWithColor;
import static Utility.Utility_FileCheckers.*;

/**
 * Simple Helper class with Methods that do simple stuff
 */
public abstract class Utility_Methods {

    /**
     * Method to process input.
     *
     * @param args args that are passed on from program launch
     * @return returns either path, if a path was given, or null.
     */
    public static String inputParser(String[] args) {
        String path = null;

        for (String arg : args) {
            if (arg.equalsIgnoreCase("--help") || arg.equalsIgnoreCase("-help")) {
                emptyLine();
                printWithColor(" enter File-Path starting with: " + System.getProperty("file.separator") + " ", FontColor.BLACK, BackgroundColor.CYAN);
                printWithColor(" or leave empty if Bash-Script is configured. ", FontColor.BLACK, BackgroundColor.CYAN);
                printWithColor(" you can find a example Bash-Script on Github. ", FontColor.BLACK, BackgroundColor.CYAN);
                printWithColor(" type \"javalist --info\" for GitHub info. ", FontColor.BLACK, BackgroundColor.CYAN);
                emptyLine();
                break;
            } else if (arg.equalsIgnoreCase("--info") || arg.equalsIgnoreCase("-info")) {
                emptyLine();
                printWithColor(" You can find more information about JavaList on GitHub: ", FontColor.BLACK, BackgroundColor.CYAN);
                printWithColor(" https://github.com/Sir-Photch/JavaList ", FontColor.BLUE, BackgroundColor.BLACK);
                emptyLine();
                break;
            } else if (arg.startsWith(System.getProperty("file.separator"))) {
                path = arg;
                break;
            }
        }

        return path;
    }

    /**
     * Filters given String for data types and appends it to one of the hashed lists.
     *
     * @param fileString      File to process.
     * @param sortedEntryList List (Map) for the fileString to be added to.
     */
    public static void filterDataTypeAndAppend(String fileString, Map<String, List<String>> sortedEntryList) {

        if (isTextFile(fileString)) {
            checkAdd("text", fileString, sortedEntryList);

        } else if (isDataFile(fileString)) {
            checkAdd("data", fileString, sortedEntryList);

        } else if (isAudioFile(fileString)) {
            checkAdd("audio", fileString, sortedEntryList);

        } else if (isVideoFile(fileString)) {
            checkAdd("video", fileString, sortedEntryList);

        } else if (isImageFile(fileString)) {
            checkAdd("image", fileString, sortedEntryList);

        } else if (isSpreadsheetFile(fileString)) {
            checkAdd("spreadsheet", fileString, sortedEntryList);

        } else if (isDatabaseFile(fileString)) {
            checkAdd("database", fileString, sortedEntryList);

        } else if (isExecutable(fileString)) {
            checkAdd("executable", fileString, sortedEntryList);

        } else if (isWebFile(fileString)) {
            checkAdd("web", fileString, sortedEntryList);

        } else if (isSystemFile(fileString)) {
            checkAdd("system", fileString, sortedEntryList);

        } else if (isCompressedFile(fileString)) {
            checkAdd("compressed", fileString, sortedEntryList);

        } else if (isDiskImageFile(fileString)) {
            checkAdd("diskimage", fileString, sortedEntryList);

        } else if (isDeveloperFile(fileString)) {
            checkAdd("dev", fileString, sortedEntryList);

        }
        // Not specified Data-Types
        else {
            checkAdd("misc", fileString, sortedEntryList);
        }

    }

    /**
     * Helper-method to be used with {@code filterDataTypeAndAppend()}, in order to prevent code clutter.
     *
     * @param key   key for the {@code entry} to be saved at.
     * @param entry fileString to be saved.
     * @param map   List (Map) for everything to be saved to.
     */
    private static void checkAdd(String key, String entry, Map<String, List<String>> map) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(entry);
    }

    /**
     * Sorts every list in given Map alphabetically.
     *
     * @param data Map to sort
     * @return returns sorted map.
     */
    public static Map<String, List<String>> sortData(Map<String, List<String>> data) {

        for (Map.Entry<String, List<String>> entry : data.entrySet()) {
            Collections.sort(entry.getValue(), String.CASE_INSENSITIVE_ORDER);
        }

        return data;
    }

    /**
     * no-brainer, prevents code-clutter ;)
     */
    public static void emptyLine() {
        System.out.println();
    }

}
