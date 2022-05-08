package com.dou.ud20.t9.View;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.dou.ud20.t9.Class.CartaClass;
import com.dou.ud20.t9.Class.PosicionClass;

public class View {

	private JFrame frame;
	private final int WIDTH=100;
	private final int HEIGHT=100;
	//problem rute
	public Image imgCerdo 		= new ImageIcon(this.getClass().getResource("/img/cerdo.png")).getImage();
	public Image imgCalabaza 	= new ImageIcon(this.getClass().getResource("/img/calabaza.png")).getImage();
	public Image imgClown	 	= new ImageIcon(this.getClass().getResource("/img/clown.png")).getImage();
	public Image imgFranki	 	= new ImageIcon(this.getClass().getResource("/img/franki.png")).getImage();
	public Image imgMinion	 	= new ImageIcon(this.getClass().getResource("/img/minion.png")).getImage();
	public Image imgMummy	 	= new ImageIcon(this.getClass().getResource("/img/mummy.png")).getImage();
	public Image imgSeta	 	= new ImageIcon(this.getClass().getResource("/img/seta.png")).getImage();
	public Image imgSkull	 	= new ImageIcon(this.getClass().getResource("/img/skull.png")).getImage();
	
	public CartaClass cardCerdo, cardCalabaza, cardClown, cardFranki, cardMinion, cardMummy, cardSeta, cardSkull;
	public CartaClass cardCerdo2, cardCalabaza2, cardClown2, cardFranki2, cardMinion2, cardMummy2, cardSeta2, cardSkull2;

	public List<CartaClass> listaCartas = new ArrayList<CartaClass>();
	public CartaClass [] compararCartas = new CartaClass[2];
	public List<PosicionClass> listaPosiciones = new ArrayList<PosicionClass>();
	public int contadorCartasDestapadas=1;
	public int contadorParejas=0;

	//TODO: OCTAVIO Crear objetos
	//TODO: David Instanciar las imagenes Listas etc
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		cardCerdo 		= new CartaClass("cerdo", WIDTH, HEIGHT, 	imgCerdo, false);
		cardCerdo2 		= new CartaClass("cerdo", WIDTH, HEIGHT, 	imgCerdo, false);
		cardCalabaza 	= new CartaClass("calabaza", WIDTH, HEIGHT, imgCalabaza, false);
		cardCalabaza2 	= new CartaClass("calabaza", WIDTH, HEIGHT, imgCalabaza, false);
		cardClown		= new CartaClass("clown", WIDTH, HEIGHT, 	imgClown, false);
		cardClown2 		= new CartaClass("clown", WIDTH, HEIGHT, 	imgClown,false);
		cardFranki 		= new CartaClass("franki", WIDTH, HEIGHT, 	imgFranki, false);
		cardFranki2 	= new CartaClass("franki", WIDTH, HEIGHT, 	imgFranki, false);
		cardMinion 		= new CartaClass("minion", WIDTH, HEIGHT, 	imgMinion, false);
		cardMinion2 	= new CartaClass("minion", WIDTH, HEIGHT, 	imgMinion, false);
		cardMummy		= new CartaClass("mummy", WIDTH, HEIGHT, 	imgMummy, false);
		cardMummy2 		= new CartaClass("mummy", WIDTH, HEIGHT, 	imgMummy, false);
		cardSeta		= new CartaClass("seta", WIDTH, HEIGHT, 	imgSeta, false);
		cardSeta2 		= new CartaClass("seta", WIDTH, HEIGHT, 	imgSeta, false);
		cardSkull 		= new CartaClass("skull", WIDTH, HEIGHT, 	imgSkull, false);
		cardSkull2 		= new CartaClass("skull", WIDTH, HEIGHT, 	imgSkull, false);
		
		//Adding cards to list
		listaCartas.add(cardCerdo);
		listaCartas.add(cardCerdo2);
		listaCartas.add(cardCalabaza);
		listaCartas.add(cardCalabaza2);
		listaCartas.add(cardClown);
		listaCartas.add(cardClown2);
		listaCartas.add(cardFranki);
		listaCartas.add(cardFranki2);
		listaCartas.add(cardMinion);
		listaCartas.add(cardMinion2);
		listaCartas.add(cardMummy);
		listaCartas.add(cardMummy2);
		listaCartas.add(cardSeta);
		listaCartas.add(cardSeta2);
		listaCartas.add(cardSkull);
		listaCartas.add(cardSkull2);
		
		//Positions od the cards on the screen
		PosicionClass pos0 = new PosicionClass(6,6);
		PosicionClass pos1 = new PosicionClass(118,6);
		PosicionClass pos2 = new PosicionClass(230,6);
		PosicionClass pos3 = new PosicionClass(342,6);
		PosicionClass pos4 = new PosicionClass(6,117);
		PosicionClass pos5 = new PosicionClass(118,117);
		PosicionClass pos6 = new PosicionClass(230,117);
		PosicionClass pos7 = new PosicionClass(342,117);
		PosicionClass pos8 = new PosicionClass(6,229);
		PosicionClass pos9 = new PosicionClass(118,229);
		PosicionClass pos10 = new PosicionClass(230,229);
		PosicionClass pos11 = new PosicionClass(342,229);
		PosicionClass pos12 = new PosicionClass(6,341);
		PosicionClass pos13 = new PosicionClass(118,341);
		PosicionClass pos14 = new PosicionClass(230,341);
		PosicionClass pos15 = new PosicionClass(342,341);
		
