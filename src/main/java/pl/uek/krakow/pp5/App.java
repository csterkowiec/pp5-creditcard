package pl.uek.krakow.pp5;

import pl.uek.krakow.pp5.models.CreditCard;

import java.math.BigDecimal;

public class App {
	public static void main(String args[]) {
		CreditCard card = CreditCard.builder()
				.cardNumber("1234")
				.limit(BigDecimal.valueOf(100))
				.money(BigDecimal.valueOf(100))
				.build();
		card.setLimit(BigDecimal.valueOf(200));
		System.out.println();
	}
}
