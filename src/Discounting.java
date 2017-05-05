
public interface Discounting {
	public boolean checkCondition(Customer customer);
	
	public void applyDiscount(ShoppingBasket basket);
}
