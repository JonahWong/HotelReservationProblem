package reservationInfos;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * reservation from tomorrow and last numDays days.
 * @author koruk
 *
 */
public class ReservationFromTomorrow extends ReservationSomeday{

	public ReservationFromTomorrow(int numDays) {
		
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
		calendar.add(Calendar.DATE, 1);
	}
    
}
