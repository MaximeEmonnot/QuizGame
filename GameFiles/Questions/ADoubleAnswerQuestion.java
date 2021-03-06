package GameFiles.Questions;

import Exceptions.ProjectException;

import java.awt.*;

/**
 * Classe abstraite
 * <p>Definitions de base d'une question a deux possibilites de reponse
 * @author Maxime Emonnot
 * @version 1.1.0
 */
public abstract class ADoubleAnswerQuestion extends AQuestion {

    /**
     * Differents type de reponses pour les questions a deux possibilites
     * @author Maxime Emonnot
     */
    public enum AnswerType{
        ANSWER_A,
        ANSWER_B,
        BOTH,
        NONE
    }

    /**
     * Constructeur ADoubleAnswerQuestion
     * <p>Reprend le constructeur de AQuestion et initilise les differentes propositions ainsi que la reponse
     * @author Maxime Emonnot
     * @param _question Intitule de la question
     * @param _timer Temps necessaire pour repondre
     * @param _answerA Proposition A
     * @param _answerB Proposition B
     * @param _type Reponse correcte
     */
    public ADoubleAnswerQuestion(String _question, float _timer, String _answerA, String _answerB, AnswerType _type) {
        super(_question, _timer);
        //TODO Auto-generated constructor stub
        answerA = _answerA;
        answerB = _answerB;
        type = _type;
    }

    /**
     * {@inheritDoc}
     * <p>Affichage des deux propositions de reponse
     * @author Maxime Emonnot
     */
    @Override
    public void Draw() throws ProjectException{
        super.Draw();
        GraphicsEngine.GraphicsSystem.GetInstance().DrawText("A) " + answerA, new Point(320 - (answerA.length() * 4), 625), new Font("Arial Bold", Font.PLAIN, 16), Color.BLACK, 16);
        GraphicsEngine.GraphicsSystem.GetInstance().DrawText("B) " + answerB, new Point(960 - (answerB.length() * 4), 625), new Font("Arial Bold", Font.PLAIN, 16), Color.BLACK, 16);
    }
    
    private final String answerA;
    private final String answerB;
    private final AnswerType type;
}
