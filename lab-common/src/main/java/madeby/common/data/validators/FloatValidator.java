package madeby.common.data.validators;


public final class FloatValidator {

    private FloatValidator() {
    }
    public static boolean validate(float min, float max, float checkValue) {
        return leftValidate(min, checkValue) && rightValidate(max, checkValue);
    }

    public static boolean leftValidate(float min, float checkValue) {
        return checkValue >= min;
    }

    public static boolean rightValidate(float max, float checkValue) {
        return checkValue <= max;
    }
}
