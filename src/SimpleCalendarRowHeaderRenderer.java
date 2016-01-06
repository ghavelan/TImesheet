import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by ghavelan on 28/12/15.
 *
 */
public class SimpleCalendarRowHeaderRenderer extends DefaultTableCellRenderer {

    public SimpleCalendarRowHeaderRenderer() {

        setForeground(Color.BLACK);
        setBackground(new Color(249, 234, 137));
        setFont(new Font("Helvetica", Font.BOLD, 13));
        setBorder(BorderFactory.createRaisedBevelBorder());
        setHorizontalAlignment(JLabel.CENTER);

    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (value != null && value instanceof Day) {

            Day d = (Day) value;
            setText( "s "+d.getWeek());
        }

        return this;
    }
}
