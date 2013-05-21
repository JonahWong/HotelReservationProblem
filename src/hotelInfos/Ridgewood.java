package hotelInfos;

/**
 * providing necessary data for the calculating formula
 * @author koruk
 *
 */
public class Ridgewood extends AFormula{
	private int weekdayForRegualar = 220;
	private int weekdayForRewards = 100;
	private int weekendForRegualar = 150;
	private int weekendForRewards = 40;
    
    @Override    
    public String getName(){
    	return "Ridgewood";
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
		return 5;
	}

    
}
