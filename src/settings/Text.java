package settings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Text {
    private static final Map<String, String> data = new HashMap<>();

    public static String get(String key) {
        return data.get(key);
    }

    public static List getMonths() {
        var monthsList = new ArrayList<>();
        monthsList.add(get("JANUARY"));
        monthsList.add(get("FEBRUARY"));
        monthsList.add(get("MARCH"));
        monthsList.add(get("APRIL"));
        monthsList.add(get("MAY"));
        monthsList.add(get("JUNE"));
        monthsList.add(get("JULY"));
        monthsList.add(get("AUGUST"));
        monthsList.add(get("SEPTEMBER"));
        monthsList.add(get("OCTOBER"));
        monthsList.add(get("NOVEMBER"));
        monthsList.add(get("DECEMBER"));
        return monthsList;
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
        data.put("MAY ", "Май");
        data.put("JUNE ", "Июнь");
        data.put("JULY ", "Июль");
        data.put("AUGUST", "Август");
        data.put("SEPTEMBER", "Сентябрь");
        data.put("OCTOBER", "Октябрь");
        data.put("NOVEMBER", "Ноябрь");
        data.put("DECEMBER", "Декабрь");

        data.put("TITLE_EMPTY_ERROR", "Вы не ввели название");
    }
}
