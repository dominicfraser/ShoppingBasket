import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ShoppingBasket {
	
	private ArrayList<Sellable> basket;
	private BigDecimal total;
	private BigDecimal discountedTotal;
	
	public ShoppingBasket(){
		this.basket = new ArrayList<Sellable>();
		this.total = BigDecimal.ZERO;
		this.discountedTotal = BigDecimal.ZERO;
	}
	
	public ArrayList<Sellable> getBasket(){
		return new ArrayList<Sellable>(basket);
	}
	
	public void addToBasket(Sellable item){
        basket.add(item);
        total = total.add(item.getPrice());
        discountedTotal = discountedTotal.add(item.getPrice());
    }
	
	public void removeFromBasket(Sellable item){
		basket.remove(item);
		total = total.subtract(item.getPrice());
		discountedTotal = discountedTotal.subtract(item.getPrice());
	}

    public int amountOfItems(){
        return basket.size();
    }
    
    public void emptyBasket(){
    	basket.clear();
    	total = BigDecimal.ZERO;
		discountedTotal = BigDecimal.ZERO;
    }

	public BigDecimal getTotal() {
		return total.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getDiscountedTotal() {
		return discountedTotal.setScale(2, RoundingMode.HALF_UP);
	}

	public void setDiscountedTotal(BigDecimal discountedTotal) {
		this.discountedTotal = discountedTotal.setScale(2, RoundingMode.HALF_UP);
	}
	
}
