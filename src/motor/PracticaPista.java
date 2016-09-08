package motor;

public class PracticaPista extends InterfacePista {

	public PracticaPista(int num) {
		super(num);
		setModoVar("PrPista");		

		// TODO Auto-generated constructor stub
	}

	public boolean evaluar(String tocada, String[] sugerida) {

		if (tocada.equals(sugerida[0])) {
			Puntuacion.acierto();
			return true;
		} else {
			Puntuacion.fallos();
			return false;
		}
	}

	
}
