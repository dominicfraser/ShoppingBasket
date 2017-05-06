import java.util.ArrayList;

public class Store {
	
	private ArrayList<Discounting> activeDiscounts;
	
	public Store(){
		this.activeDiscounts = new ArrayList<Discounting>();
	}

	public ArrayList<Discounting> getActiveDiscounts() {
		return new ArrayList<Discounting>(activeDiscounts);
	}

	public void addActiveDiscount(Discounting discount){
		activeDiscounts.add(discount);
	}
	
	public void removeActiveDiscount(Discounting discount){
		activeDiscounts.remove(discount);
	}
	
    public int amountOfActiveDiscounts(){
        return activeDiscounts.size();
    }
	
}
