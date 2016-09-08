package motor;

import jm.music.data.Note;
import jm.music.data.Score;
import utilidad.Aleatorios;

public class AprendizajePista extends InterfacePista{

	

	public AprendizajePista(int num) {
		super(num);
	}

	public static void main(String[] args) {
		ap = new AprendizajePista(50);
		ap.evaluar("",getTecArray(0));
		ap.evaluar(getTecArray(1).getNombreNatural(),getTecArray(1));
		ap.evaluar("",getTecArray(2));
		ap.evaluar(getTecArray(3).getNombreNatural(),getTecArray(3));

	}

	public void evaluar(String tocada, Tecla sugerida) {

		if (tocada.equals(sugerida.getNombreNatural())) {
			System.out.println("bien");
		} else {
			System.out.println("mal");

		}

	}


}
