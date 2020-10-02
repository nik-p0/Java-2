package Lesson1;

import java.awt.*;

public class Background {

    public static Color backgroundColor() {


        Color b = new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)
        );
        return b;

    }

}
