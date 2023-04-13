package madeby.common.data.validators;

public final class LongValidator {

    private LongValidator() {
    }

    public static boolean validate(long min, long max, long checkValue) {
        return leftValidate(min, checkValue) && rightValidate(max, checkValue);
    }

    public static boolean leftValidate(long min, long checkValue) {
        return checkValue >= min;
    }

    public static boolean rightValidate(long max, long checkValue) {
        return checkValue <= max;
    }
}
