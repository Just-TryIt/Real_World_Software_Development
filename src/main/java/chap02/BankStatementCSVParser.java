package chap02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {
	// 파싱 로직을 추출해 하나의 클래스로 만듦
	private static final DateTimeFormatter DATE_PATTERN
	= DateTimeFormatter.ofPattern("dd-mm-yyyy");
	
	private BankTransaction parseFormCSV(final String line) {
		final String[] columns =line.split(",");
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = 0;
		final String description = null;
		
		return new BankTransaction(date, amount, description);
	}
	
	public List<BankTransaction> parsLinesFormCSV(final List<String> lines){
		final List<BankTransaction> bankTransactions = new ArrayList<>();
		for(final String line:lines) {
			bankTransactions.add(parseFormCSV(line));
		}
		return bankTransactions;
	}

}
