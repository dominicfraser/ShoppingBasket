import java.math.BigDecimal;

public class DiscountPercentageWhenTotalExceeds implements Discounting {
	
	private BigDecimal percentageOff;
	private BigDecimal total;
	private String position;
	
	public DiscountPercentageWhenTotalExceeds(BigDecimal percentageOff, BigDecimal total, String position) {
		this.percentageOff = percentageOff;
		this.total = total;
		this.position = position;
	}

	@Override
	public boolean checkCondition(Customer customer) {
		if (customer.getBasketObject().getTotal().compareTo(this.total) == -1){
			return false;
		}
		if (customer.getBasketObject().getTotal().compareTo(this.total) == 0){
			return false;
		}
		return true;
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
