package motor;

import java.util.HashMap;

public class AprendizajeAcorde extends InterfazAcorde {

	private AprendizajeAcorde(int num) {
		
	}

	public boolean evaluar(String s,String[] acordeEstudiante) {
		String[] acordeProfe = cancionString.get(indice);
		HashMap<String, String> m = new HashMap<>();
		boolean flag=false;
		// campo independiente de la clase
		if (acordeEstudiante != null) {
			m.put("1", acordeEstudiante[0]);
			m.put("2", acordeEstudiante[1]);
			m.put("3", acordeEstudiante[2]);
			if (m.containsValue(acordeProfe[0]) && m.containsValue(acordeProfe[1]) && m.containsValue(acordeProfe[2])) {// Entrada
				indice++; // correcta
				flag=true;
			} else {
				flag=false;
			}
		} else {
			flag=false;
		}
		 return flag;
	}
	
	
	

	
}
