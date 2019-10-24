package pl.uek.krakow.pp5.models;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class CreditCardTest {

	private static final BigDecimal LIMIT = BigDecimal.valueOf(2000);
	private static final BigDecimal WITHDRAW_BELOW_LIMIT = BigDecimal.valueOf(1000);
	private static final BigDecimal MONEY = BigDecimal.valueOf(1500);
	private static final BigDecimal INVALID_LIMIT = BigDecimal.TEN;
	private static final String CARD_NUMBER = "1234-1234-1234-1234";

	@Test
	public void LimitChangeAboveLimitPasses() {
		CreditCard card = CreditCard.builder()
				.cardNumber(CARD_NUMBER)
				.limit(LIMIT)
				.build();
		card.setLimit(WITHDRAW_BELOW_LIMIT);
		Assert.assertEquals(card.getLimit(), WITHDRAW_BELOW_LIMIT);
	}

	@Test
	public void WithdrawBelowLimitPasses() {
		CreditCard card = CreditCard.builder()
				.cardNumber(CARD_NUMBER)
				.limit(LIMIT)
				.money(MONEY)
				.build();
		card.withdraw(WITHDRAW_BELOW_LIMIT);
	}

	@Test(expected = IllegalStateException.class)
	public void LimitChangeBelowLimitThrows() {
		CreditCard.builder()
				.cardNumber(CARD_NUMBER)
				.limit(LIMIT)
				.money(MONEY)
				.build()
				.setLimit(INVALID_LIMIT);
	}

	@Test(expected = IllegalStateException.class)
	public void WithdrawBelowMoneyThrows() {
		CreditCard.builder()
				.cardNumber(CARD_NUMBER)
				.limit(LIMIT)
				.money(BigDecimal.ZERO)
				.build()
				.withdraw(BigDecimal.TEN);
	}
}
