import java.math.BigDecimal;

public interface Discounting {
	public boolean checkCondition(BigDecimal runningTotal);
	
	public BigDecimal findNewTotal(BigDecimal runningTotal);
}
