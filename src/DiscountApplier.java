import java.math.BigDecimal;

public class DiscountApplier {

	public static BigDecimal applyActive(Store store, Customer customer){
		BigDecimal fullPriceTotal = customer.getBasketObject().getTotal();
		
		for (Discounting discount : store.getActiveDiscounts()){
			if (discount.getPosition().equals("first")){
				BigDecimal newTotal = discount.findNewTotal(customer);
				customer.getBasketObject().setDiscountedTotal(newTotal);
			}
		}
		
		return customer.getBasketObject().getDiscountedTotal();
	}
}
