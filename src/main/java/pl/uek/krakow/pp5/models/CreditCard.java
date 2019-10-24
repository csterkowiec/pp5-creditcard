package pl.uek.krakow.pp5.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CreditCard {
	private final String cardNumber;
	private BigDecimal limit;
}
