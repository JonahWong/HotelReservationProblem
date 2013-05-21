package hotelReservation;

import hotelInfos.AFormula;
import hotelInfos.Bridgewood;
import hotelInfos.Hotel;
import hotelInfos.Lakewood;
import hotelInfos.Ridgewood;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import processFlow.IProcessFlow;
import reservationInfos.CustomerReservationInfo;
import reservationInfos.PromptInfo;
import reservationInfos.ReservationDurationBase;
import reservationInfos.ReservationFromNextMonday;
import reservationInfos.ReservationFromNextMonthDayOne;
import reservationInfos.ReservationFromNow;
import reservationInfos.ReservationFromTomorrow;
import reservationInfos.ReservationSomeday;

/**
 * Application entry 
 * @author koruk
 *
 */
public class Main{

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		
		//a collection of Hotels.
		List<AFormula> allHotels = new ArrayList<AFormula>();
		AFormula lakeWood = new Lakewood();
		AFormula bridgeWood = new Bridgewood();
		AFormula ridgeWood = new Ridgewood();
		allHotels.add(lakeWood);
		allHotels.add(bridgeWood);
		allHotels.add(ridgeWood);		
		
		
		new ArrayList<Calendar>();
		int customerType = 0;
		int numDays;
		PromptInfo.showMessage(ReservationDurationBase.HINT_COSTOMER_TYPE);
		Scanner scanner = new Scanner(System.in);
		/**
		 * waiting for user to input their persional infos and demands.
		 */
		while (scanner.hasNext()) {
			customerType = scanner.nextInt();
			PromptInfo.showMessage(ReservationDurationBase.HINT_COSTOMER_NUM_DAYS);
			numDays = scanner.nextInt();
            /**
             * handle center for the reservation preccess
             */
			ReservationFlow reservationFlow = new ReservationFlow(allHotels);
			//callback when specify the dates.
			reservationFlow.onInputDate(scanner, numDays,customerType);				
			
		}				
	}
	
	/**
	 * class that used to handle the reservation process flow
	 * @author koruk
	 *
	 */
    public static class ReservationFlow implements IProcessFlow{
    	
    	private Pattern pattern;
		private SimpleDateFormat sdf;
		private List<Calendar> calendars;
		private List<AFormula> allHotels;

		public ReservationFlow(List<AFormula> allHotels){
    		this.pattern = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
    		this.sdf = new SimpleDateFormat("yyyy-MM-dd");
    		this.calendars = new ArrayList<Calendar>();
    		this.allHotels = allHotels;
    	}

		/**
		 * checkinTimeType specify When to start check in.1 for checking in from today; 2 for tomorrow; 11 for next week; 111 for next month.
		 */
    	@Override
    	public void onInputDate(Scanner scanner, int numDays, int customerType){     		
    		
    		PromptInfo.showMessage(ReservationDurationBase.HINT_WHICH_DAY);
    		if (scanner.hasNextInt()) {
    			int checkinTimeType = scanner.nextInt();
    			//specific time type
    			if (checkinTimeType == 1) {
    				  				    				
    				ReservationFromNow reservationFromNow = new ReservationFromNow(numDays);  
    				CustomerReservationInfo customerReservationInfo = new CustomerReservationInfo(customerType, reservationFromNow);
    				String cheapestHotel = Hotel.whichIsCheapest(customerReservationInfo, allHotels.toArray(new AFormula[allHotels.size()]));
    				
    				//String cheapestHotel = Hotel.whichIsCheapest(customerType, reservationFromNow, allHotels.toArray(new AFormula[allHotels.size()]));
    				System.out.println("The cheapest hotel is: " + cheapestHotel);
    				
    				
    			} else if (checkinTimeType == 2) {
    				
    				ReservationFromTomorrow reservationFromTomorrow = new ReservationFromTomorrow(numDays);
    				CustomerReservationInfo customerReservationInfo = new CustomerReservationInfo(customerType, reservationFromTomorrow);
    				String cheapestHotel = Hotel.whichIsCheapest(customerReservationInfo, allHotels.toArray(new AFormula[allHotels.size()]));
    				
    				//String cheapestHotel = Hotel.whichIsCheapest(customerType, reservationFromTomorrow, allHotels.toArray(new AFormula[allHotels.size()]));
    				System.out.println("The cheapest hotel is: " + cheapestHotel);
    				
    			} else if (checkinTimeType == 11) {
    				
    				ReservationFromNextMonday reservationFromNextMonday = new ReservationFromNextMonday(numDays);
    				CustomerReservationInfo customerReservationInfo = new CustomerReservationInfo(customerType, reservationFromNextMonday);
    				String cheapestHotel = Hotel.whichIsCheapest(customerReservationInfo, allHotels.toArray(new AFormula[allHotels.size()]));
    				
    				//String cheapestHotel = Hotel.whichIsCheapest(customerType, reservationFromNextMonday, allHotels.toArray(new AFormula[allHotels.size()]));
    				System.out.println("The cheapest hotel is: " + cheapestHotel);
    			
    			} else if (checkinTimeType == 111) {
    				
    				ReservationFromNextMonthDayOne reservationFromNextMonthDayOne = new ReservationFromNextMonthDayOne(numDays);
    				CustomerReservationInfo customerReservationInfo = new CustomerReservationInfo(customerType, reservationFromNextMonthDayOne);
    				String cheapestHotel = Hotel.whichIsCheapest(customerReservationInfo, allHotels.toArray(new AFormula[allHotels.size()]));
    				
    				//String cheapestHotel = Hotel.whichIsCheapest(customerType, reservationFromNextMonthDayOne, allHotels.toArray(new AFormula[allHotels.size()]));
    				System.out.println("The cheapest hotel is: " + cheapestHotel);
    			
    			}
    		} else if (scanner.hasNext(pattern)) { //directly specify specific time,e.g. 2013-05-22
    			String dateString = scanner.next(pattern);
    			Date date = null;
    			try {
    				date = sdf.parse(dateString);
    			} catch (ParseException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			Calendar calendar = Calendar.getInstance(Locale.getDefault());
    			calendar.clear();
    			calendar.setTime(date);

    			ReservationSomeday reservationSomeday = new ReservationSomeday(calendar, numDays); 
    			CustomerReservationInfo customerReservationInfo = new CustomerReservationInfo(customerType, reservationSomeday);
				String cheapestHotel = Hotel.whichIsCheapest(customerReservationInfo, allHotels.toArray(new AFormula[allHotels.size()]));
				
    			//String cheapestHotel = Hotel.whichIsCheapest(customerType, reservationSomeday, allHotels.toArray(new AFormula[allHotels.size()]));
				System.out.println("The cheapest hotel is: " + cheapestHotel);
    			
    		}
    	}

	
    	
    }
	

}
