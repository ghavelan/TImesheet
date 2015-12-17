import javax.swing.*;
import java.awt.*;

/**
 * Created by ghavelan on 6/12/15.
 * To display a calendar table
 *
 */
public class SimpleCalendarFrame extends JFrame {

    public SimpleCalendarFrame(){

        /*Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2, screenHeight/2);
        setLocationByPlatform(true);*/


        SimpleCalendarPanel calendar = new SimpleCalendarPanel();
        add(calendar, BorderLayout.NORTH);

        //Resize the window, taking into account the preferred sizes of its components
        pack();
    }

}
