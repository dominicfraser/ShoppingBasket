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
	public boolean checkCondition(BigDecimal runningTotal) {
		if (runningTotal.compareTo(this.total) == -1){
			return false;
		}
		if (runningTotal.compareTo(this.total) == 0){
			return false;
		}
		return true;
	}

	@Override
	public BigDecimal findNewTotal(BigDecimal runningTotal) {
		BigDecimal percentageRemaining = new BigDecimal("1").subtract(percentageOff);
		BigDecimal newTotal  = runningTotal.multiply(percentageRemaining);
		return newTotal;
	}

}
