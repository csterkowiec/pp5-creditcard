package pl.uek.krakow.pp5.logger;

import lombok.Builder;
import lombok.NonNull;

import java.math.BigDecimal;

@Builder
public class LogEntry {
	@NonNull
	private LogType logType;
	private BigDecimal valueStart;
	@NonNull
	private BigDecimal valueEnd;
}
