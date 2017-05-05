import java.util.UUID;

public class Item {
	
	UUID uuid;
	
	public Item(){
		this.uuid = UUID.randomUUID();
	}

	public String getUUID(){
		return this.uuid.toString();
	}
	
}
