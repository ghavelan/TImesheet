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
    final int MAX_ROWS = 7;
    //Calendar Object
    private GregorianCalendar gCal;
    //Number of rows needed (dynamically estimated, depending on month)
    private int nbRows;
    //To store the days
    private Day[][] data;
    //Current day
    private int today;
    //Current month (0 : january to 11 : december)
    private int cMonth;
    //Current year
    private int cYear;

    public SimpleCalendarModel() {

        // construct gCal as current date
        gCal = new GregorianCalendar();
        today = gCal.get(Calendar.DAY_OF_MONTH);
        cMonth = gCal.get(Calendar.MONTH);
        cYear = gCal.get(Calendar.YEAR);
        update(gCal.get(Calendar.MONTH), gCal.get(Calendar.YEAR));

    }

    public void update(int month, int year) {

        // set gCal to the right month
        gCal.set(Calendar.MONTH, month);

        // set gCal to the right year
        gCal.set(Calendar.YEAR, year);

        // set gCal to first day (1) of the month
        gCal.set(Calendar.DAY_OF_MONTH, 1);

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
            if (gCal.get(Calendar.MONTH) != month) day.setColor(Color.lightGray);
            //Store the current day in order to highlight it
            if (day.getDay() == today && gCal.get(Calendar.MONTH) == cMonth && gCal.get(Calendar.YEAR) == cYear)
                day.setColor(Color.red);

            data[nbRows - 1][col++] = day;
            // advance d to the next day
            gCal.add(Calendar.DAY_OF_MONTH, 1);

            if (gCal.get(Calendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY) {

                ++nbRows;
                col = 0;
            }

        } while (gCal.get(Calendar.MONTH) == month || col < columnNames.length - 1);
        //Fill remaining cells (it means the beginning of next month)
        if (col < columnNames.length) {
            day = new Day(gCal.get(Calendar.DAY_OF_MONTH), Color.lightGray);
            data[nbRows - 1][col] = day;
        }
        //If different, it means next month -> return to current month
        if (gCal.get(Calendar.MONTH) != month) {
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
    public String DisplayMonth() {

        return gCal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE);

    }

    //To get current month
    public int getMonth() {

        return gCal.get(Calendar.MONTH);

    }

    //To get current year
    public int getYear() {

        return gCal.get(Calendar.YEAR);

    }

}
