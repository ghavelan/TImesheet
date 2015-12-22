import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by ghavelan on 6/12/15.
 * To customize the content of the table
 */
public class SimpleCalendarModel extends AbstractTableModel {

    //Days
    final String[] columnNames = {"L", "M", "M", "J", "V", "S", "D"};
    //Calendar Object
    private GregorianCalendar gCal;
    //Number of rows needed (dynamically estimated, depending on month)
    private int nbRows;
    //To store the days
    private Day[][] data;
    final int MAX_ROWS = 7;

    public SimpleCalendarModel() {

        // construct gCal as current date
        gCal = new GregorianCalendar();
        update(gCal.get(Calendar.MONTH));

    }

    public void update(int month){

        //Current day
        int today = gCal.get(Calendar.DAY_OF_MONTH);

        // set gCal to the right month
        gCal.set(Calendar.MONTH, month);
        // set gCal to first day (1) of the month
        gCal.set(Calendar.DAY_OF_MONTH, 1);
        //Current month (0 : january to 11 : december)
        int cMonth = gCal.get(Calendar.MONTH);
        nbRows = 1;
        int col = 0;
        data = new Day[MAX_ROWS][columnNames.length];
        Day day;
        // set gCal to first day (1) of the month
        gCal.set(Calendar.DAY_OF_MONTH, 1);
        // corresponding day 1 (Sunday) to 7 (Saturday) --> 1 <-> 6,  2 <-> 0, etc
        int weekday = gCal.get(Calendar.DAY_OF_WEEK);
        // start a new line at the start of the week (Monday) : 1 <-> 6,  2 <-> 0, etc
        int shift = (weekday == GregorianCalendar.SUNDAY) ? 6 : weekday - 2;

        gCal.add(Calendar.DAY_OF_MONTH, -shift);

        do {

            day = new Day(gCal.get(Calendar.DAY_OF_MONTH), Color.BLACK);
            if (gCal.get(Calendar.MONTH) != cMonth) day.setColor(Color.lightGray);
            //Store the current day in order to highlight it
            if (day.getDay() == today) day.setColor(Color.red);

            data[nbRows - 1][col++] = day;
            // advance d to the next day
            gCal.add(Calendar.DAY_OF_MONTH, 1);

            if (gCal.get(Calendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY) {

                ++nbRows;
                col = 0;
            }

        } while (gCal.get(Calendar.MONTH) == cMonth || col < columnNames.length - 1);
        //Fill remaining cells (it means the beginning of next month)
        if (col < columnNames.length) {
            day = new Day(gCal.get(Calendar.DAY_OF_MONTH), Color.lightGray);
            data[nbRows - 1][col] = day;
        }
        //If different, it means next month -> return to current month
        if (gCal.get(Calendar.MONTH) != cMonth) {
            gCal.add(Calendar.MONTH, -1);
        }

    }

    @Override
    public int getRowCount() {
        return nbRows;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    //To get current month
    public String getMonth() {

        return gCal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE);

    }
    //To get current year
    public int getYear() {
        int year = gCal.get(Calendar.YEAR);
        return year;

    }

}
