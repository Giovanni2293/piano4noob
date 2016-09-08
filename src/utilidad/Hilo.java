/* Esta clase se encarga de construir el hilo mediante Singleton y solo se puede acceder al hilo mediante su metodo estatico
 */

package utilidad;

import java.util.Date;

public class Hilo extends Thread {
    /*
     * se crean dos objetos colaboradores. Mediador que se encarga de contener la logica que se ejecutara en el hilo y el hilo necesario para singleton
     */
	private  Tutor m;
	private boolean pause;
	private int velocidad;

	
/**
 * Constructor del Hilo que recibe como parametro el objeto Mediador que contiene 
 * la logica de corrida del hilo y se define con nombre Coor. Finalmente se inicializa.
 * @param m
 */
	public Hilo(Tutor m ) {
		super("Coor");
		this.m = m;
		this.start();
		velocidad = 500;

	}
/**
 * Metodo que permite obtener un unico hilo no importa cuantas veces sea llamado el metodo
 * @param m
 * @return h Hilo en ejecucion
 */
	


	/**
	 * Metodo encargado de la ejecucion del hilo
	 */
	public void run() {
		Date t0 = new Date();
		while (m.getStatus()) {
			try {
				synchronized (this) {
					if (pause) {
						System.out.println("Paused");
						wait();
						System.out.println("Resumed");
					}
				}
				long secs = ((new Date()).getTime() - t0.getTime()) / 1000;
				System.out.println(secs);
				
			} catch (InterruptedException ex) {
				System.err.println(ex);
			}
			m.step();
			
		}
		// pause();
		}
	

	/**
	 * Temporizador que permite simular el paso del tiempo.
	 * El parametro en Thread.sleep es un tiempo dado en milisegundos
	 */
	public void pause() {
		try {
			
			Thread.sleep(velocidad);
			// pause for 1000 milliseconds (1 second)
		} catch (InterruptedException exc) {
		}
	}
	
	public void setVelocidad(int vel){
		velocidad = vel;
	}
	
	public synchronized void pausarHilo() {
		pause = true;
		}
			
	
	public synchronized void reanudarHilo() {
		pause= false;
		notify();
		}
	
}
