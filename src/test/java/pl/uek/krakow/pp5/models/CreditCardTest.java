package pl.uek.krakow.pp5.models;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class CreditCardTest {

	private static final BigDecimal LIMIT = BigDecimal.valueOf(2000);
	private static final BigDecimal WITHDRAW_BELOW_LIMIT = BigDecimal.valueOf(1000);
	private static final BigDecimal MONEY = BigDecimal.valueOf(1500);
	private static final BigDecimal INVALID_LIMIT = BigDecimal.TEN;
	private static final String CARD_NUMBER = "1234-3321-1234";

	@Test
	public void limitChangeAboveLimitPasses() {
		CreditCard card = CreditCard.builder()
				.cardNumber(CARD_NUMBER)
				.limit(LIMIT)
				.build();
		card.setLimit(WITHDRAW_BELOW_LIMIT);
		Assert.assertEquals(card.getLimit(), WITHDRAW_BELOW_LIMIT);
	}

	@Test
	public void withdrawBelowLimitPasses() {
		CreditCard card = CreditCard.builder()
				.cardNumber(CARD_NUMBER)
				.limit(LIMIT)
				.balance(MONEY)
				.build();
		card.withdraw(WITHDRAW_BELOW_LIMIT);
	}

	@Test(expected = IllegalStateException.class)
	public void limitChangeBelowLimitThrows() {
		CreditCard.builder()
				.cardNumber(CARD_NUMBER)
				.limit(LIMIT)
				.balance(MONEY)
				.build()
				.setLimit(INVALID_LIMIT);

	}

	@Test(expected = IllegalStateException.class)
	public void withdrawAboveBalanceThrows() {
		CreditCard.builder()
				.cardNumber(CARD_NUMBER)
				.limit(LIMIT)
				.balance(BigDecimal.ZERO)
				.build()
				.withdraw(BigDecimal.TEN);
	}
	@Test
	public void depositPasses(){
		CreditCard card = CreditCard.builder()
				.cardNumber(CARD_NUMBER)
				.limit(LIMIT)
				.balance(BigDecimal.ZERO)
				.build();
				card.deposit(BigDecimal.valueOf(400));
		Assert.assertEquals(card.getBalance(), BigDecimal.valueOf(400) );
	}
}
