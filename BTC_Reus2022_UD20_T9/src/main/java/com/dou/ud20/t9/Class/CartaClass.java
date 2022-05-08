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
	
	
	public Image imgInit 	= new ImageIcon(this.getClass().getResource("/card.png")).getImage();
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

