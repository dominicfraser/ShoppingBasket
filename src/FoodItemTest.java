import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class FoodItemTest {
	
	FoodItem item1; 
	FoodItem item2;
	
	@Before
	public void before(){
		item1 = new FoodItem("apple", new BigDecimal("1.50"));
		item2 = new FoodItem("orange", new BigDecimal("2"));
	}
	
	@Test
	public void hasName() {
		assertEquals("apple", item1.getName());
	}

	@Test
	public void hasUUID() {
		assertNotNull(item1.getUUID());
	}
	
	@Test
	public void UUIDsAreDifferent() {
		String UUID1 = item1.getUUID();
		String UUID2 = item2.getUUID();
		boolean result = UUID1.equals(UUID2);
		assertEquals(false, result);
	}
	
	@Test
	public void canAddPrices(){
		BigDecimal result = item1.getPrice().add(item2.getPrice());
		assertEquals(new BigDecimal("3.50"), result);
	}
	
}
