package pl.uek.krakow.pp5.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@Builder
@Getter
public class CreditCard {
	@NonNull
	private final String cardNumber;
	@NonNull
	private BigDecimal limit;
	private BigDecimal money;

	public void setLimit(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.valueOf(100)) < 0) {
			throw new IllegalStateException("Cannot set limit below 100 PLN");
		}
		limit = amount;
	}

	public void setMoney(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalStateException("Cannot set money below zero");
		}
		money = money.subtract(amount);
	}

	public void withdraw(BigDecimal withdrawAmount) {
		if (withdrawAmount.compareTo(limit) > 0) {
			throw new IllegalStateException("Cannot withdraw above limit amount");
		}
		setMoney(money.subtract(withdrawAmount));
	}
}
