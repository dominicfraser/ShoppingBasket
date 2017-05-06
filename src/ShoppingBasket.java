import java.math.BigDecimal;
import java.util.ArrayList;

public class ShoppingBasket {
	
	private ArrayList<Sellable> basket;
	private BigDecimal total;
	private BigDecimal discountedTotal;
	
	public ShoppingBasket(){
		this.basket = new ArrayList<Sellable>();
		this.total = BigDecimal.ZERO;
		this.setDiscountedTotal(BigDecimal.ZERO);
	}
	
	public ArrayList<Sellable> getBasket(){
		return new ArrayList<Sellable>(basket);
	}
	
	public void addToBasket(Sellable item){
        basket.add(item);
        total = total.add(item.getPrice());
    }
	
	public void removeFromBasket(Sellable item){
		basket.remove(item);
		total = total.subtract(item.getPrice());
	}

    public int amountOfItems(){
        return basket.size();
    }
    
    public void emptyBasket(){
    	basket.clear();
    }

	public BigDecimal getTotal() {
		return total;
	}

	public BigDecimal getDiscountedTotal() {
		return discountedTotal;
	}

	public void setDiscountedTotal(BigDecimal discountedTotal) {
		this.discountedTotal = discountedTotal;
	}
	
}
