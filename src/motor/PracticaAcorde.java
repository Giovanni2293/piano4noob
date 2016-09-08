package motor;

import java.util.HashMap;

public class PracticaAcorde extends InterfazAcorde {

	public PracticaAcorde() {
		
	}

	public boolean evaluar(String n,String[] acordeEstudiante) {
		String[] acordeProfe = cancionString.get(indice);
		HashMap<String, String> m = new HashMap<>();
		boolean flag=false;
		// campo independiente de la clase
		if (acordeEstudiante != null) {
			m.put("1", acordeEstudiante[0]);
			m.put("2", acordeEstudiante[1]);
			m.put("3", acordeEstudiante[2]);//GS3,C4,DS4
			if (m.containsValue(acordeProfe[0]) && m.containsValue(acordeProfe[1]) && m.containsValue(acordeProfe[2])) {// Entrada
				Puntuacion.acierto(); // correcta
				flag=true;
			} else {
				Puntuacion.fallos();
				flag=false;
			}
		} else {
			Puntuacion.fallos();
			flag=false;	
		}
		indice++;// Ignora los errores y avanza
		return flag;
	}

	public void terminarDeEvaluar() {
		super.terminarDeEvaluar();
		Puntuacion.reset();
	}

}
