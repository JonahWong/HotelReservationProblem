package reservationInfos;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * reservation from next Monday and last numDays days.
 * @author koruk
 *
 */
public class ReservationFromNextMonday extends ReservationSomeday{

	public ReservationFromNextMonday(int numDays) {
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
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.SUNDAY) {
			calendar.add(Calendar.DATE, 1);
		}else {
			calendar.add(Calendar.DATE, 7 - dayOfWeek + 2);
		}
	}
    
}
