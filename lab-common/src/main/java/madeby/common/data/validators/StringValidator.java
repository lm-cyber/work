package madeby.common.data.validators;


public final class StringValidator {
    private StringValidator() {
    }

    public static boolean validate(int min, int max, String checkString) {
        return leftValidate(min, checkString) && rightValidate(max, checkString);
    }

    public static boolean leftValidate(int min, String checkString) {
        return checkString.length() >= min;
    }

    public static boolean rightValidate(int max, String checkString) {
        return checkString.length() <= max;
    }

}
