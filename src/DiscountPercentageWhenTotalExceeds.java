import java.math.BigDecimal;

public class DiscountPercentageWhenTotalExceeds implements Discounting {
	
	private double percentageOff;
	private BigDecimal total;
	
	public DiscountPercentageWhenTotalExceeds(double percentageOff, BigDecimal total) {
		this.percentageOff = percentageOff;
		this.total = total;
	}

	@Override
	public boolean checkCondition(Customer customer) {
		if (customer.basketTotal().compareTo(this.total) == -1){
			return false;
		}
		if (customer.basketTotal().compareTo(this.total) == 0){
			return false;
		}
		return true;
	}

	@Override
	public void applyDiscount(ShoppingBasket basket) {
		// TODO Auto-generated method stub

	}

}
