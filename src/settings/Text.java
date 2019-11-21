package settings;

import java.util.HashMap;
import java.util.Map;

public class Text {
    private static final Map<String, String> data = new HashMap<>();

    public static String get(String key) {
        if (data.containsKey(key)) {
            return data.get(key);
        } else {
            System.out.println("Text dont contains key " + key);
            return null;
        }
    }

    public static String[] getMonths() {
        String[] months = new String[12];
        months[0] = get("JANUARY");
        months[1] = get("FEBRUARY");
        months[2] = get("MARCH");
        months[3] = get("APRIL");
        months[4] = get("MAY");
        months[5] = get("JUNE");
        months[6] = get("JULY");
        months[7] = get("AUGUST");
        months[8] = get("SEPTEMBER");
        months[9] = get("OCTOBER");
        months[10] = get("NOVEMBER");
        months[11] = get("DECEMBER");

        return months;
    }


    public static void init() {
        data.put("PROGRAM_NAME", "Домашняя бугалтерия");
        data.put("PROGRAM_VIEW", "Вид");
        data.put("PROGRAM_FILE", "Файл");
        data.put("PROGRAM_HELP", "Помощь");
        data.put("PROGRAM_EDIT", "Правка");

        data.put("JANUARY", "Январь");
        data.put("FEBRUARY", "Февраль");
        data.put("MARCH", "Март");
        data.put("APRIL", "Апрель");
        data.put("MAY", "Май");
        data.put("JUNE", "Июнь");
        data.put("JULY", "Июль");
        data.put("AUGUST", "Август");
        data.put("SEPTEMBER", "Сентябрь");
        data.put("OCTOBER", "Октябрь");
        data.put("NOVEMBER", "Ноябрь");
        data.put("DECEMBER", "Декабрь");

        data.put("TITLE_EMPTY_ERROR", "Вы не ввели название");
        data.put("YES", "Да");
        data.put("NO", "Нет");
    }
}
