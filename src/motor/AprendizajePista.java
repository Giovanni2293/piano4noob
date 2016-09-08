package motor;

import jm.music.data.Note;
import jm.music.data.Score;
import utilidad.Aleatorios;

public class AprendizajePista extends InterfacePista{

	

	public AprendizajePista(int num) {
		super(num);
		setModoVar("ApPista");		
	}

	/*public static void main(String[] args) {
		ap = new AprendizajePista(50);
		String[] sarr= new String[1];
		sarr[0]=getTecArray(0).getNombreNatural();
		if(ap.evaluar(sarr[0], sarr))System.out.println("exito");;
		}*/

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
