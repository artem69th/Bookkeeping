package settings;

import com.sun.net.httpserver.Filter;
import model.Currency;
import model.DateFilter;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Format {

    public static String amount(double amount) {
        return String.format(Settings.FORMAT_AMOUNT, amount);
    }

    public static String amount(double amount, Currency currency) {
        return amount(amount) + " " + currency.getCode();
    }

    public static String rate(double rate) {
        return String.format(Settings.FORMAT_RATE, rate);
    }

    public static String rate(double rate, Currency currency) {
        return rate(rate) + " " + currency.getCode();
    }

    public static String date(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE);
    }

    public static String dateMonth(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_MONTH);
    }

    public static String dateYear(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_YEAR);
    }

    public static double fromAmounttoNumber(String amount) throws NumberFormatException {
        amount = amount.replace(",", ".");
        return Double.parseDouble(amount);
    }

    public static String yesNo(boolean yes) {

        if (yes) {
            return Text.get("YES");
        } else {
            return Text.get("NO");
        }
    }

    public static String getTitleFilter(DateFilter filter) {
        Date time = filter.getTo();
        switch (filter.getStep()) {
            case DateFilter.STEP_DAY:
                return date(time);
            case DateFilter.STEP_MONTH:
                return dateMonth(time);
            case DateFilter.STEP_YEAR:
                return dateYear(time);
            default:
                return null;
        }
    }

    private static String dateFormat(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, new MainDateFormatSymbols());
        return dateFormat.format(date);
    }

}
