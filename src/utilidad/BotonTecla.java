package utilidad;

import javax.swing.JButton;

public class BotonTecla extends JButton{
	private String tecla;
	public BotonTecla(String nombre,String tecla)
	{
		super(nombre);
		this.tecla=tecla;
		
	}
	public String getTecla() {
		return tecla;
	}
	
}
