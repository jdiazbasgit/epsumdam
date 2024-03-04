package epsum.curso.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Utilidades {

	public static String getLiteralFecha(int year, int mes, int dia) {
		GregorianCalendar fecha = new GregorianCalendar(year, mes, dia);

		System.out.println(fecha.get(Calendar.DAY_OF_WEEK));

		return (fecha.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()) + ", "
				+ fecha.get(Calendar.DAY_OF_MONTH) + " de "
				+ fecha.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " de "
				+ fecha.get(Calendar.YEAR));

	}

	public static String[][] verMes(int mes, int year) {

		int columnas = 7;
		GregorianCalendar fechaDiaUno = new GregorianCalendar(year, mes, 1);
		System.out.println("Calendario del mes de "
				+ fechaDiaUno.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " del año " + year);
		int incrementoSemana = 0;
		if (fechaDiaUno.get(Calendar.DAY_OF_WEEK) > 5 || fechaDiaUno.get(Calendar.DAY_OF_WEEK) == 1)
			
			incrementoSemana++;
		int filas = fechaDiaUno.getActualMaximum(Calendar.WEEK_OF_MONTH) + 1;
		String[][] calendario = new String[filas+incrementoSemana][columnas];

		for (int i = 0; i < calendario.length; i++) {
			for (int j = 0; j < calendario[i].length; j++) {
				calendario[i][j] = "   ";
			}
		}
		calendario[0][0] = " L ";
		calendario[0][1] = " M ";
		calendario[0][2] = " X ";
		calendario[0][3] = " J ";
		calendario[0][4] = " V ";
		calendario[0][5] = " S ";
		calendario[0][6] = " D ";
		int ultimoDia = fechaDiaUno.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i <= ultimoDia; i++) {
			GregorianCalendar fechaAcual = new GregorianCalendar(year, mes, i);
			int diasemana = fechaAcual.get(Calendar.DAY_OF_WEEK);
			
			if (diasemana > 1)
				diasemana = diasemana - 2;
			else
				diasemana = diasemana + 5;

			

			
			int semanaMes = fechaAcual.get(Calendar.WEEK_OF_MONTH);
			if (i < 10)
				calendario[semanaMes+incrementoSemana][diasemana] = " " + i + " ";
			else
				calendario[semanaMes+incrementoSemana][diasemana] = " " + i;
		}

		return calendario;
	}

}
