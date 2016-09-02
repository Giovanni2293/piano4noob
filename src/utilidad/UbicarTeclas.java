package utilidad;


import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Gui.Piano4Noob;

public class UbicarTeclas {
	private BotonTecla[] arPiano;
	private int ancho;
	private int alto;
	private Piano4Noob listener;
	
	public UbicarTeclas( int ancho , int alto , Piano4Noob listener )
	{
		this.ancho = ancho;
		this.alto = alto;
		this.listener = listener;
		arPiano= new BotonTecla[19];
		crearTeclas();
		posicionarBotones();
	}
	
	
	
	
	public void crearTeclas()
	{
		
		//Teclas Blancas
		BotonTecla Fa3 = new BotonTecla("F3","Q");
		BotonTecla Sol3 = new BotonTecla("G3", "W");
		BotonTecla La3 = new BotonTecla("A3", "E");
        BotonTecla Si3 = new BotonTecla("B3", "R");
		BotonTecla Do4 = new BotonTecla("C4", "T");
		BotonTecla Re4 = new BotonTecla("D4", "Y");
		BotonTecla Mi4 = new BotonTecla("E4", "U");
		BotonTecla Fa4 = new BotonTecla("F4", "I");
		BotonTecla Sol4 = new BotonTecla("G4", "O");
		BotonTecla La4 = new BotonTecla("A4", "P");
		BotonTecla Si4 = new BotonTecla("B4", "Acento Agudo Muerto");
		BotonTecla Do5 = new BotonTecla("C5", "Z");
		BotonTecla Re5 = new BotonTecla("D5", "X");
		BotonTecla Mi5 = new BotonTecla("E5", "C");
		BotonTecla Fa5 = new BotonTecla("F5", "V");
		BotonTecla Sol5 = new BotonTecla("G5", "B");
		BotonTecla La5 = new BotonTecla("A5", "N");
		BotonTecla Si5 = new BotonTecla("B5", "M");
		BotonTecla Do6 = new BotonTecla("C6", "Coma");
		//Se añaden las teclas al arreglo
		arPiano[0]= Fa3 ;
		arPiano[1]= Sol3 ;
		arPiano[2]= La3;
		arPiano[3]= Si3 ;
		arPiano[4]= Do4;
		arPiano[5]= Re4;
		arPiano[6]= Mi4;
		arPiano[7]= Fa4;
		arPiano[8]= Sol4;
		arPiano[9]= La4;
		arPiano[10]= Si4;
		arPiano[11]= Do5;
		arPiano[12]= Re5;
		arPiano[13]= Mi5;
		arPiano[14]= Fa5;
		arPiano[15]= Sol5;
		arPiano[16]= La5;
		arPiano[17]= Si5;
		arPiano[18]= Do6;
		
		
		
		
	}
	
	public void posicionarBotones()
	{
		int xin, yin;
		xin=20;
		yin=0;
		for(int i=0;i<19;i++)
		{	
			arPiano[i].addKeyListener(listener);
			arPiano[i].addMouseListener(listener);
			arPiano[i].setVerticalAlignment(SwingConstants.BOTTOM);
			arPiano[i].setForeground(Color.DARK_GRAY);
			arPiano[i].setBackground(Color.WHITE);
			arPiano[i].setBounds(xin, yin, ancho, alto);
			xin=xin+ancho;
		}
		
			
	}

	public BotonTecla[] getArPiano() {
		return arPiano;
	}

}
