package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Rest;
import jm.util.Play;
import motor.Reproduccion;
import sun.misc.PerformanceLogger;
import utilidad.BotonTecla;
import utilidad.STecla;
import utilidad.UbicarTeclas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Piano4Noob implements KeyListener , MouseListener {

	private JFrame frmPianonoobs;
	JLabel etiquetaDeEstado;
	private STecla stec;
	private Reproduccion r; // Elemento necesario para reproducir los sonidos de
							// las teclas del piano que se accionan, las cuales
							// estan asociadas al teclado
	private UbicarTeclas guiTeclado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Piano4Noob window = new Piano4Noob();
				
					window.frmPianonoobs.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Piano4Noob() {
		initialize();
		frmPianonoobs.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		r = r.getRepro(); // Devuelve un objeto unico de tipo Reproduccion

		stec = new STecla();
		frmPianonoobs = new JFrame();
		frmPianonoobs.setTitle("Piano4Noobs");
		frmPianonoobs.setAutoRequestFocus(false);
		frmPianonoobs.setResizable(false);
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int anchoDePantalla = (int) screenSize.getWidth() - 50;
		frmPianonoobs.addKeyListener(this);// Le asocia el Escuchador de eventos de
									// teclados a la ventana
		frmPianonoobs.setBounds(100, 100,0 + anchoDePantalla, 550);
		

		frmPianonoobs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPianonoobs.getContentPane().setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		frmPianonoobs.getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu Archivo = new JMenu("Archivo");
		menuBar.add(Archivo);

		JMenuItem abrir = new JMenuItem("Abrir");
		Archivo.add(abrir);

		JPanel panelContenedor = new JPanel();
		frmPianonoobs.getContentPane().add(panelContenedor);
		panelContenedor.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panelDeControles = new JPanel();
		panelContenedor.add(panelDeControles);
		panelDeControles.setBackground(Color.LIGHT_GRAY);
		panelDeControles.setLayout(null);
		
		JPanel panelDificultad = new JPanel();
		panelDificultad.setBounds(1000, 34, 250, 174);
		panelDeControles.add(panelDificultad);
		
		JPanel difucultad = new JPanel();
		difucultad.setBackground(Color.DARK_GRAY);
		difucultad.setBounds(300, 65, 650, 143);
		panelDeControles.add(difucultad);
		
		JPanel aciertos = new JPanel();
		aciertos.setBounds(100, 34, 150, 80);
		panelDeControles.add(aciertos);
		
		JPanel errores = new JPanel();
		errores.setBounds(100, 128, 150, 80);
		panelDeControles.add(errores);
		
		
		JPanel panelDeTeclado = new JPanel(){
			//Esta instruccion ayuda a que los botones traslapados
			//no cambien su trasposicion tras pasar el mouse
			//IMPORTANTE
		      public boolean isOptimizedDrawingEnabled() {
		        return false;
		      }
		    };
		
		panelContenedor.add(panelDeTeclado);
		panelDeTeclado.setBackground(Color.GRAY);
		
		
	
		
		panelDeTeclado.setLayout(null);
		
		JButton bordeIzquierdo = new JButton("");
		bordeIzquierdo.setEnabled(false);
		bordeIzquierdo.setBackground(Color.LIGHT_GRAY);
		bordeIzquierdo.setBounds(0, 0, 20, 240);
		bordeIzquierdo.setBorder(null);
		panelDeTeclado.add(bordeIzquierdo);
		
		
		
		
		
		JButton bordeDerecho = new JButton("");
		bordeDerecho.setEnabled(false);
		bordeDerecho.setBackground(Color.LIGHT_GRAY);
		bordeDerecho.setBounds(1290, 0, 20, 240);
		bordeDerecho.setBorder(null);
		panelDeTeclado.add(bordeDerecho);
		
		int anchoPanelTeclas;
		anchoPanelTeclas = anchoDePantalla - 40;
		
		JPanel negras = new JPanel();
		negras.setOpaque(false);
		negras.setBounds(20, 0, anchoPanelTeclas, 235);
		negras.setBackground(Color.WHITE);
		panelDeTeclado.add(negras);
		negras.setLayout(null);
		
		JPanel blancas = new JPanel();
		blancas.setBounds(20, 0, anchoPanelTeclas, 235);
		panelDeTeclado.add(blancas);
		blancas.setLayout(null);
		
		// Tamaño para botones // Apartir de aquí agregar botones
				int anchoParaBotones = (anchoDePantalla - 40) / 19;
		
		guiTeclado = new UbicarTeclas(anchoParaBotones, 235, this);
		BotonTecla[] Teclas = new BotonTecla[31];
		Teclas = guiTeclado.getArPiano();
		for(int i=31;0<=i ; i--){
			if (i <= 18){
				blancas.add(Teclas[i]);
			}else{
				negras.add(Teclas[i]);
			}
									
		}
		
		
		

		Panel panelDeEstado = new Panel();
		FlowLayout fl_panelDeEstado = (FlowLayout) panelDeEstado.getLayout();
		fl_panelDeEstado.setVgap(1);
		fl_panelDeEstado.setHgap(2);
		fl_panelDeEstado.setAlignment(FlowLayout.LEADING);
		frmPianonoobs.getContentPane().add(panelDeEstado, BorderLayout.SOUTH);

		etiquetaDeEstado = new JLabel(" ");
		panelDeEstado.add(etiquetaDeEstado);
		etiquetaDeEstado.setFont(new Font("Arial", Font.PLAIN, 10));
		etiquetaDeEstado.setBackground(Color.LIGHT_GRAY);
		etiquetaDeEstado.setVerticalAlignment(SwingConstants.BOTTOM);
		etiquetaDeEstado.setHorizontalAlignment(SwingConstants.LEFT);

		Play.midiCycle(new Rest(JMC.HALF_NOTE)); // La clase Play pertenece a la
													// libreria JMusic, el
													// metodo midiCycle
													// reproduce el sonido de la
													// nota
		Play.stopMidiCycle();// metodo de la clase Play que se encaarga de
								// detener la reproducion iniciada en midiCycle

	}

	/**
	 * Metodo de la interfaz KeyListener en este caso simplemente no se
	 * reescribio
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * Metodo de la interfaz KeyListener reescrito para manejar el texto de la
	 * etiqueda de la gui y reproducir un sonido simultaneamente Este metodo se
	 * activa cuando una tecla se presiona
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// l.setText(e.getKeyText(e.getKeyCode())); //Reemplaza el contenido de
		// la etiqueta la gui por el simbolo de la tecla presionada

		stec.selectTecla(e.getKeyText(e.getKeyCode())); // Segun la tecla
														// presionada se
														// reproduce un sonido
														// en respuesta
		etiquetaDeEstado.setText(stec.getNota());
	}

	/**
	 * Metodo de la interfaz KeyListener reescrito para detener la reproducion
	 * de un sonido Este metodo se activa cuando una tecla se suelta
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		r.setTemp("");

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof BotonTecla)//prevencion. clases anonimas > otras
		{
			BotonTecla b = (BotonTecla)e.getSource();
			stec.selectTecla(b.getTecla()); //Segun la tecla presionada se reproduce un sonido en respuesta
			etiquetaDeEstado.setText(stec.getNota());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof BotonTecla)
		{
			r.setTemp("");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
