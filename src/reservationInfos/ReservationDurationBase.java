package reservationInfos;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * Base class for all kind of predefined reservation data model
 * @author koruk
 *
 */
public abstract class ReservationDurationBase {
	/**
	 * Keys for map that represent the weekday count and weekend count.
	 */
    public static final String KEY_WEEKEND = "weekend";
	public static final String KEY_WEEKDAY = "weekday";
	
	public static final String HINT_WHICH_DAY = "Which day are you checking in? " + 
					                    "\n¢ÙIf today,hit 1;\n¢ÚIf tomorrow hit 2;\n¢ÛIf next Monday,hit 11," + 
									    "\n¢ÜIf the first day in next month,hit 111"+ 
					                    "\n¢ÝOtherwise input with the following format: 2013-05-20. or it will go wrong.Take care!";
	public static final String HINT_COSTOMER_NUM_DAYS = "How many days are you reserving for?If 3 days,then simply hit 3";
	public static final String HINT_COSTOMER_TYPE = "If you are a rewarded member,hit 1 \nIf you are a regular one, you will hit 0";
		
	
	protected Calendar startDate;
    protected Calendar endDate;    
    protected int numDays;
    
    protected Map<String, Integer> weekdayWeekendCounts;
    
    public ReservationDurationBase(int numDays){    	
    	countWeekdayAndWeekend(getProperCalendar(), numDays);
    }
    /**
     * not continual reservation
     * curently not used
     * @param calendars
     */
    public ReservationDurationBase(Calendar...calendars){
    	countWeekdayAndWeekend(calendars);
    }
    
    public ReservationDurationBase(Calendar firstDay, int numDays) {
		countWeekdayAndWeekend(firstDay, numDays);
	}
    /**
     * judge wheather specified day is a weekend
     * used for obtain the Map instance for weekday and weekend count
     * @param calendar
     * @return
     */
	protected boolean isWeekend(Calendar calendar){
    	int day = calendar.get(Calendar.DAY_OF_WEEK); 
    	return day == Calendar.SATURDAY || day == Calendar.SUNDAY;
    }
    
	/**
	 * reserved api that is currently not used yet.
	 */
    protected abstract void ensureDatesPopulated();
    
    /**
     * Calculate the count for weekday and weekend 
     * for the future calculating the cheapest hotel
     * @param firstDay check in time
     * @param numDays  duration of staying in the hotel
     * @return Map for weeday and weekend count
     */
    protected Map<String, Integer> countWeekdayAndWeekend(Calendar firstDay, int numDays) {
    	this.startDate = firstDay;
		this.numDays = numDays;
		
		Calendar calendar = (Calendar) firstDay.clone();
		calendar.add(Calendar.DAY_OF_MONTH, numDays - 1);		
		this.endDate = calendar;
		
		int weekendCount = 0;
		
		if(isWeekend(firstDay)){
			weekendCount++;
		}
		
		for (int i = 1; i < numDays; i++) {
			firstDay.add(Calendar.DATE, 1);
			if(isWeekend(firstDay)){
				weekendCount++;
			}
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(ReservationDurationBase.KEY_WEEKEND, weekendCount);
		map.put(ReservationDurationBase.KEY_WEEKDAY, numDays - weekendCount);
		weekdayWeekendCounts =map;
		return weekdayWeekendCounts;
	}
    
    /** 
     * not continully checked in,maybe with some interval
     * currently not used
     * @param calendars
     * @return Map for weeday and weekend count
     */
    protected Map<String, Integer> countWeekdayAndWeekend(Calendar... calendars){
    	this.startDate = calendars[0];		
		this.numDays = calendars.length;
		this.endDate = calendars[numDays - 1];
		
    	int weekendCount = 0;
    	for (Calendar calendar : calendars) {
			if(isWeekend(calendar)){
				weekendCount++;
			}
		}
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	map.put(ReservationDurationBase.KEY_WEEKDAY, calendars.length - weekendCount);
    	map.put(ReservationDurationBase.KEY_WEEKEND, weekendCount);
    	this.weekdayWeekendCounts = map;
    	return weekdayWeekendCounts;
    }
    
    
    /**
     * 
     * @return return appropriate calendar instance for different predefined reservation model.
     */
    protected Calendar getProperCalendar(){
    	Calendar calendar = Calendar.getInstance(Locale.getDefault());
    	onProccessCalendar(calendar);
    	return calendar;
    }
    /**
     * process to get the first day calendar,will call back to this when first day is needed
     * By default,the first day to check in is today.To change that,you need to override this method
     * @param calendar
     */
	protected abstract void onProccessCalendar(Calendar calendar);
	
	public Map<String, Integer> getWeekdayWeekendCounts(){
		return weekdayWeekendCounts;
	}
    
}
