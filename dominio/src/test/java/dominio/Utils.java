package dominio;

import java.util.Calendar;
import java.util.Date;

public class Utils {

	public static Date getDate(int dia, int mes, int ano) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		calendar.set(Calendar.MONTH, (mes -1));
		calendar.set(Calendar.YEAR, ano);
		
		return calendar.getTime();
	}
	
}
