<table>
 <tr>
    <td> <img src="https://github.com/OctavioBernalGH/BTC_Reus2022_UD16/blob/main/dou_logo.png" alt="Team DOU"/></td>
    <td><h1>Ejercicio UD20 T09</h1></td>
  
 </tr>
</table>
 
 [comment]: <> (<img src="https://github.com/OctavioBernalGH/BTC_Reus2022_UD16/blob/main/dou_logo.png" alt="Team DOU"/><br>)
 
<hr>
 
 [comment]: <> (### Ejercicios SQL Unidad UD16<hr>)


Este ejercicio ha sido realizado por los miembros del equipo 1. Dicho equipo esta formado por:

  [- J.Oriol López Bosch](https://github.com/mednologic)<br>
  [- Octavio Bernal](https://github.com/OctavioBernalGH)<br>
  [- David Dalmau](https://github.com/DavidDalmauDieguez)
  
En este ejercicio se ha de crear una aplicación utilizando Maven y JFrameForm, en dicho ejercicio se tiene que simular un juego de memoria con al menos 16 cartas, las principales operaciones a realizar serán las siguientes:
  - Las cartas estarán implementadas con ToggleButton o Button.
  - Al pulsar una carta se deberá encontrar a la pareja en el conjunto de cartas. 
  - Al tocar una carta errónea se reiniciará ese conjunto de cartas (la pareja en concreto).
  - Al emparejar dos cartas del mismo tipo estas quedarán levantadas.
  - Al finalizar la partida aparecera un mensaje indicando esto mismo.

En la siguiente imagen se introduce una breve muestra de la funcionialidad del juego realizado. Se podrá observar la ventana principal con sus 16 componentes, el botón de nueva partida (totalmente funcional) y la ventana emergente indicando la victoria. 
  
![Sin título](https://user-images.githubusercontent.com/103035621/167307172-b1f242ae-4080-425f-b49c-c2375e022398.png)

Para este ejercicio se necesitará lo siguiente:
- Se crea la estructura de proyecto utilizando la tecnología Maven.
- Se crean los paquetes Class, View e Img.
- En el paquete Class se crean las clases CartaClass.java y PositionClass.java.
- En el paquete View se crea la clase View.java.
- En el paquete img se añaden las imagenes utilizadas para los componentes de la vista.

En el siguiente punto se procede a la creación de la clase CartaClass.java, se muestra el código referente a esta clase en el spoiler.
<details>
  <summary>Clase CartaClass.java</summary>
<br>
<p align="justify">Se crear la clase CartaClass, en dicha clase se definirá el formato de las cartas con su identificación, su alto y su ancho. Se define el constructor con todos los parámetros y con la llamada a las funciones de clase- Se parametrizará la escala de las cartas y se añadirá la función flip que volteará la carta.</p>
  
  ```java
package com.dou.ud20.t9.Class;


import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/**
 * 
 * @author josep oriol lopez bosch / David Dalmau / Octavio Bernal
 * @version 0.1.1
 * @date 2022/05/07
 */

public class CartaClass extends JToggleButton{
	
	
	public Image imgInit 	= new ImageIcon(this.getClass().getResource("/img/card.png")).getImage();
	public ImageIcon imgInitScaled;
	//public Image imgFlip;
	public ImageIcon imgFlipScaled;
	public String id;
	public int width,height;
	public PosicionClass posicion;
	public boolean blockCard=false;

/**
 * Constructor
 * @param id - name of the card
 * @param width 
 * @param height 
 * @param imgFlip - image flipped
 */
	public CartaClass(String id, int width, int height, Image imgFlip, boolean selected) {
		super();
		this.id = id;
		this.width = width;
		this.height = height;
		//scaling initial image
		this.imgInitScaled = scaleImage(imgInit);
		//scaling flip image
		this.imgFlipScaled = scaleImage(imgFlip);
		//Setting initial image
		this.setIcon(scaleImage(imgInit));
		this.setSelected(selected);;
	}	
/**
 * 
 * @param Image
 * @return image scaled in ImageIconFormat
 */
	public ImageIcon scaleImage(Image imageOriginal) {
		ImageIcon imgScaled 	= null;
		Image imgProcess		= null;
	
		imgProcess = imageOriginal.getScaledInstance(this.width, this.height, ABORT);
		imgScaled = new ImageIcon(imgProcess);
		
		return imgScaled;
	}
	
/**
 * Funtion to flip image
 */
	public void flipCard() {
		if(this.isSelected()) {
			this.setIcon(imgFlipScaled);
			this.setSelected(false);
		}else {
			this.setIcon(imgInitScaled);
			this.setSelected(true);	
		}
		
	}
	
//Getters and Setters
	public Image getImgInit() {
		return imgInit;
	}

	public void setImgInit(Image imgInit) {
		this.imgInit = imgInit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public boolean isBlockCard() {
		return blockCard;
	}
	public void setBlockCard(boolean blockCard) {
		this.blockCard = blockCard;
	}	
}
 
  ```
 </details>

Se crea la clase View donde irá estructurado el código referente a la vista. Se definiran sus componentes y se controlarán sus eventos.
<details>
  <summary>Clase View.java</summary>
<br>
<p align="justify">Se crea la clase View, en dicha clase se crean los componentes que formarán la vista, se les asigna un nombre de componente, se mapea dicho componente con la imagen correspondiente (de forma aleatoria en cada juego) y se le asigna una posición a cada elemento en la vista. En la vista se incluye la lógica de los actionListener para controlar los eventos, como el giro de carta por ejemplo.</p>
  
  ```java
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
	

  ```
 </details>

  Se crea la clase PosicionClass , en dicha clase se construye el alto y el ancho.
<details>
  <summary>Clase PosicionClass.java</summary>
<br>
<p align="justify">La clase PosicionClass es la clase encargada del posicionamiento de los componentes de la vista referente a las cartas. Esta clase se utiliza para ayudar a construir la lista de los componentes que forman la vista utilizando el alto y ancho de las imagenes..</p>
  
  ```java
package com.dou.ud20.t9.Class;

public class PosicionClass {
	
	int alto;
	int ancho;
	
	public PosicionClass(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

} 
  ```
 </details>
 <br>

<p align="justify">En este ejercicio se aprende una mejor estructura de proyecto utilizando la tecnología Maven. Cuando se comienza un proyecto mediante Maven se observa una mayor eficiencia a la hora de generar código, el cuál repercute directamente y de forma positivia en los tiempos de trabajo. También se practica el uso de ficheros externos como pueden ser las imagenes y su manipulación y uso mediante ruta absoluta de proyecto, esto permite que cualquier persona que se descargue este ejercicio pueda utilizar todas las funcionalidades.</p>  
