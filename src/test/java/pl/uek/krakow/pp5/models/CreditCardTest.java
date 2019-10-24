package pl.uek.krakow.pp5.models;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class CreditCardTest {

	private static final long LIMIT = 2000;

	@Test
	public void shouldAllowLimitChange() {
		CreditCard card = new CreditCard("1234-1234-1234-1234-1234");
		card.setLimit(BigDecimal.valueOf(LIMIT));
		Assert.assertEquals(card.getLimit(), BigDecimal.valueOf(LIMIT));
	}
}
