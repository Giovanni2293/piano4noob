package utilidad;

import java.util.LinkedHashMap;
import java.util.Random;

import motor.Piano;
import motor.Tecla;

public class Aleatorios {
	private Random rnd;
	private Piano piano;
	private final double cantidadNumeros = 32;
	private final double termInicial = 53;
	private final Traductor traductor = new Traductor();
	private final LinkedHashMap<String, String> pitchATecla = traductor.getPitchesToTeclas();
	private final LinkedHashMap<String, String> teclaANota = traductor.getMapaDeNotas();

	public Aleatorios() {
		rnd = new Random();
		piano = Piano.getPiano();
	}
	
	
	public static void main(String[] args) {
		Aleatorios a = new Aleatorios();
		a.getRandomSeleccionAcorde();
	}
	

	/**
	 * Regresa un acorde mayor aleatorio 
	 * @return String[] (3 notas que componen el acorde)
	 */
	public String[] getRandomAcordeMayor()
	{
		String[] acordeAleatorio = null;
		acordeAleatorio=Acorde.getAcordeMayor(getRaizAleatoria());
		return acordeAleatorio;
	}
	
	/**
	 * Regresa un acorde menor aleatorio 
	 * @return String[] (3 notas que componen el acorde)
	 */
	public String[] getRandomAcordeMenor()
	{
		String[] acordeAleatorio = null;
		acordeAleatorio=Acorde.getAcordeMenor(getRaizAleatoria());
		return acordeAleatorio;
	}
	
	/**
	 * Regresa un acorde aumentado aleatorio 
	 * @return String[] (3 notas que componen el acorde)
	 */
	public String[] getRandomAcordeAumentado(){
		String[] acordeAleatorio = null;
		acordeAleatorio=Acorde.getAcordeAumentado(getRaizAleatoria());
		return acordeAleatorio;
	}
	
	/**
	 * Regresa un acorde disminuido aleatorio 
	 * @return String[] (3 notas que componen el acorde)
	 */
	public String[] getRandomAcordeDisminuido(){
		String[] acordeAleatorio = null;
		acordeAleatorio=Acorde.getAcordeDisminuido(getRaizAleatoria());
		return acordeAleatorio;
	}
	
	/**
	 * Devuelve la raiz del acorde de forma aleatoria
	 * @return
	 */
	private String getRaizAleatoria()
	{
		String tecla;
		Tecla teclaAleatoria = getRandomTecla();
		tecla=teclaAleatoria.getNota();
		return tecla;
	}
	
	/**
	 * Genera y devuelve una tecla de forma aleatoria con un pitch entre 53 y 84
	 * @return
	 */
	public Tecla getRandomTecla() {

		int numero = (int) (rnd.nextDouble() * cantidadNumeros + termInicial);
		String numerico = numero + "";
		String tecla,nota;
		Tecla teclaRegresar;
		tecla = pitchATecla.get(numerico);
		nota = teclaANota.get(tecla);
		teclaRegresar = piano.getTecla(nota);
		System.out.println(nota);
		
		return teclaRegresar;

	}
	/**
	 * Selecciona de forma aleatoria el acorde para aplicar y lo aplica a una nota aleatoria
	 * @return String[] (3 notas del acorde)
	 */
	
	public String[] getRandomSeleccionAcorde()
	{
		int numero = (int) (rnd.nextDouble() * 3 + 1);
		String[] temp = null;
		switch (numero) {
		case 1:
			temp=getRandomAcordeMayor();
			System.out.println("Entro acorde Mayor");
			break;
		case 2:
			temp=getRandomAcordeMenor();
			System.out.println("Entro acorde Menor");
			break;
		case 3:
			temp=getRandomAcordeAumentado();
			System.out.println("Entro acorde Aumentado");
			break;
		case 4:
			temp=getRandomAcordeDisminuido();
			System.out.println("Entro acorde Disminuido");
			break;
		default:
			break;
		}
		return temp;
	}
}
