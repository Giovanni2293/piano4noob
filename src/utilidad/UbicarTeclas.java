package utilidad;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import Gui.Piano4Noob;

public class UbicarTeclas {
	private BotonTecla[] arPiano;
	private int ancho;
	private int alto;
	private Piano4Noob listener;
	

	public UbicarTeclas(int ancho, int alto, Piano4Noob listener) {
		this.ancho = ancho;
		this.alto = alto;
		this.listener = listener;
		arPiano = new BotonTecla[32];
		crearTeclas();
		posicionarBotones();
	}

	public void crearTeclas() {

		BotonTecla Fa3 = new BotonTecla("F3");
		BotonTecla FaS3 = new BotonTecla("FS3");
		BotonTecla Sol3 = new BotonTecla("G3");
		BotonTecla SolS3 = new BotonTecla("GS3");
		BotonTecla La3 = new BotonTecla("A3");
		BotonTecla LaS3 = new BotonTecla("AS3");
		BotonTecla Si3 = new BotonTecla("B3");
		BotonTecla Do4 = new BotonTecla("C4");
		BotonTecla DoS4 = new BotonTecla("CS4");
		BotonTecla Re4 = new BotonTecla("D4");
		BotonTecla ReS4 = new BotonTecla("DS4");
		BotonTecla Mi4 = new BotonTecla("E4");
		BotonTecla Fa4 = new BotonTecla("F4");
		BotonTecla FaS4 = new BotonTecla("FS4");
		BotonTecla Sol4 = new BotonTecla("G4");
		BotonTecla SolS4 = new BotonTecla("GS4");
		BotonTecla La4 = new BotonTecla("A4");
		BotonTecla LaS4 = new BotonTecla("AS4");
		BotonTecla Si4 = new BotonTecla("B4");
		BotonTecla Do5 = new BotonTecla("C5");
		BotonTecla DoS5 = new BotonTecla("CS5");
		BotonTecla Re5 = new BotonTecla("D5");
		BotonTecla ReS5 = new BotonTecla("DS5");
		BotonTecla Mi5 = new BotonTecla("E5");
		BotonTecla Fa5 = new BotonTecla("F5");
		BotonTecla FaS5 = new BotonTecla("FS5");
		BotonTecla Sol5 = new BotonTecla("G5");
		BotonTecla SolS5 = new BotonTecla("GS5");
		BotonTecla La5 = new BotonTecla("A5");
		BotonTecla LaS5 = new BotonTecla("AS5");
		BotonTecla Si5 = new BotonTecla("B5");
		BotonTecla Do6 = new BotonTecla("C6");

		// Se añaden las teclas al arreglo
		arPiano[0] = Fa3;
		arPiano[1] = Sol3;
		arPiano[2] = La3;
		arPiano[3] = Si3;
		arPiano[4] = Do4;
		arPiano[5] = Re4;
		arPiano[6] = Mi4;
		arPiano[7] = Fa4;
		arPiano[8] = Sol4;
		arPiano[9] = La4;
		arPiano[10] = Si4;
		arPiano[11] = Do5;
		arPiano[12] = Re5;
		arPiano[13] = Mi5;
		arPiano[14] = Fa5;
		arPiano[15] = Sol5;
		arPiano[16] = La5;
		arPiano[17] = Si5;
		arPiano[18] = Do6;
		arPiano[19] = FaS3;
		arPiano[20] = SolS3;
		arPiano[21] = LaS3;
		arPiano[22] = DoS4;
		arPiano[23] = ReS4;
		arPiano[24] = FaS4;
		arPiano[25] = SolS4;
		arPiano[26] = LaS4;
		arPiano[27] = DoS5;
		arPiano[28] = ReS5;
		arPiano[29] = FaS5;
		arPiano[30] = SolS5;
		arPiano[31] = LaS5;

	}

	public void posicionarBotones() {
		int xBlanc, yBlanc, xNegra, yNegra,anchoNegra,altoNegra;
		anchoNegra =(int) (ancho * 0.80);
		altoNegra = (int) (alto * 0.65);
		xBlanc = 0;
		yBlanc = 0;

		for (int i = 0; i <= 18; i++) {
			arPiano[i].addKeyListener(listener);
			arPiano[i].addMouseListener(listener);
			arPiano[i].setVerticalAlignment(SwingConstants.BOTTOM);
			arPiano[i].setForeground(Color.DARK_GRAY);
			arPiano[i].setBackground(Color.WHITE);
			arPiano[i].setBounds(xBlanc, yBlanc, ancho, alto);
			xBlanc = xBlanc + ancho;
		}
		xNegra =  ancho - (anchoNegra /2);
		yNegra = 0;
		for (int i = 19; i <= 31; i++) {
			arPiano[i].addKeyListener(listener);
			arPiano[i].addMouseListener(listener);
			arPiano[i].setVerticalAlignment(SwingConstants.BOTTOM);
			arPiano[i].setForeground(Color.WHITE);
			arPiano[i].setBackground(Color.black);
			arPiano[i].setFont(new Font("Tahoma", Font.PLAIN, 10));
			
			
			if(i == 21 || i== 23 || i== 26 || i==28 ){
			arPiano[i].setBounds(xNegra, yNegra, anchoNegra, altoNegra);
			xNegra = xNegra + (2*ancho);
			}
			else{
				arPiano[i].setBounds(xNegra, yNegra, anchoNegra, altoNegra);
				xNegra = xNegra + ancho;
			}

		}

	}

	public BotonTecla[] getArPiano() {
		return arPiano;
	}

}
