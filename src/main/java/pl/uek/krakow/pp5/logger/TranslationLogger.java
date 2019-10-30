package pl.uek.krakow.pp5.logger;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import sun.rmi.runtime.Log;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
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
	public void log(LogType logType, BigDecimal valueEnd){
		log(logType,null,valueEnd);
	}
}
