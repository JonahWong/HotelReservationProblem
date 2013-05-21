package hotelInfos;

/**
 * providing necessary data for the calculating formula
 * @author koruk
 *
 */
public class Bridgewood extends AFormula{
	private int weekdayForRegualar = 160;
	private int weekdayForRewards = 110;
	private int weekendForRegualar = 60;
	private int weekendForRewards = 50;
    
    @Override    
    public String getName(){
    	return "Bridgewood";
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
		return 4;
	}

    
}
