/**
 * Clase encargada de ejecutar la logica del hilo
 */

package utilidad;

import java.awt.Color;

import jm.music.data.Note;
import jm.util.Play;
import motor.Reproduccion;

public class Temporalizador {

	/*
	 * status se encarga de mantener con vida el hilo y step es el numero de
	 * ejecucion del hilo (simulando el tiempo transcurrido)
	 */

	private boolean status;
	private static int step;
	private Note[] n;
	private Traductor tr = new Traductor();

	private BotonTecla[] Teclas = new BotonTecla[31];

	public Temporalizador(Note[] n, BotonTecla[] t) {
		super();
		this.n = n;
		Teclas = t;
		

	}

	/**
	 * Inicia la ejecucion del hilo
	 */

	public void iniciar() {
		status = true;
		Hilo hilo = Hilo.getHilo(this);
		step=0;
	}

	/**
	 * Contiene la logica que se ejecuta cada intervalo en el hilo
	 */
	public void step() {

		
		System.out.println(step + "ejecucion");

		int index = n[step].getPitch();
		for (BotonTecla t : Teclas) {

			String s = t.getTecla();
			String s2 = tr.getPitchesToTeclas().get("" + index);
			if (s.equals(s2)) {
				t.setBackground(new Color(116,171,245));
				Play.midiCycle(n[step]);
				Play.stopMidiCycle();
				
				if (t.getText().length() > 2)
					t.setBackground(Color.black);
				else
					t.setBackground(Color.WHITE);

			}
			

		}
		step++;
		if (step >= n.length) {
			detener();
		}
	}

	/**
	 * Permite conocer si el hilo esta activo o no
	 * 
	 * @return status Estado del hilo
	 */
	public boolean getStatus() {
		return status;
	}

	/**
	 * Detiene la ejecucion del hilo
	 */
	private void detener() {
		status = false;

	}

	/**
	 * Devuele el numero del ciclo en el que se encuentra el hilo
	 * 
	 * @return step Ciclo actual del hilo
	 */
	public int getStep() {
		return step;
	}

	

}
