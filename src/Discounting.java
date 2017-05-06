import java.math.BigDecimal;

public interface Discounting {
	public boolean checkCondition(Customer customer);
	
	public BigDecimal findNewTotal(Customer customer);
}
