import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	ShoppingBasket basket;
	FoodItem fItem1;
	GarmentItem gItem1;
	Customer customer;

	@Before
	public void before(){
		basket = new ShoppingBasket();
		fItem1 = new FoodItem("apple", new BigDecimal("1"));
		gItem1 = new GarmentItem("sock", new BigDecimal("3"), "small");
		customer = new Customer("Jake",basket);
	}
	
	@Test
	public void custBasketStartsEmpty(){
		assertEquals(0, customer.getBasketArray().size());
	}
	
	@Test
	public void canAddToCustBasket(){
		customer.addToBasket(fItem1);
		assertEquals(1, customer.getBasketArray().size());
	}
	
	@Test
	public void loyaltyStartsFalse(){
		assertEquals(false, customer.isLoyaltyCard());
	}
	
	@Test
	public void canChangeLoyalty(){
		customer.setLoyaltyCard(true);
		assertEquals(true, customer.isLoyaltyCard());
	}
	
	@Test
	public void canGetTotalFromBasket(){
		customer.addToBasket(fItem1);
		customer.addToBasket(gItem1);
		assertEquals(new BigDecimal("4"), customer.basketTotal());
	}

}
