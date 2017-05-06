
import java.math.BigDecimal;
import java.util.ArrayList;

public class Customer {
	private String name;
	private ShoppingBasket basket;
	private boolean loyaltyCard;
	
	public Customer(String name, ShoppingBasket basket) {
		this.name = name;
		this.basket = basket;
		this.loyaltyCard = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Sellable> getBasketArray() {
		return basket.getBasket();
	}
	
	public ShoppingBasket getBasketObject() {
		return basket;
	}

	public void setBasket(ShoppingBasket basket) {
		this.basket = basket;
	}

	public boolean isLoyaltyCard() {
		return loyaltyCard;
	}

	public void setLoyaltyCard(boolean loyaltyCard) {
		this.loyaltyCard = loyaltyCard;
	}

	public void addToBasket(Sellable item) {
		basket.addToBasket(item);
		
	}

	public BigDecimal basketTotal() {
		return basket.getDiscountedTotal();
	}
	
	
}
