package epsum.curso.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class EjemloCalendar {

	public static void main(String[] args) {
		
		System.out.println(Utilidades.getLiteralFecha(2024, 2,4));
		
		String[][] calendario= Utilidades.verMes(3, 2024);
		
		for (int i = 0; i < calendario.length; i++) {
			for (int j = 0; j < calendario[i].length; j++) {
				
				System.out.print(calendario[i][j]);
			}
			System.out.println();
		}
	}

}
