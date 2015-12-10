import javax.swing.*;
import java.awt.*;

/**
 * Created by ghavelan on 6/12/15.
 * To display a calendar table
 *
 */
public class SimpleCalendarFrame extends JFrame {

    public SimpleCalendarFrame(){

        SimpleCalendarModel model = new SimpleCalendarModel();
        JTable calendar = new JTable(model);
        calendar.getTableHeader().setReorderingAllowed(false);
        JLabel month = new JLabel(model.getMonth(), SwingConstants.HORIZONTAL);
        calendar.setDefaultRenderer(Object.class, new SimpleCalendarRender());
        add(month, BorderLayout.NORTH);
        add(calendar, BorderLayout.CENTER);
        add(new JScrollPane(calendar));
        pack();
    }

}
