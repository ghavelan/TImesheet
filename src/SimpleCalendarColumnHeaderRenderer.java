import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by ghavelan on 24/12/15.
 *
 */
public class SimpleCalendarColumnHeaderRenderer extends DefaultTableCellRenderer {

    public SimpleCalendarColumnHeaderRenderer(){


        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value != null && value instanceof String && !value.equals(" ")) {
            setForeground(Color.WHITE);
            setBackground(Color.BLUE);
            setFont(new Font("Helvetica", Font.BOLD, 13));
            setBorder(BorderFactory.createRaisedBevelBorder());

        }
        setText(value.toString());
        return this;
    }
}
