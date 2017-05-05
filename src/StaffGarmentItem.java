
public class StaffGarmentItem extends Item {

	String name;
	String size;
	
	public StaffGarmentItem(String name, String size){
		super();
		this.name = name;
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
		
	
}
