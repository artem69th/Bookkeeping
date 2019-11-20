import settings.Text;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        Text.init();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Roboto-Light.ttf")));
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error reading the font file", e);
        }
    }
}
