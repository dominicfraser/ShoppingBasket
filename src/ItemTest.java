

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void itemHasUUIDAsString() {
		Item item1 = new Item();
		String UUID = item1.getUUID();
		assertTrue(UUID instanceof String);
	}
	
	@Test
	public void UUIDsAreDifferent() {
		Item item1 = new Item();
		String UUID1 = item1.getUUID();
		Item item2 = new Item();
		String UUID2 = item2.getUUID();
		boolean result = UUID1.equals(UUID2);
		assertEquals(false, result);
	}

}
