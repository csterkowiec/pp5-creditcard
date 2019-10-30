package pl.uek.krakow.pp5.logger;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LogType {
	WITHDRAW("WITHDRAW"),
	DEPOSIT("DEPOSIT"),
	CHANGE_LIMIT("CHANGE_LIMIT");

	private String type;
}
