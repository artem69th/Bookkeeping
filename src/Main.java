import settings.Format;
import settings.Settings;
import settings.Text;
import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static settings.Settings.ROBOTO_FONT;

public class Main {

    public static void main(String[] args) {
        init();
        System.out.println(Format.dateMonth(new Date()));
    }

    private static void init() {
        Settings.init();
        Text.init();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, ROBOTO_FONT));
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error reading the font file", e);
        }
    }
}
