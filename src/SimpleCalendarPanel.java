import javax.swing.*;

/**
 * Created by ghavelan on 8/12/15.
 *
 */
public class SimpleCalendarPanel extends JPanel {

    private JButton next;
    private JButton previous;
    private JLabel month;

    public SimpleCalendarPanel(String month){

        this.previous = new JButton(new ImageIcon("./images/previous.png"));
        this.next = new JButton(new ImageIcon("./images/next.png"));
        this.previous.setBorder(BorderFactory.createEmptyBorder());
        this.next.setBorder(BorderFactory.createEmptyBorder());
        this.previous.setContentAreaFilled(false);
        this.next.setContentAreaFilled(false);

        this.month = new JLabel(month);

        add(this.previous);
        add(this.month);
        add(this.next);
    }

}
