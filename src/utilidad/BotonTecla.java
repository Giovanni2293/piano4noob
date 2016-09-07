package utilidad;

import javax.swing.JButton;

public class BotonTecla extends JButton{
	private String tecla,nombre;
	private Traductor tradTecla;
	
	public BotonTecla(String nombre)
	{
		super(nombre);
		this.nombre = nombre;
		tradTecla = new Traductor();
		tecla = tradTecla.getMapaDeTeclas().get(nombre);
		
		
	}
	
	public String getTecla() {
		return tecla;
	}
	public String getNombre(){
		return nombre;
	}

	
}
