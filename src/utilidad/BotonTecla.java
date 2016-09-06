package utilidad;

import javax.swing.JButton;

public class BotonTecla extends JButton{
	private String tecla;
	private Traductor tradTecla;
	public BotonTecla(String nombre)
	{
		super(nombre);
		tradTecla = new Traductor();
		tecla = tradTecla.getMapaDeTeclas().get(nombre);
		
		
	}
	public String getTecla() {
		return tecla;
	}
	
}
