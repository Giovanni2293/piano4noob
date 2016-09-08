/**
 * Clase encargada de ejecutar la logica del hilo
 */

package utilidad;

import java.awt.Color;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;

import Gui.Piano4Noob;
import jm.music.data.Note;
import jm.util.Play;
import motor.Puntuacion;
import motor.Reproduccion;

public class Tutor {

	/*
	 * status se encarga de mantener con vida el hilo y step es el numero de
	 * ejecucion del hilo (simulando el tiempo transcurrido)
	 */

	private boolean status;
	private static int step;
	private Note[] n;
	private Traductor tr = new Traductor();
	private Hilo hilo;
	private static boolean creado;

	private BotonTecla[] Teclas = new BotonTecla[31];

	public Tutor(Note[] n, BotonTecla[] t) {
		super();
		this.n = n;
		creado = true;
		Teclas = t;
		hilo = new Hilo(this);

		step = 0;

	}

	public static boolean getCreado() {
		return creado;
	}

	public static void setCreado(boolean b) {
		creado = b;
	}

	/**
	 * Inicia la ejecucion del hilo
	 */

	public void iniciar() {
		status = true;

	}

	/**
	 * Contiene la logica que se ejecuta cada intervalo en el hilo
	 */
	public void step() {

		int index = n[step].getPitch();
		for (BotonTecla t : Teclas) {

			String s = t.getTecla();
			String s2 = tr.getPitchesToTeclas().get("" + index);
			if (s.equals(s2)) {
				hilo.pause();
				t.setBackground(new Color(116, 171, 245));
				System.out.println(step + " : " + s2);
				String[] temAr = new String[1];
				temAr[0] = Piano4Noob.getTeclaPresionada();
				if (Piano4Noob.getModo().getModoVar().equals("ApPista")) {
					Boolean bol = Piano4Noob.getModo().evaluar(s2, temAr);
					Piano4Noob.getLblTtAciertos().setText(""+Puntuacion.getAciertos());
					Piano4Noob.getlblTtFallos().setText(""+Puntuacion.getFallos());	
				}
				Play.midiCycle(n[step]);
				Play.stopMidiCycle();
				hilo.pause();

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
	public void detener() {
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

	public void aumentarVelocidad(int multiplicador) {
		int base;
		base = 500;
		hilo.setVelocidad(base * multiplicador);
	}

	public void disminuirVelicidad(int divisor) {
		int base;
		base = 500;
		hilo.setVelocidad((int) (base / divisor));
	}

	public void pausarHilo() {
		hilo.pausarHilo();

	}

	public void reanudar() {
		hilo.reanudarHilo();
	}

}
