package chap02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementCSVParser {
private static final String RESOURCES = "src/main/resources/";
	
	public static void main(final String...args) throws IOException{
		
		final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
		final List<String> lines = Files.readAllLines(path);
		double total=0d;
		
		final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("DATE_PATTERN의 값 :"+DATE_PATTERN);
		// DATE_PATTERN의 결과가 Value(DayOfMonth,2)'-'Value(MonthOfYear,2)'-'Value(YearOfEra,4,19,EXCEEDS_PAD)
		// 로 출력되는데 이해가 안된다
		
		for(final String line: lines) {
			final String[] columns = line.split(",");
			final LocalDate date =LocalDate.parse(columns[0], DATE_PATTERN);
			System.out.println("date의 값 :"+ date);
			
			if(date.getMonth()==Month.JANUARY) {
				final double amount = Double.parseDouble(columns[1]);
				total+=amount;
			}
		}
		System.out.println("The total for all transactions in January is "+total);
		
	}
}
