package GameFiles.Questions.InteractiveItems;

import java.awt.Rectangle;

import Exceptions.ProjectException;
import GraphicsEngine.Animation;
import GraphicsEngine.GraphicsSystem;
import GraphicsEngine.Sprite;

/**
 * Classe Cardboard
 * <p>Carton utilise dans CardBoardQuestion
 * <p>Contient soit de l'argent soit un scorpion
 * @author Thierno Amadou Diallo
 * @see CardBoardQuestion
 * @version 1.4.0
 */
public class CardBoard{ 
	
	/**
	 * Contructeur CardBoard
	 * <p>Definit les positions et la validite du carton
	 * @author Thierno Amadou Diallo
	 * @param _destRect Rectangle d'affichage du carton
	 * @param _destRep Rectangle d'affichage du contenu
	 * @param _bIsRight Validite du carton
	 */
	public CardBoard(Rectangle _destRect, Rectangle _destRep, boolean _bIsRight){
		destRect = _destRect;
		destRep = _destRep;
		bIsRight = _bIsRight;
	}
	  
	/**
	 * Mise a jour du carton
	 * <p>Lors d'un clic sur le carton, mise a jour de l'etat de revelation
	 * @author Thierno Amadou Diallo
	 * @param e Entree souris
	 */
	public void Update(CoreSystem.Mouse.EventType e){
		if (e == CoreSystem.Mouse.EventType.LRelease && destRect.contains(CoreSystem.Mouse.GetInstance().GetMousePos())){
		    bIsRevealed = true;
		}
		if (bIsRevealed){
			scorpion.Update();
		}
	}
		  
	/**
	 * Affichage de la boite, et de son contenu si revele
	 * @author Thierno Amadou Diallo
	 * @throws ProjectException Erreur de l'instanciation de GraphicsSystem
	 */
	public void Draw() throws ProjectException{ 
		if (bIsRevealed) {
			if (bIsRight) GraphicsSystem.GetInstance().DrawSprite(money, destRep, new Rectangle(0, 0, 64, 64), 1);
		    else scorpion.Draw(destRep, 1);
			GraphicsSystem.GetInstance().DrawSprite(cardBoard, destRect, new Rectangle(40, 0, 40, 64));
		}
		else GraphicsEngine.GraphicsSystem.GetInstance().DrawSprite(cardBoard, destRect, new Rectangle(0, 0, 40, 64));
	}

	/**
	 * Recuperation de l'etat de succes
	 * @author Thierno Amadou Diallo
     * @return Vrai si le carton est valide et si le contenu est revele, Faux sinon
	 */
	public boolean HasWon(){
		return bIsRight && bIsRevealed;
	}
		  
	/**
	 * Recuperation de l'etat d'echec
	 * @author Thierno Amadou Diallo
     * @return Vrai si le carton est non valide et si le contenu est revele, Faux sinon
	 */
	public boolean HasLost(){
		return !bIsRight && bIsRevealed;
	}

	private Sprite cardBoard = new Sprite("Images/boxStates.png");
	private Sprite money = new Sprite("Images/money.png");
	private Animation scorpion = new Animation(new Rectangle(0, 0, 78, 86), 6, new Sprite("Images/scorpion.png"), 0.1f);
	private Rectangle destRect;
	private Rectangle destRep;
	private boolean bIsRight;
	private boolean bIsRevealed = false;
}
