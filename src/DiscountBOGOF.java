import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountBOGOF implements Discounting {
	
	private Sellable itemToDiscount;
	private String position;
	
	public DiscountBOGOF(Sellable itemToDiscount, String position) {
		this.itemToDiscount = itemToDiscount;
		this.setPosition(position);
	}

	@Override
	public boolean checkCondition(Customer customer) {
		int counter = 0;
		for (Sellable itemInArray : customer.getBasketArray()){
			if (itemToDiscount.getName().equals(itemInArray.getName())){
				counter++;
			}
		}
		if (counter > 1){
			return true;
		}
		return false;
	}

	@Override
	public BigDecimal findNewTotal(Customer customer) {
		if (checkCondition(customer)){		
			int counter = 0;
			BigDecimal baseItemPrice = itemToDiscount.getPrice();
			for (Sellable itemInArray : customer.getBasketArray()){
				if (itemToDiscount.getName().equals(itemInArray.getName())){
					counter++;
				}
			}
			if ((counter % 2) == 0 ){
				BigDecimal amountToDiscount = new BigDecimal(String.valueOf(counter/2)).multiply(baseItemPrice);
				BigDecimal newTotal = customer.basketTotal().subtract(amountToDiscount);
				customer.getBasketObject().setDiscountedTotal(newTotal);
				return newTotal.setScale(2, RoundingMode.HALF_UP);
			} else {
				BigDecimal amountToDiscount = new BigDecimal(String.valueOf(((counter-1)/2)))
						.multiply(baseItemPrice);
				BigDecimal newTotal = customer.basketTotal().subtract(amountToDiscount);
				customer.getBasketObject().setDiscountedTotal(newTotal);
				return newTotal.setScale(2, RoundingMode.HALF_UP);
			}
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
