package hotelInfos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;

import reservationInfos.CustomerReservationInfo;
import reservationInfos.ReservationDurationBase;

/**
 * This class determine the cheapest hotel by using different formulas.
 * @author koruk
 *
 */
public class Hotel {	
	
	public static String whichIsCheapest(CustomerReservationInfo customerReservationInfo, AFormula[] array) {
		// TODO Auto-generated method stub
		return whichIsCheapest(customerReservationInfo.getCustomerType(), customerReservationInfo.getReservationInfos(), array);
	}
		
	public static String whichIsCheapest(final int customerType, ReservationDurationBase reservationInfos,AFormula...formulas) {
		
		Map<String, Integer> map = reservationInfos.getWeekdayWeekendCounts();
    	final int weekdayCount = map.get(ReservationDurationBase.KEY_WEEKDAY);
    	final int weekendCount = map.get(ReservationDurationBase.KEY_WEEKEND);
		/**
		 * providing a comparator that determine which hotel cost the least.
		 * @author koruk
		 *
		 */
		class MoneySumCompare implements Comparator<AFormula>{
            
			@Override
			public int compare(AFormula o1, AFormula o2) {
				
				if(sum(o1) < sum(o2)){/** compare the total cost for two hotels **/
					
					return -1;
					
				}else if (sum(o1) > sum(o2)) {
					
					return 1;
					
				}else { /** if the total cost for two hotels is even,then compare the rating stars. **/
					
					if (o1.getStarsCount() < o2.getStarsCount()) {
						return 1;
					}else {
						return -1;
					}
					
				}
				
			}
            /**
             * calculate the specific hotel's cost for reservation
             * @param o1 specific hotel
             * @return
             */
			private int sum(AFormula o1){
				
				return o1.calculate(customerType, weekdayCount, weekendCount);
				
			}
			
		}
		
		MoneySumCompare comparator = new MoneySumCompare();
		TreeSet<AFormula> sortedHotels = new TreeSet<AFormula>(comparator);
		/**
		 * sort an unsorted list just find the smallest value.
		 */
		sortedHotels.addAll(Arrays.asList(formulas));
    	  	   	  	    	
		return sortedHotels.first().getName();
	}	
	
	
}
