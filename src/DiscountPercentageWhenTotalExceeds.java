import java.math.BigDecimal;
import java.math.RoundingMode;

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
