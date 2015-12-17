import javax.swing.*;
import java.awt.*;

/**
 * Created by ghavelan on 8/12/15.
 *
 */
public class SimpleCalendarPanel extends JPanel {

    private JButton next;
    private JButton previous;
    private JLabel month;

    public SimpleCalendarPanel(){

        //Set the layout manager
        this.setLayout(new BorderLayout());

        //Model and renderer
        SimpleCalendarModel model = new SimpleCalendarModel();
        JTable calendar = new JTable(model);
        calendar.setDefaultRenderer(Object.class, new SimpleCalendarRender());
        calendar.getTableHeader().setReorderingAllowed(false);

        //Month and calendar panels
        JPanel monthPanel = new JPanel();
       
        //Buttons
        this.previous = new JButton(new ImageIcon("./images/previous.png"));
        this.next = new JButton(new ImageIcon("./images/next.png"));
        this.previous.setBorder(BorderFactory.createEmptyBorder());
        this.next.setBorder(BorderFactory.createEmptyBorder());
        this.previous.setContentAreaFilled(false);
        this.next.setContentAreaFilled(false);

        //Label
        this.month = new JLabel(model.getMonth());

        //Adding panels to this
        monthPanel.add(this.previous);
        monthPanel.add(this.month);
        monthPanel.add(this.next);
        add(monthPanel, BorderLayout.NORTH);
        add(new JScrollPane(calendar), BorderLayout.CENTER);
    }

}
