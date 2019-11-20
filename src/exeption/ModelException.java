package exeption;

import settings.Text;

public class ModelException extends Exception {

    public static final int TITLE_EMPTY = 1;
    public static final int IS_EXISTS = 2;
    public static final int DATE_FORMAT = 3;

    private final int code;

    public ModelException(int code) {
        this.code = code;
    }

    public String getMessage(int code) {
        switch (code) {
            case TITLE_EMPTY:
                return Text.get("TITLE_EMPTY_ERROR");
            default:
                return null;
        }
    }
}
