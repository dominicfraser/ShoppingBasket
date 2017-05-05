import java.math.BigDecimal;
import java.util.ArrayList;

public class ShoppingBasket {
	
	private ArrayList<Sellable> basket;
	
	public ShoppingBasket(){
		this.basket = new ArrayList<Sellable>();
	}
	
	public ArrayList<Sellable> getBasket(){
		return new ArrayList<Sellable>(basket);
	}
	
	public void addToBasket(Sellable item){
        basket.add(item);
    }
	
	public void removeFromBasket(Sellable item){
		basket.remove(item);
	}

    public int amountOfItems(){
        return basket.size();
    }
    
    public void emptyBasket(){
    	basket.clear();
    }

	public BigDecimal total() {
		BigDecimal total = new BigDecimal("0");
		for(Sellable item : basket){
			total = total.add(item.getPrice());
		}
		
		return total;
	}
	
}
