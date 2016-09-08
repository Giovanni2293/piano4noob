package motor;

public class PracticaPista extends InterfacePista {

	public PracticaPista(int num) {
		super(num);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ap = new PracticaPista(50);
		ap.evaluar("", getTecArray(0));
		ap.evaluar(getTecArray(1).getNombreNatural(), getTecArray(1));
		ap.evaluar("", getTecArray(2));
		ap.evaluar(getTecArray(3).getNombreNatural(), getTecArray(3));
		System.out.println(Puntuacion.getPuntuacion());

	}

	public void evaluar(String tocada, Tecla sugerida) {

		if (tocada.equals(sugerida.getNombreNatural())) {
			System.out.println("bien");
			System.out.println("paso por aqui");

			Puntuacion.acierto();

		} else {
			System.out.println("mal");
			System.out.println("por aqui tambien");
			Puntuacion.fallos();
		}
	}
}
