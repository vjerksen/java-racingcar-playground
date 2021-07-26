package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String str) {
        int returnValue = 0;

        if (isValid(str)) {
            return returnValue;
        }

        if (isLengthOne(str)) {
            return Integer.parseInt(str);
        }

        if (isExistCustomSeperator(str)) {
            return calculateCustomSeperator(str);
        }

        if (isExistCommaOrSemicolonSeperator(str)) {
            return calculateCommaOrSemicolonSeperator(str);
        }

        return returnValue;
    }

    private static int calculateCommaOrSemicolonSeperator(String str) {
        String[] numbers = str.split(",|:");
        return makeNumber(numbers);
    }

    private static int makeNumber(String[] numbers) {
        int returnValue = 0;
        for (String parsedStr : numbers) {
            returnValue += isExistNegativeNum(Integer.parseInt(parsedStr));
        }

        return returnValue;
    }

    private static int isExistNegativeNum(int parsedNum) {
        if (parsedNum < 0) {
            throw new RuntimeException("음수 입력");
        }
        return parsedNum;
    }

    private static int calculateCustomSeperator(String str) {
        int returnValue = 0;
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(str);

        if(matcher.find()) {
            String customDelimeter = matcher.group(1);
            String[] numbers = matcher.group(2).split(customDelimeter);

            returnValue = makeNumber(numbers);
        }
        return returnValue;
    }

    private static boolean isExistCommaOrSemicolonSeperator(String str) {
        String[] numbers = str.split(",|:");
        if (numbers.length > 0) {
            return true;
        }
        return false;
    }

    private static boolean isExistCustomSeperator(String str) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    private static boolean isLengthOne(String str) {
        if (str.length() == 1) {
            return true;
        }
        return false;
    }

    private static boolean isValid(String str) {
        if ("".equals(str) || str == null) {
            return true;
        }
        return false;
    }
}
