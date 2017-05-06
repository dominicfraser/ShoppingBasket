import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class StoreTest {

	Store store;
	FoodItem fItem1;
	DiscountBOGOF BOGOFApple;
	DiscountPercentageIfLoyal twoPerOffIfLoyal;
	DiscountPercentageWhenTotalExceeds tenPerOffOverTwenty;
	
	@Before
	public void before(){
		store = new Store();
		fItem1 = new FoodItem("apple", new BigDecimal("2.5"));
		BOGOFApple = new DiscountBOGOF(fItem1,"first");
		twoPerOffIfLoyal = new DiscountPercentageIfLoyal(new BigDecimal("0.02"),"last");
		tenPerOffOverTwenty = new DiscountPercentageWhenTotalExceeds(new BigDecimal("0.1"), new BigDecimal("20"),"middle");
	}
	
	@Test
	public void canAddDiscount(){
		store.addActiveDiscount(BOGOFApple);
		assertEquals(1, store.amountOfActiveDiscounts());
	}
	
	@Test
	public void canAddMultipleDiscount(){
		store.addActiveDiscount(BOGOFApple);
		store.addActiveDiscount(tenPerOffOverTwenty);
		store.addActiveDiscount(twoPerOffIfLoyal);
		assertEquals(3, store.amountOfActiveDiscounts());
	}
	
	@Test
	public void canRemoveDiscount(){
		store.addActiveDiscount(BOGOFApple);
		store.addActiveDiscount(tenPerOffOverTwenty);
		store.addActiveDiscount(twoPerOffIfLoyal);
		store.removeActiveDiscount(tenPerOffOverTwenty);
		assertEquals(2, store.amountOfActiveDiscounts());
	}

}
