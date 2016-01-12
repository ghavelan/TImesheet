import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by ghavelan on 8/12/15.
 *
 */
public class SimpleCalendarPanel extends JPanel {

    private JLabel month;
    private SimpleCalendarModel model;
    private JTable calendar;

    public SimpleCalendarPanel() {

        createPanel();
        calendar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    Day selected = (Day) calendar.getValueAt(row, column);
                    System.out.println(selected.getDay());
                }
            }
        });

    }

    private void createPanel(){

        //Set the layout manager
        this.setLayout(new BorderLayout());

        //Model
        this.model = new SimpleCalendarModel();
        calendar = new JTable(this.model);

        //Adding a week column at index 0
        TableColumn column = new TableColumn();
        column.setHeaderValue(" ");
        calendar.addColumn(column);
        //Renderer for the header (rows)
        column.setCellRenderer(new SimpleCalendarRowHeaderRenderer());
        calendar.moveColumn(7, 0);

        //Selection of only one cell
        calendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        calendar.setRowSelectionAllowed(true);
        calendar.setColumnSelectionAllowed(true);

        //Renderer for the cells
        calendar.setDefaultRenderer(Object.class, new SimpleCalendarCellRender());
        //Renderer for the header (columns)
        calendar.getColumnModel().getColumn(0).setHeaderRenderer(new SimpleCalendarCellRender());
        calendar.getTableHeader().setDefaultRenderer(new SimpleCalendarColumnHeaderRenderer());

        //Avoid reordering of columns
        calendar.getTableHeader().setReorderingAllowed(false);
        //Avoid resizing of column width
        calendar.getTableHeader().setResizingAllowed(false);

        //Month and calendar panels
        JPanel monthPanel = new JPanel();

        //Buttons
        JButton previous = new JButton(new ImageIcon("./images/previous.png"));
        JButton next = new JButton(new ImageIcon("./images/next.png"));
        previous.setBorder(BorderFactory.createEmptyBorder());
        next.setBorder(BorderFactory.createEmptyBorder());
        previous.setContentAreaFilled(false);
        next.setContentAreaFilled(false);

        //Listeners
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int m = model.getMonth();
                int y = model.getYear();
                if (m == 11) {
                    m = 0;
                    y += 1;
                } else {
                    m++;
                }
                model.update(m, y);
                month.setText(model.DisplayMonth() + " " + model.getYear());
                //Refresh model
                model.fireTableDataChanged();

            }
        });

        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int m = model.getMonth();
                int y = model.getYear();
                if (m == 0) {
                    m = 11;
                    y -= 1;
                } else {
                    m--;
                }
                model.update(m, y);
                month.setText(model.DisplayMonth() + " " + model.getYear());
                //Refresh model
                model.fireTableDataChanged();

            }
        });

        //Label
        this.month = new JLabel(model.DisplayMonth() + " " + model.getYear());

        //Adding panels to this
        monthPanel.add(previous);
        monthPanel.add(this.month);
        monthPanel.add(next);
        add(monthPanel, BorderLayout.NORTH);

        //Adding a scroll pane to the same height as the JTable
        JScrollPane scrollCalendar = new JScrollPane();
        //To get rid of the border
        scrollCalendar.setBorder(BorderFactory.createEmptyBorder());
        calendar.setPreferredScrollableViewportSize(calendar.getPreferredSize());
        scrollCalendar.setViewportView(calendar);
        add(scrollCalendar, BorderLayout.CENTER);
    }

    public int getCurrentDay(){
        return model.getCurrentDay();
    }
    public int getCurrentWeek(){return model.getCurrentWeek();}
    public int getCurrentMonth(){
        return model.getCurrentMonth()+1;
    }
    public int getCurrentYear(){
        return model.getCurrentYear();
    }

}
