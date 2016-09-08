package motor;

/**
 * Esta es una clase de apoyo que esta destinada a llevar un contador de
 * aciertos y fallos que servira despues de apoyo para los modos Aprendizaje y
 * Practica
 * 
 * @Autor: Flores - Pereira - Prada
 * @version: 24/07/2016
 * 
 */

public class Puntuacion {

	private static int aciertos, teclasPresionadas, fallos = 0;
	private static long score = 0;

	public static void acierto() {
		teclasPresionadas++;
		aciertos++;
		score = aciertos * 10 + score;
	}

	public static void fallos() {
		teclasPresionadas++;
		fallos++;
	}

	public static int getRatioAciertos() {
		return (aciertos / teclasPresionadas) * 100;
	}

	public static int getRatioFallos() {
		return (fallos / teclasPresionadas) * 100;
	}

	public static long getPuntuacion() {
		return score;
	}

	public static void reset() {
		aciertos = 0;
		teclasPresionadas = 0;
		fallos = 0;
		score = 0;
	}

	public static String rateLetra() {
		int r = getRatioAciertos();
		String value;
		if (r == 100) {
			value = "Perfect";
		} else {
			if (r >= 80 && r < 100) {
				value = "S+";
			} else {
				if (r >= 60 && r < 80) {
					value = "S";
				} else {
					if (r >= 50 && r < 60) {
						value = "A";
					} else {
						value = "D";
					}
				}
			}
		}
		return value;
	}

}
