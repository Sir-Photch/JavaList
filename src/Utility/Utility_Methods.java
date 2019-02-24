package Utility;

import Utility.Colors.BackgroundColor;
import Utility.Colors.FontColor;

import java.util.*;

import static Utility.Colors.Ansi_ColorCode.printWithColor;

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
     * Helper method to create a HashMap that retains all data-types to be sorted
     *
     * @return returns the newly created Hashmap.
     */
    public static Map<String, List<String>> createDataTypeHashMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("fldr", new ArrayList<>());
        map.put("txt", new ArrayList<>());
        map.put("pdf", new ArrayList<>());
        map.put("pic", new ArrayList<>());
        map.put("app", new ArrayList<>());
        map.put("misc", new ArrayList<>());
        return map;
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
