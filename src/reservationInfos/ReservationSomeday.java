package reservationInfos;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * reservation from specific time(default it's today) and last numDays days.
 * @author koruk
 *
 */
public class ReservationSomeday extends ReservationDurationBase {	 
	
	//first day is needed,by default it is today
	public ReservationSomeday(int numDays) {	
		
		super(numDays);
		
	}
    
	public ReservationSomeday(Calendar firstDay, int numDays){
		super(firstDay, numDays);
	}
	
	public ReservationSomeday(Calendar... calendars){
		
		super(calendars);
		
	}

	@Override
	protected void ensureDatesPopulated() {
		// TODO Auto-generated method stub
		
	}
	
    @Override
	protected void onProccessCalendar(Calendar calendar) {
		// TODO Auto-generated method stub
		
	}

	

}
