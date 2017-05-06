import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ShoppingBasketTest {

	ShoppingBasket basket1;
	FoodItem fItem1;
	GarmentItem gItem1;
	StaffGarmentItem sgItem1;
	
	@Before
	public void before(){
		basket1 = new ShoppingBasket();
		fItem1 = new FoodItem("apple", new BigDecimal("1"));
		gItem1 = new GarmentItem("socks", new BigDecimal("2"), "small");
		sgItem1 = new StaffGarmentItem("shirt", "medium");
	}
	
	@Test
	public void canAddSellable(){
		basket1.addToBasket(fItem1);
		assertEquals(fItem1.getPrice(), basket1.getBasket().get(0).getPrice());
	}
	
	@Test
	public void canAddMultipleSellable(){
		basket1.addToBasket(fItem1);
		basket1.addToBasket(gItem1);
		assertEquals(2, basket1.amountOfItems());
	}
	
	@Test 
	public void canRemoveItem(){
		basket1.addToBasket(fItem1);
		basket1.addToBasket(gItem1);
		basket1.removeFromBasket(fItem1);
		assertEquals(1, basket1.amountOfItems());
		assertEquals(new BigDecimal("2"),basket1.getTotal());
	}
	
	@Test
	public void canEmptyBasket(){
		basket1.addToBasket(fItem1);
		basket1.addToBasket(gItem1);
		basket1.emptyBasket();
		assertEquals(0, basket1.amountOfItems());
	}
	
	@Test
	public void canGetTotalValue(){
		basket1.addToBasket(fItem1);
		basket1.addToBasket(gItem1);
		assertEquals(new BigDecimal("3"), basket1.getTotal());
	}


}
