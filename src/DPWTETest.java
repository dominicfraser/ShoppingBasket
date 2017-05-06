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
	
	@Test
	public void discountsBasket(){
		customer.addToBasket(fItem1);
		customer.addToBasket(fItem2);
		BigDecimal newTotal = tenperoffovertwenty.findNewTotal(customer);
		assertEquals(new BigDecimal("18.90"), newTotal);
		assertEquals(new BigDecimal("18.90"), customer.getBasketObject().getDiscountedTotal());
		assertEquals(new BigDecimal("21.00"), customer.getBasketObject().getTotal());
	}
	
	@Test
	public void doesntDiscountsBasket(){
		customer.addToBasket(fItem1);
		BigDecimal newTotal = tenperoffovertwenty.findNewTotal(customer);
		assertEquals(new BigDecimal("20.00"), newTotal);
		assertEquals(new BigDecimal("20.00"), customer.getBasketObject().getDiscountedTotal());
		assertEquals(new BigDecimal("20.00"), customer.getBasketObject().getTotal());
	}

}
