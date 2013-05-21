package reservationInfos;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * reservation from the first day of next month and last numDays days.
 * @author koruk
 *
 */
public class ReservationFromNextMonthDayOne extends ReservationSomeday{

	public ReservationFromNextMonthDayOne(int numDays) {
		super(numDays);		
	}
	
	@Override
	protected void ensureDatesPopulated() {
		// TODO Auto-generated method stub
		
	}
    
	@Override
	protected void onProccessCalendar(Calendar calendar) {
		// TODO Auto-generated method stub
		super.onProccessCalendar(calendar);
		int daysCountOfCurrentMonth = calendar.getMaximum(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, daysCountOfCurrentMonth - calendar.get(Calendar.DAY_OF_MONTH) + 1);
	}
}
