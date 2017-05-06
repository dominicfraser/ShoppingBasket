import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DPILTest {

	ShoppingBasket basket;
	FoodItem fItem1;
	FoodItem fItem2;
	GarmentItem gItem1;
	Customer customer;
	DiscountPercentageIfLoyal twoPerOffIfLoyal;

	@Before
	public void before(){
		basket = new ShoppingBasket();
		fItem1 = new FoodItem("apple", new BigDecimal("20"));
		fItem2 = new FoodItem("apple", new BigDecimal("1"));
		gItem1 = new GarmentItem("sock", new BigDecimal("0.01"), "small");
		customer = new Customer("Jake",basket);
		twoPerOffIfLoyal = new DiscountPercentageIfLoyal(new BigDecimal("0.02"),"last");	
	}
	
	@Test
	public void falseCheckConditionNotLoyal(){
		assertEquals(false, twoPerOffIfLoyal.checkCondition(customer));
	}
	
	@Test
	public void trueCheckConditionIsLoyal(){
		customer.setLoyaltyCard(true);
		assertEquals(true, twoPerOffIfLoyal.checkCondition(customer));
	}
	
	@Test
	public void discountsBasket(){
		customer.addToBasket(fItem1);
		customer.addToBasket(fItem2);
		customer.setLoyaltyCard(true);
		BigDecimal newTotal = twoPerOffIfLoyal.findNewTotal(customer);
		assertEquals(new BigDecimal("20.58"), newTotal);
	}
	
	@Test
	public void doesntDiscountBasket(){
		customer.addToBasket(fItem1);
		customer.addToBasket(fItem2);
		BigDecimal newTotal = twoPerOffIfLoyal.findNewTotal(customer);
		assertEquals(new BigDecimal("21.00"), newTotal);
	}

}
