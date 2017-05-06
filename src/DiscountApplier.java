import java.math.BigDecimal;
import java.util.ArrayList;

public class DiscountApplier {

	public static BigDecimal applyActive(Store store, Customer customer){
		
		ArrayList<Discounting> allActive = store.getActiveDiscounts();
		
			for (Discounting discount : allActive){
				if (discount.getPosition().equals("first")){
					discount.findNewTotal(customer);
				}
			}
			for (Discounting discount : allActive){
				if (discount.getPosition().equals("middle")){
					discount.findNewTotal(customer);
				}
			}
			for (Discounting discount : allActive){
				if (discount.getPosition().equals("last")){
					discount.findNewTotal(customer);
				}
			}		
		return customer.getBasketObject().getDiscountedTotal();
	}
}
