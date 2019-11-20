package settings;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

public class Settings {

    public static final File ROBOTO_FONT = new File("resources/fonts/Roboto-Light.ttf");
    public static final File SAVE_DIR = new File("resources/saves/");
    public static final String SAVE_FILE_EXP = "myrus";

    public static final String FORMAT_AMOUNT = "%.2f";
    public static final String FORMAT_RATE = "%.4f";
    public static final String FORMAT_DATE = "dd.MM.yyyy";
    public static final String FORMAT_DATE_MONTH = "MMMM yyyy";
    public static final String FORMAT_DATE_YEAR = "yyyy";

    public static final int COUNT_OVERVIEW_ROWS = 10;
    public static final List<String> CURRENTCIES_CODES = List.of("RUB", "USD", "EUR", "UAN");

    private static final File FILE_SETTINGS = new File("resources/saves/settings.ini");
    private static File FILE_SAVE = new File("resources/saves/default.myrus");

    public static void init() {
        try {
            Ini ini = new Ini(FILE_SETTINGS);
            Preferences preferences = new IniPreferences(ini);
            String file = preferences.node("Settings").get("SAVE_FILE", null);
            if (file != null) {
                FILE_SAVE = new File(file);
            }
            setLocale();
        } catch (IOException e) {
           save();
        }
    }

    private static void setLocale() {
        Locale.setDefault(new Locale("ru"));
    }

    public static File getFileSave() {
        return FILE_SAVE;
    }

    public static void setFileSave(File fileSave) {
        FILE_SAVE = fileSave;
        save();
    }

    private static void save() {
        try {
            Wini ini = new Wini(FILE_SETTINGS);
            ini.put("Settings", "FILE_SAVE", FILE_SAVE.getAbsolutePath().replace("\\", "\\\\"));
            ini.store();
        } catch (IOException e) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
