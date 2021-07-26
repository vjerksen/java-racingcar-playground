package racing;

public class Racing {

    public static final int MIN_NAME_LEN = 0;
    public static final int MAX_NAME_LEN = 5;

    public String[] divideNameByComma(String undividedName) {
        return undividedName.split(",");
    }

    public boolean isNameLengthUnderFive(String dividedName) {
        if (MIN_NAME_LEN < dividedName.length() && dividedName.length() <= MAX_NAME_LEN) {
            return true;
        }
        return false;
    }
}
