import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DPWTETest {
	
	ShoppingBasket basket;
	FoodItem fItem1;
	GarmentItem gItem1;
	Customer customer;
	DiscountPercentageWhenTotalExceeds tenperoffovertwenty;

	@Before
	public void before(){
		basket = new ShoppingBasket();
		fItem1 = new FoodItem("apple", new BigDecimal("20"));
		gItem1 = new GarmentItem("sock", new BigDecimal("0.01"), "small");
		customer = new Customer("Jake",basket);
		tenperoffovertwenty = new DiscountPercentageWhenTotalExceeds(0.1, new BigDecimal("20"));
		
	}
	
	@Test
	public void failsCheckConditionAtZero(){
		assertEquals(false, tenperoffovertwenty.checkCondition(customer));
	}
	
	@Test
	public void failsCheckConditionAtTwenty(){
		customer.addToBasket(fItem1);
		assertEquals(false, tenperoffovertwenty.checkCondition(customer));
	}
	
	@Test
	public void passesCheckConditionAtOverTwenty(){
		customer.addToBasket(fItem1);
		customer.addToBasket(gItem1);
		assertEquals(true, tenperoffovertwenty.checkCondition(customer));
	}

}
