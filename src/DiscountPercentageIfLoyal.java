import java.math.BigDecimal;

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
		BigDecimal percentageRemaining = new BigDecimal("1").subtract(percentageOff);
		BigDecimal newTotal  = customer.getBasketObject().getTotal().multiply(percentageRemaining);
		return newTotal;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
