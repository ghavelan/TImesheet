import javax.swing.*;

/**
 * Created by ghavelan on 8/12/15.
 *  *
 */
public class SimpleCalendarPanel extends JPanel {

    private JButton next;
    private JButton previous;
    private JLabel month;

    public SimpleCalendarPanel(String month){

        this.month = new JLabel(month);
        this.previous = new JButton("Previous");
        this.next = new JButton("Next");
        add(this.previous);
        add(this.month);
        add(this.next);
    }

}
