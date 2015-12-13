import javax.swing.*;
import java.awt.*;

/**
 * Created by ghavelan on 6/12/15.
 * To display a calendar table
 *
 */
public class SimpleCalendarFrame extends JFrame {

    public SimpleCalendarFrame(){

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2, screenHeight/2);
        setLocationByPlatform(true);

        //Model and renderer
        SimpleCalendarModel model = new SimpleCalendarModel();
        JTable calendar = new JTable(model);
        calendar.setDefaultRenderer(Object.class, new SimpleCalendarRender());

        //To avoid reordering of columns
        calendar.getTableHeader().setReorderingAllowed(false);

        SimpleCalendarPanel monthPanel = new SimpleCalendarPanel(model.getMonth());

        JPanel panelCalendar = new JPanel();

        panelCalendar.add(new JScrollPane(calendar));

        add(monthPanel, BorderLayout.NORTH);
        add(panelCalendar, BorderLayout.CENTER);

        //Resize the window, taking into account the preferred sizes of its components
        pack();
    }

}
