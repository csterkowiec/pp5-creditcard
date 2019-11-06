package pl.uek.krakow.pp5.logger;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
@ToString
public class LogEntry {
	@NonNull
	private LogType logType;
	private BigDecimal valueStart;
	@NonNull
	private BigDecimal valueEnd;
}
