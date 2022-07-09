package com.epam.rd.autotasks.words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (words == null || sample == null) {
            return 0;
        }

        int equalCounter = 0;
        sample = sample.trim();
        for (String word : words) {
            word = word.trim();
            if (word.equalsIgnoreCase(sample)) {
                equalCounter++;
            }
        }
        return equalCounter;
    }

    public static String[] splitWords(String text) {
        if (text == null || text == "") {
            return null;
        }

        //String[] words = text.split("[.,;: ?!]");
        String delimiters = "[.,;: ?!]";
        StringTokenizer tockenizer = new StringTokenizer(text, delimiters);
        ArrayList<String> words = new ArrayList<String>();
        while (tockenizer.hasMoreTokens()) {
            words.add(tockenizer.nextToken());
        }

        if (words.size() == 0) {
            return null;
        }

        String[] wordsArray = new String[words.size()];
        words.toArray(wordsArray);
        return wordsArray;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.isEmpty()) {
            return null;
        }

        if (toWin) {
            return convertUnixToWindows(path);
        } else {
            return convertWindowsToUnix(path);
        }
    }

    public static String joinWords(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        int emptyLinesCounter = 0;
        StringBuilder result = new StringBuilder("[");
        for (String word : words) {
            if (word.length() == 0) {
                emptyLinesCounter++;
                continue;
            }
            result.append(word);
            result.append(", ");
        }

        if (emptyLinesCounter == words.length) {
            return null;
        }

        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }

    private static boolean isWindowsPath(String path) {
        //String patternString = "((C:[\\w ]+|\\.|\\.\\.)?(\\\\([\\w ]+|\\.|\\.\\.))*\\\\)?([\\w ]*(\\.[\\w ]*)?)?";
        //String patternString = "((C:|\\.|\\.\\\\.)?\\\\)?(([\\w ]+|\\.|\\.\\.)\\\\)*([\\w ]*(\\.[\\w ]*)?)?";
        String patternString = "((C:|\\.|\\.\\\\.)?\\\\?)?(([\\w ]+|\\.|\\.\\.)\\\\)*([\\w ]*(\\.[\\w ]*)?)?";
        return Pattern.matches(patternString, path);
    }

    private static boolean isUnixPath(String path) {
        //String patternString = "~|(((~)?/)?(([\\w ]+|\\.|\\.\\.)/)*(([\\w ]+(\\.[\\w ]*)?))?)";
        //String patternString = "(((~|..|.)?/?)?(([\\w ]+|\\.|\\.\\.)/)*(([\\w ]+(\\.[\\w ]*)?))?)";
        String patternString = "(~|..|.)?((/?)?(([\\w ]+|\\.|\\.\\.)/)*(([\\w ]+(\\.[\\w ]*)?))?)?";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(path);
        if (!matcher.find()){
            return false;
        }
        else{
            if(matcher.end() - matcher.start() != path.length()){
                return false;
            }
            return true;
        }
        //return Pattern.matches(patternString, path);
    }

    private static String convertUnixToWindows(String path) {
        if (isWindowsPath(path)) {
            return path;
        }

        if (!isUnixPath(path)) {
            return null;
        }

        if (path.charAt(0) == '/') {
            path = "C:\\" + path.substring(1);
        }
        path = path.replaceAll("~", "C:\\\\User");
        path = path.replaceAll("/", "\\\\");
        return path;
    }

    private static String convertWindowsToUnix(String path) {
        if (isUnixPath(path)) {
            return path;
        }

        if (!isWindowsPath(path)) {
            return null;
        }

        path = path.replace("C:\\User", "~");
        path = path.replace("C:\\", "/");
        path = path.replaceAll("\\\\", "/");
        return path;
    }

    public static void main(String[] args) {
        //System.out.println(Pattern.matches("((~|..|.)?/?)?","~\" ));
        //System.out.println(isWindowsPath("C:\\User\\secret\\dont_look.txt"));
        System.out.println(isUnixPath("~\\a"));
        String win = "~\\folder";
        String unix = "~/secret/dont_look.tx";
        System.out.println(convertPath(win, false));
        System.out.println(convertPath(unix, true));
        /*String unixPath = "/root/logs/end.log";
        String winPath = "C:\\root\\logs\\end.log";
        System.out.println(convertPath(unixPath, true));*/
        /*System.out.println(isUnixPath("/folder/../folder/file.txt"));
        System.out.println(isUnixPath("/dev/null"));
        System.out.println(isUnixPath("file.txt"));
        System.out.println(isUnixPath("folder/logs/"));
        System.out.println(isUnixPath("~/user/some_logs"));*/

        /*System.out.println(isWindowsPath("file.txt"));
        System.out.println(isWindowsPath("\\Program Files\\some_file.exe"));
        System.out.println(isWindowsPath(".\\to_do_list.txt"));
        System.out.println(isWindowsPath("C:\\Users\\..\\Cygwin\\"));
        System.out.println(isWindowsPath(".\\file"));*/
        //String text = "123...495;;024, 77, 1231, 55";
        /*String text = "abc...ab;;abc, ab, abc, ab";
        String[] words = splitWords(text);
        System.out.println(words.length);
        for (String word:words){
            System.out.println(word);
        }*/

        /*System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);*/
    }
}