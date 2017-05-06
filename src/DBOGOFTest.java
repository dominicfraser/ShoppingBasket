import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DBOGOFTest {

	ShoppingBasket basket;
	FoodItem fItem1;
	FoodItem fItem2;
	FoodItem fItem3;
	FoodItem fItem4;
	FoodItem fItem5;
	GarmentItem gItem1;
	GarmentItem gItem2;
	Customer customer;
	DiscountBOGOF BOGOFApple;

	@Before
	public void before(){
		basket = new ShoppingBasket();
		fItem1 = new FoodItem("apple", new BigDecimal("2.5"));
		fItem2 = new FoodItem("apple", new BigDecimal("2.5"));
		fItem3 = new FoodItem("apple", new BigDecimal("2.5"));
		fItem4 = new FoodItem("apple", new BigDecimal("2.5"));
		fItem5 = new FoodItem("apple", new BigDecimal("2.5"));
		gItem1 = new GarmentItem("sock", new BigDecimal("3"), "small");
		gItem2 = new GarmentItem("sock", new BigDecimal("3"), "small");
		customer = new Customer("Jake",basket);
		BOGOFApple = new DiscountBOGOF(fItem1,"first");	
	}
	
	@Test
	public void falseCheckCondition(){
		basket.addToBasket(fItem1);
		assertEquals(false, BOGOFApple.checkCondition(customer));
	}
	
	@Test
	public void trueCheckCondition(){
		basket.addToBasket(fItem1);
		basket.addToBasket(fItem2);
		assertEquals(true, BOGOFApple.checkCondition(customer));
	}
	
	@Test
	public void canDiscountTwo(){
		basket.addToBasket(fItem1);
		basket.addToBasket(fItem2);
		assertEquals(new BigDecimal("2.50"), BOGOFApple.findNewTotal(customer));
	}

	@Test
	public void canDiscountTwoMix(){
		basket.addToBasket(fItem1);
		basket.addToBasket(fItem2);
		basket.addToBasket(gItem1);
		assertEquals(new BigDecimal("5.50"), BOGOFApple.findNewTotal(customer));
	}
	
	@Test
	public void canDiscountThree(){
		basket.addToBasket(fItem1);
		basket.addToBasket(fItem2);
		basket.addToBasket(fItem3);
		assertEquals(new BigDecimal("5.00"), BOGOFApple.findNewTotal(customer));
	}
	
	@Test
	public void canDiscountFour(){
		basket.addToBasket(fItem1);
		basket.addToBasket(fItem2);
		basket.addToBasket(fItem3);
		basket.addToBasket(fItem4);
		assertEquals(new BigDecimal("5.00"), BOGOFApple.findNewTotal(customer));
	}
	
	@Test
	public void canDiscountFourMix(){
		basket.addToBasket(fItem1);
		basket.addToBasket(fItem2);
		basket.addToBasket(fItem3);
		basket.addToBasket(fItem4);
		basket.addToBasket(gItem1);
		assertEquals(new BigDecimal("8.00"), BOGOFApple.findNewTotal(customer));
	}
	
	@Test
	public void canDiscountFive(){
		basket.addToBasket(fItem1);
		basket.addToBasket(fItem2);
		basket.addToBasket(fItem3);
		basket.addToBasket(fItem4);
		basket.addToBasket(fItem5);
		assertEquals(new BigDecimal("7.50"), BOGOFApple.findNewTotal(customer));
		assertEquals(new BigDecimal("7.50"), customer.getBasketObject().getDiscountedTotal());
		assertEquals(new BigDecimal("12.50"), customer.getBasketObject().getTotal());
	}
	
	@Test
	public void mixItemFive(){
		basket.addToBasket(fItem1);
		basket.addToBasket(fItem2);
		basket.addToBasket(fItem3);
		basket.addToBasket(fItem4);
		basket.addToBasket(fItem5);
		basket.addToBasket(gItem2);
		
		assertEquals(new BigDecimal("10.50"), BOGOFApple.findNewTotal(customer));
	}

}