		//Adding positions to array of positions
		listaPosiciones.add(pos0);
		listaPosiciones.add(pos1);
		listaPosiciones.add(pos2);
		listaPosiciones.add(pos3);
		listaPosiciones.add(pos4);
		listaPosiciones.add(pos5);
		listaPosiciones.add(pos6);
		listaPosiciones.add(pos7);
		listaPosiciones.add(pos8);
		listaPosiciones.add(pos9);
		listaPosiciones.add(pos10);
		listaPosiciones.add(pos11);
		listaPosiciones.add(pos12);
		listaPosiciones.add(pos13);
		listaPosiciones.add(pos14);
		listaPosiciones.add(pos15);

		//Actions Listeners
				cardCerdo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardCerdo);	
					}
				});
				cardCerdo2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardCerdo2);
					}
				});
				cardCalabaza.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardCalabaza);
					}
				});
				cardCalabaza2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardCalabaza2);
					}
				});
				cardClown.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardClown);	
					}
				});
				cardClown2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardClown2);	
					}
				});
				cardFranki.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardFranki);	
					}
				}); 
				cardFranki2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardFranki2);	
					}
				}); 
				cardMinion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardMinion);	
					}
				});
				cardMinion2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardMinion2);	
					}
				});
				cardMummy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardMummy);	
					}
				}); 
				cardMummy2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardMummy2);	
					}
				}); 
				cardSeta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardSeta);	
					}
				});
				cardSeta2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardSeta2);	
					}
				});
				cardSkull.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardSkull);	
					}
				});
				cardSkull2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jugada(cardSkull2);	
					}
				});
				
				frame = new JFrame();
				frame.setBounds(100, 100, 602, 503);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				randomicePositions();

				frame.getContentPane().add(cardCerdo);
				
				JButton btnNuevaPartida = new JButton("NuevaPartida");
				btnNuevaPartida.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nuevaPartida();
					}
				});
				btnNuevaPartida.setBounds(465, 18, 117, 29);
				frame.getContentPane().add(btnNuevaPartida);


}
	public void randomicePositions() {
		int counter = 0;
		//Randomizamos la posicion de las cartas
		Collections.shuffle(listaPosiciones);
		
		//Looping to set the positions of the cards
		for(CartaClass carta : listaCartas) {
			int ancho = listaPosiciones.get(counter).getAncho();
			int alto = listaPosiciones.get(counter).getAlto();
			//Seting position
			carta.setBounds(ancho, alto, WIDTH, HEIGHT);
			//Adding to frame
			frame.getContentPane().add(carta);
			counter++;
		}	
	}
	//Recibe la carta cliqueada y acciona el caso correspondiente
		public void jugada (CartaClass cartaActiva) {

			switch(contadorCartasDestapadas) {
			
			case 1:	
				if(!cartaActiva.isBlockCard()) {
					//Seteamos la carta acionada en el array comparador
					compararCartas[0]= cartaActiva;
					cartaActiva.flipCard();
					contadorCartasDestapadas++;
				}
				break;
			case 2:
				if(!cartaActiva.isBlockCard()) {
					//Seteamos la carta acionada en el array comparador
					compararCartas[1]= cartaActiva;
					cartaActiva.flipCard();
					
					//Si las cartas son iguales las bloqueamos
					if(compararCartas[0].getId().equals(compararCartas[1].getId())) {
						compararCartas[0].setBlockCard(true);
						compararCartas[1].setBlockCard(true);
						contadorParejas++;
						if(contadorParejas==8) {
							JOptionPane.showMessageDialog(null, "Felicidades, Has Ganado");
						}
					}else {
						//Seteamos en false las cartas activas comparadas
						compararCartas[0].setSelected(false);
						compararCartas[1].setSelected(false);	
					}

					contadorCartasDestapadas++;	
				}
				break;
				
			case 3:// Gira las cartas y llama al caso 1
				
				//Borramos las cartas del comparador
				compararCartas[0]= null;
				compararCartas[1]= null;
				
				//loop para girar todas las cartas menos las bloqueadas
				for(CartaClass carta: listaCartas) {
					if(!carta.isBlockCard()) {
						if(!carta.isSelected()) {
							carta.flipCard();
							carta.setSelected(false);
						}
						
					}
				}
				contadorCartasDestapadas=1;
				//Llamamos internamente a la funcion pero con el caso 1
				jugada(cartaActiva);
				break;
			}
		}
		public void nuevaPartida() {
			//Reseteamos el juego
			for(CartaClass carta : listaCartas) {
				carta.flipCard();
				carta.setBlockCard(false);
				carta.setSelected(false);
			}
			contadorParejas=0;
			//Randomizamos posiciones
			randomicePositions();
		}

}
	
