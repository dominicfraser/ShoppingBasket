import java.math.BigDecimal;

public class GarmentItem extends Item implements Sellable {

	String name;
	BigDecimal price;
	String size;
	
	public GarmentItem(String name,BigDecimal price, String size){
		super();
		this.name = name;
		this.price = price;
		this.size = size;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	
	public BigDecimal getPrice() {
		return price; 
	}

}
