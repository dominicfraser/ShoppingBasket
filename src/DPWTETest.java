import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DPWTETest {
	
	ShoppingBasket basket;
	FoodItem fItem1;
	FoodItem fItem2;
	GarmentItem gItem1;
	Customer customer;
	DiscountPercentageWhenTotalExceeds tenperoffovertwenty;

	@Before
	public void before(){
		basket = new ShoppingBasket();
		fItem1 = new FoodItem("apple", new BigDecimal("20"));
		fItem2 = new FoodItem("apple", new BigDecimal("1"));
		gItem1 = new GarmentItem("sock", new BigDecimal("0.01"), "small");
		customer = new Customer("Jake",basket);
		tenperoffovertwenty = new DiscountPercentageWhenTotalExceeds(new BigDecimal("0.1"), new BigDecimal("20"),"middle");	
	}
	
	@Test
	public void failsCheckConditionAtZero(){
		BigDecimal runningTotal = customer.getBasketObject().total();
		assertEquals(false, tenperoffovertwenty.checkCondition(runningTotal));
	}
	
	@Test
	public void failsCheckConditionAtTwenty(){
		customer.addToBasket(fItem1);
		BigDecimal runningTotal = customer.getBasketObject().total();
		assertEquals(false, tenperoffovertwenty.checkCondition(runningTotal));
	}
	
	@Test
	public void passesCheckConditionAtOverTwenty(){
		customer.addToBasket(fItem1);
		customer.addToBasket(gItem1);
		BigDecimal runningTotal = customer.getBasketObject().total();
		assertEquals(true, tenperoffovertwenty.checkCondition(runningTotal));
	}
	
	@Test
	public void discountsBasket(){
		customer.addToBasket(fItem1);
		customer.addToBasket(fItem2);
		BigDecimal runningTotal = customer.getBasketObject().total();
		BigDecimal newTotal = tenperoffovertwenty.findNewTotal(runningTotal);
		assertEquals(new BigDecimal("18.9"), newTotal);
	}

}
