import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DiscountApplierTest {

	Store store;
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
	DiscountBOGOF BOGOFSock;
	DiscountPercentageIfLoyal twoPerOffIfLoyal;
	DiscountPercentageWhenTotalExceeds tenPerOffOverTwenty;

	@Before
	public void before(){
		store = new Store();
		basket = new ShoppingBasket();
		
		fItem1 = new FoodItem("apple", new BigDecimal("2.5"));
		fItem2 = new FoodItem("apple", new BigDecimal("2.5"));
		fItem3 = new FoodItem("apple", new BigDecimal("2.5"));
		fItem4 = new FoodItem("apple", new BigDecimal("2.5"));
		fItem5 = new FoodItem("watermelon", new BigDecimal("20"));
		gItem1 = new GarmentItem("sock", new BigDecimal("3"), "small");
		gItem2 = new GarmentItem("sock", new BigDecimal("3"), "small");
		
		basket.addToBasket(fItem1);
		basket.addToBasket(fItem2);
		basket.addToBasket(gItem1);
		
		customer = new Customer("Jake",basket);
		
		
		BOGOFApple = new DiscountBOGOF(fItem1,"first");
		BOGOFSock = new DiscountBOGOF(gItem1,"first");
		tenPerOffOverTwenty = new DiscountPercentageWhenTotalExceeds(new BigDecimal("0.1"), new BigDecimal("20"),"middle");
		twoPerOffIfLoyal = new DiscountPercentageIfLoyal(new BigDecimal("0.02"),"last");
		
		store.addActiveDiscount(BOGOFApple);
	}
	
	@Test
	public void oneDiscount(){
		DiscountApplier.applyActive(store, customer);
		assertEquals(new BigDecimal("5.50"), customer.getBasketObject().getDiscountedTotal());
	}
	
	@Test
	public void multipleDiscounts(){
		store.addActiveDiscount(twoPerOffIfLoyal);
		customer.setLoyaltyCard(true);
		DiscountApplier.applyActive(store, customer);
		assertEquals(new BigDecimal("5.39"), customer.getBasketObject().getDiscountedTotal());
	}
	
	@Test
	public void multipleDiscountsTotalOver20(){
		store.addActiveDiscount(tenPerOffOverTwenty);
		basket.addToBasket(fItem5);
		DiscountApplier.applyActive(store, customer);
		assertEquals(new BigDecimal("22.95"), customer.getBasketObject().getDiscountedTotal());
	}
	
	@Test
	public void withoutDiscountApplier(){
		assertEquals(new BigDecimal("8.00"), customer.getBasketObject().getDiscountedTotal());
	}
	
	@Test
	public void discountsApplyCorrectOrder(){
		store.addActiveDiscount(tenPerOffOverTwenty);
		store.addActiveDiscount(twoPerOffIfLoyal);
		customer.setLoyaltyCard(true);
		basket.addToBasket(fItem5);
		DiscountApplier.applyActive(store, customer);
		assertEquals(new BigDecimal("22.49"), customer.getBasketObject().getDiscountedTotal());
	}
	
	@Test
	public void multipleDiscountCxNotLoyal(){
		store.addActiveDiscount(tenPerOffOverTwenty);
		store.addActiveDiscount(twoPerOffIfLoyal);
		basket.addToBasket(fItem5);
		DiscountApplier.applyActive(store, customer);
		assertEquals(new BigDecimal("22.95"), customer.getBasketObject().getDiscountedTotal());
	}
	
	@Test
	public void manyBOGOFOneDiscount(){
		basket.addToBasket(fItem3);
		basket.addToBasket(fItem4);
		basket.addToBasket(fItem5);
		basket.addToBasket(gItem2);
		store.addActiveDiscount(BOGOFSock);
		DiscountApplier.applyActive(store, customer);
		assertEquals(new BigDecimal("28.00"), customer.getBasketObject().getDiscountedTotal());
	}
	
	@Test
	public void manyBOGOFmultipleDiscounts(){
		store.addActiveDiscount(tenPerOffOverTwenty);
		store.addActiveDiscount(twoPerOffIfLoyal);
		store.addActiveDiscount(BOGOFSock);
		customer.setLoyaltyCard(true);
		
		basket.addToBasket(fItem3);
		basket.addToBasket(fItem4);
		basket.addToBasket(fItem5);
		basket.addToBasket(gItem2);
		
		DiscountApplier.applyActive(store, customer);
		assertEquals(new BigDecimal("24.70"), customer.getBasketObject().getDiscountedTotal());
	}
	
	@Test
	public void duplicateBOGOF(){
		store.addActiveDiscount(BOGOFApple);
		DiscountApplier.applyActive(store, customer);
		assertEquals(new BigDecimal("5.50"), customer.getBasketObject().getDiscountedTotal());
	}
	
	@Test
	public void duplicateLoyalty(){
		store.addActiveDiscount(twoPerOffIfLoyal);
		store.addActiveDiscount(twoPerOffIfLoyal);
		customer.setLoyaltyCard(true);
		DiscountApplier.applyActive(store, customer);
		assertEquals(new BigDecimal("5.39"), customer.getBasketObject().getDiscountedTotal());
	}
	
	

}
