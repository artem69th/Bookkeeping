package settings;

import java.text.DateFormatSymbols;

public class MainDateFormatSymbols extends DateFormatSymbols {

    @Override
    public String[] getMonths() {
        return Text.getMonths();
    }
}
