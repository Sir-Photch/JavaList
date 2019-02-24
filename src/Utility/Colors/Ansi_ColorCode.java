package Utility.Colors;

/**
 * abstract class containing methods to print colorized text to console using ANSI-Colorcodes
 */
public abstract class Ansi_ColorCode {

    // Font Colors
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    // Background Colors
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // Special Actions
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_INVERSE = "\u001B[7m";

    /**
     * Prints given String to the Console with given color-modifiers
     *
     * @param string          text to be printed
     * @param fontColor       given color for the font to be.
     *                        Requires to be one of the values defined in the FontColor-Enum
     * @param backgroundColor given color for the Background.
     *                        Requres to be one of the values defined in the BackgroundColor-Enum
     */
    public static void printWithColor(String string, FontColor fontColor, BackgroundColor backgroundColor) {

        String font = null;
        String background = null;

        switch (fontColor) {
            case RED:
                font = ANSI_RED;
                break;
            case BLUE:
                font = ANSI_BLUE;
                break;
            case CYAN:
                font = ANSI_CYAN;
                break;
            case BLACK:
                font = ANSI_BLACK;
                break;
            case GREEN:
                font = ANSI_GREEN;
                break;
            case WHITE:
                font = ANSI_WHITE;
                break;
            case PURPLE:
                font = ANSI_PURPLE;
                break;
            case YELLOW:
                font = ANSI_YELLOW;
                break;
        }

        switch (backgroundColor) {
            case YELLOW:
                background = ANSI_YELLOW_BACKGROUND;
                break;
            case PURPLE:
                background = ANSI_PURPLE_BACKGROUND;
                break;
            case WHITE:
                background = ANSI_WHITE_BACKGROUND;
                break;
            case GREEN:
                background = ANSI_GREEN_BACKGROUND;
                break;
            case BLACK:
                background = ANSI_BLACK_BACKGROUND;
                break;
            case CYAN:
                background = ANSI_CYAN_BACKGROUND;
                break;
            case BLUE:
                background = ANSI_BLUE_BACKGROUND;
                break;
            case RED:
                background = ANSI_RED_BACKGROUND;
        }

        System.out.println(background + font + string + ANSI_RESET);
    }

    /**
     * Simple method to print given String in inverse Colors, e.g. Black Text on White Background.
     * Created to have a more simple method call, in order not to use printWithColor() every time, preventing code-clutter.
     *
     * @param string text to be printed in inverse colors.
     */
    public static void printInverse(String string) {
        System.out.println(ANSI_INVERSE + string + ANSI_RESET);
    }
}
