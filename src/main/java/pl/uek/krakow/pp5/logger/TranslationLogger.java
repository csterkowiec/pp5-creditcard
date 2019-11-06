package pl.uek.krakow.pp5.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TranslationLogger {
	private List<LogEntry> translationLogList = new ArrayList<LogEntry>();

	public void log(LogType logType, BigDecimal valueStart, BigDecimal valueEnd) {
		LogEntry logEntry = LogEntry.builder()
				.logType(logType)
				.valueStart(valueStart)
				.valueEnd(valueEnd)
				.build();
		translationLogList.add(logEntry);
	}

	public void log(LogType logType, BigDecimal valueEnd) {
		log(logType, null, valueEnd);
	}

	public String getLogs() {
		StringBuilder out = new StringBuilder();
		for (LogEntry logEntry : translationLogList) {
			out.append(logEntry);
			out.append('\n');
		}
		return out.toString();
	}
}
