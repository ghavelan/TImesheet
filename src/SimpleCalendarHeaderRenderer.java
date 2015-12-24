import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by ghavelan on 24/12/15.
 *
 */
public class SimpleCalendarHeaderRenderer extends JLabel implements TableCellRenderer {

    public SimpleCalendarHeaderRenderer(){

        setFont(new Font("Consolas", Font.BOLD, 13));
        setOpaque(true);
        setForeground(Color.WHITE);
        setBackground(Color.BLUE);
        setBorder(BorderFactory.createEtchedBorder());
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
}
