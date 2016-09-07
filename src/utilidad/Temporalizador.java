/**
 * Clase encargada de ejecutar la logica del hilo
 */

package utilidad;

import jm.music.data.Note;
import motor.Reproduccion;

public class Temporalizador {
	
    /*
     * status se encarga de mantener con vida el hilo y step es el numero de ejecucion del hilo 
     * (simulando el tiempo transcurrido)
     */
	
	private boolean status;
    private static int step;
    private Reproduccion r;
    private String n;
    
  
    
 


	public Temporalizador(String n) {
		super();
		this.n = n;
		r= Reproduccion.getRepro();
		
		
		
	}


	/**
	 * Inicia la ejecucion del hilo
	 */
    
    
	 public void iniciar()
	    {
	    	 status = true;
	    	 Hilo hilo = Hilo.getHilo(this);
	    }
	    
	 
	 /**
	  * Contiene la logica que se ejecuta cada intervalo en el hilo
	  */
	    public void step()
	    {
	    	step++;
	    	System.out.println(step + "ejecucion" );
	    	
	    }
		
	    
	    /**
	     * Permite conocer si el hilo esta activo o no
	     * @return status Estado del hilo
	     */
		public boolean getStatus()
		{
		return status;	
		}
		
		
		/**
		 * Detiene la ejecucion del hilo
		 */
		private void detener()
		{
		       status = false;
		}
		
		
		/**
		 * Devuele el numero del ciclo en el que se encuentra el hilo
		 * @return step Ciclo actual del hilo
		 */
		public int getStep()
		{
			return step;
		}
		
		
}
