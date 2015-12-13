import javax.swing.*;
import java.awt.*;
import java.util.Locale;

/**
 * Created by ghavelan on 5/12/15.
 *
 */
public class Timesheet {


    public static void main(String[] args) {

        Locale.setDefault(Locale.FRANCE);

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                JFrame frame = new SimpleCalendarFrame();
                frame.setTitle("Calendar");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });

    }
}


