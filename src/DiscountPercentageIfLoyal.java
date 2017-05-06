import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountPercentageIfLoyal implements Discounting {

	private BigDecimal percentageOff;
	private String position;
	
	public DiscountPercentageIfLoyal(BigDecimal percentageOff, String position) {
		this.percentageOff = percentageOff;
		this.setPosition(position);
	}
	
	@Override
	public boolean checkCondition(Customer customer) {
		if (customer.isLoyaltyCard()){
			return true;
		}
		return false;
	}

	@Override
	public BigDecimal findNewTotal(Customer customer) {
		if (checkCondition(customer)){
		BigDecimal percentageRemaining = new BigDecimal("1").subtract(percentageOff);
		BigDecimal newTotal  = customer.getBasketObject().getDiscountedTotal().multiply(percentageRemaining);
		
		customer.getBasketObject().setDiscountedTotal(newTotal);
		
		return newTotal.setScale(2, RoundingMode.HALF_UP);
		}
		return customer.getBasketObject().getDiscountedTotal();
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
