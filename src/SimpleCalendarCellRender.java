import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by ghavelan on 7/12/15.
 * To render the table
 */
public class SimpleCalendarCellRender extends DefaultTableCellRenderer {

    public SimpleCalendarCellRender() {

        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        cell.setFont(new Font("Helvetica Bold", Font.BOLD, 12));
        if (value != null && value instanceof Day) {

            Day d = (Day) value;
            cell.setForeground(d.getColor());
        }


        return cell;
    }

    @Override
    public void setValue(Object aValue) {
        Object result = aValue;
        if ((aValue != null) && (aValue instanceof Day)) {
            result = ((Day) aValue).getDay();
        }
        super.setValue(result);
    }
}
