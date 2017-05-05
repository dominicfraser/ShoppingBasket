
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class GarmentItemTest {
	
	GarmentItem item1;

	@Before
	public void before(){
		item1 = new GarmentItem("socks", new BigDecimal("2"), "small");
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
