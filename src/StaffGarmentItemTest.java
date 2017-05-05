import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StaffGarmentItemTest {

	StaffGarmentItem item1;

	@Before
	public void before(){
		item1 = new StaffGarmentItem("shirt", "small");
	}
	
	@Test
	public void hasSize() {
		assertEquals("small", item1.getSize());		
	}
	
	@Test
	public void hasUUID() {
		assertNotNull(item1.getUUID());
	}

}
