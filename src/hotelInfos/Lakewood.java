package hotelInfos;

/**
 * providing necessary data for the calculating formula
 * @author koruk
 *
 */
public class Lakewood extends AFormula{
	private int weekdayForRegualar = 110;
	private int weekdayForRewards = 80;
	private int weekendForRegualar = 90;
	private int weekendForRewards = 80;
    
    @Override    
    public String getName(){
    	return "Lakewood";
    }

	@Override
	protected int onGetRatesForRegularOnWeekday() {
		// TODO Auto-generated method stub
		return weekdayForRegualar;
	}

	@Override
	protected int onGetRatesForRegularOnWeekend() {
		// TODO Auto-generated method stub
		return weekendForRegualar;
	}

	@Override
	protected int onGetRatesForRewardsOnWeekday() {
		// TODO Auto-generated method stub
		return weekdayForRewards;
	}

	@Override
	protected int onGetRatesForRewardsOnWeekend() {
		// TODO Auto-generated method stub
		return weekendForRewards;
	}

	@Override
	protected int getStarsCount() {
		// TODO Auto-generated method stub
		return 3;
	}

    
}
