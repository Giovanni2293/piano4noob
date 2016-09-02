package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
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
import utilidad.STecla;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Panel;
import java.awt.Font;

public class Piano4Noob implements KeyListener {

	private JFrame frmPianonoobs;
	JLabel etiquetaDeEstado;
	private STecla stec;
	private Reproduccion r; // Elemento necesario para reproducir los sonidos de
							// las teclas del piano que se accionan, las cuales
							// estan asociadas al teclado

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
		frmPianonoobs.setBounds(100, 100, 0 + anchoDePantalla, 550);
		

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
		panelDeControles.setBackground(Color.WHITE);
		panelDeControles.setBorder(new LineBorder(Color.RED, 3));

		JPanel panelDeTeclado = new JPanel();
		panelContenedor.add(panelDeTeclado);
		panelDeTeclado.setBackground(Color.WHITE);
		
	
		// Tamaño para botones // Apartir de aquí agregar botones
		int anchoParaBotones = anchoDePantalla / 19;
		panelDeTeclado.setLayout(null);
		
		
		JButton Fa3 = new JButton("F3");
		Fa3.setBounds(0, 0, 0 + anchoParaBotones, 240);
		Fa3.setForeground(Color.DARK_GRAY);
		Fa3.setBackground(UIManager.getColor("Button.highlight"));
		Fa3.setEnabled(false);
		Fa3.setVerticalAlignment(SwingConstants.BOTTOM);
		panelDeTeclado.add(Fa3);
		
		

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
}
