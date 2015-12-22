import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        //Model
        SimpleCalendarModel model = new SimpleCalendarModel();
        JTable calendar = new JTable(model);
        //Selection of only one cell
        calendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        calendar.setRowSelectionAllowed(true);
        calendar.setColumnSelectionAllowed(true);
        //Renderer
        calendar.setDefaultRenderer(Object.class, new SimpleCalendarRender());
        //Avoid reordering of columns
        calendar.getTableHeader().setReorderingAllowed(false);
        //Avoid resizing of column width
        calendar.getTableHeader().setResizingAllowed(false);

        //Month and calendar panels
        JPanel monthPanel = new JPanel();

        //Buttons
        this.previous = new JButton(new ImageIcon("./images/previous.png"));
        this.next = new JButton(new ImageIcon("./images/next.png"));
        this.previous.setBorder(BorderFactory.createEmptyBorder());
        this.next.setBorder(BorderFactory.createEmptyBorder());
        this.previous.setContentAreaFilled(false);
        this.next.setContentAreaFilled(false);

        //Listeners
        this.next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click!");
            }
        });

        this.previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click!");
            }
        });

        //Label
        this.month = new JLabel(model.getMonth()+" "+model.getYear());

        //Adding panels to this
        monthPanel.add(this.previous);
        monthPanel.add(this.month);
        monthPanel.add(this.next);
        add(monthPanel, BorderLayout.NORTH);
        add(new JScrollPane(calendar), BorderLayout.CENTER);
    }

}
