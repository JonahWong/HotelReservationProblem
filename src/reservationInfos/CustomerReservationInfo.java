package reservationInfos;

/**
 * Model for containing customer infos and reservaton infos
 * @author koruk
 *
 */
public class CustomerReservationInfo {
    public static final int REGULAR = 0;
	private int customerType;
    private ReservationDurationBase reservationInfos;
	
    public CustomerReservationInfo(int customerType, ReservationDurationBase reservationInfos) {
		
		this.customerType = customerType;
		this.reservationInfos = reservationInfos;
	}
    
        

	public int getCustomerType() {
		return customerType;
	}

	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}

	public ReservationDurationBase getReservationInfos() {
		return reservationInfos;
	}

	public void setReservationInfos(ReservationDurationBase reservationInfos) {
		this.reservationInfos = reservationInfos;
	}
    
    
    
}
