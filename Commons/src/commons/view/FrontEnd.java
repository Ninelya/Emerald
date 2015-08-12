package commons.view;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrontEnd {
    private static final String ARIAL_BLACK = "Arial Black";
    private static final String ARIAL = "Arial";

    static public final Font FONT_BIG_TITLE = new Font(ARIAL_BLACK, Font.PLAIN, 22);
    static public final Font FONT_TITLE = new Font(ARIAL, Font.BOLD, 18);
    static public final Font FONT_BOLD = new Font(ARIAL, Font.BOLD, 15);
    static public final Font FONT_NORM = new Font(ARIAL, Font.PLAIN, 15);
    static public final Font FONT_BIG = new Font(ARIAL, Font.PLAIN, 18);

    static public final Color COLOR_LIGHT = new Color(221, 255, 204);
    static public final Color COLOR_DARK = new Color(0, 206, 123);

    static public final Dimension SIZE_WINDOW = new Dimension(800, 650);
    static public final Dimension SIZE_SPACER = new Dimension(50, 0);
    static public final Dimension SIZE_TEXT_FIELD = new Dimension(150, 0);
    static public final Dimension SIZE_BUTTON = new Dimension(100, 0);

    static public final int MESSAGE_GAP = 70;

    public static JPanel emptyPanel() {
        JPanel empty = new JPanel();
        empty.setBackground(Color.white);
        empty.setPreferredSize(new Dimension(1, 5));
        return empty;
    }

    static public final int COMBO_ITEM_0 = 0;
    static public final int COMBO_ITEM_1 = 1;
    static public final int COMBO_ITEM_2 = 2;
    static public final int COMBO_ITEM_3 = 3;
    static public final int COMBO_ITEM_4 = 4;
    static public final int COMBO_ITEM_5 = 5;

    public static String showDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(date);
    }
}