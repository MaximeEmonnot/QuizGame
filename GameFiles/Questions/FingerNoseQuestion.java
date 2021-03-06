package GameFiles.Questions;

import java.awt.Color;

import Exceptions.ProjectException;
import GameFiles.Questions.InteractiveItems.*;

/**
 * Mini-jeu a deux proposition de reponse
 * <p>Deux narines representent les deux possibilites, l'utilisateur doit mettre le doigt dans la narine correspondant a la bonne reponse
 * @author Maxime Emonnot
 * @version 1.1.0
 */
public class FingerNoseQuestion extends ADoubleAnswerQuestion {

    /**
     * Constructeur ConcreteDoubleQuestion
     * <p>Reprend le constructeur de ADoubleAnswerQuestion, et initialise le nez pour la narine correspondant a la bonne reponse
     * @author Maxime Emonnot
     * @param _question Intitule de la question
     * @param _timer Temps necessaire pour repondre
     * @param _answerA Proposition A
     * @param _answerB Proposition B
     * @param _type Reponse correcte
     */
    public FingerNoseQuestion(String _question, float _timer, String _answerA, String _answerB, AnswerType _type) {
        super(_question, _timer, _answerA, _answerB, _type);
        //TODO Auto-generated constructor stub
        switch (_type){
        case ANSWER_A:
            nose = new Nose(1);
            break;
        case ANSWER_B:
            nose = new Nose(2);
            break;
        case BOTH:
            nose = new Nose(3);
            break;
        default:
            break;
        }
    }
    
    /**
     * {@inheritDoc}
     * <p>Mise a jour du mini-jeu
     * <p>Mise a jour des differentes animations, et des differents etats de succes et d'echec
     * @author Maxime Emonnot
     */
    @Override
    public void Update() {
        // TODO Auto-generated method stub
        super.Update();

        nose.Update();
        finger.Update();

        bIsWon = nose.HasWon();
        bIsLost = bIsLost || nose.HasLost();
    }
    
    /**
     * {@inheritDoc}
     * Affichage du nez et du doigt
     * @author Maxime Emonnot
     */
    @Override 
    public void Draw() throws ProjectException{
        super.Draw();
        GraphicsEngine.GraphicsSystem.GetInstance().SetBackgroundColor(Color.LIGHT_GRAY);
        nose.Draw();
        finger.Draw();
    }
    
    private Nose nose;
    private Finger finger = new Finger();
}
