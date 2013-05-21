package hotelInfos;

import reservationInfos.CustomerReservationInfo;

/**
 * Base class for the calculating of cost for hotels to get the cheapest hotel
 * All three ***wood hotel extends this base class 
 * @author koruk
 *
 */
public abstract class AFormula {
	
    public int calculate(int customerType, int weekdayCount, int weekendCount){
    	int sum = 0;
		if (customerType == CustomerReservationInfo.REGULAR) {
			sum = onGetRatesForRegularOnWeekday() * weekdayCount + onGetRatesForRegularOnWeekend() * weekendCount;
		}else {
			sum = onGetRatesForRewardsOnWeekday() * weekdayCount + onGetRatesForRewardsOnWeekend() * weekendCount;
		}
		return sum;
    }
    protected abstract String getName();
    protected abstract int getStarsCount();
    
    protected abstract int onGetRatesForRegularOnWeekday();
    protected abstract int onGetRatesForRegularOnWeekend();
    protected abstract int onGetRatesForRewardsOnWeekday();
    protected abstract int onGetRatesForRewardsOnWeekend();
}
