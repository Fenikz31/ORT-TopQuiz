package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Question;
import model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends Application {

    @FXML
    private TextField mQuestionText;
    @FXML
    private Button mGameAnswer1;
    @FXML
    private Button mGameAnswer2;
    @FXML
    private Button mGameAnswer3;
    @FXML
    private Button mGameAnswer4;

    private Question mQuestion;
    private QuestionBank mQuestionBank;

    private int mScore;
    private int mNumberOfQuestions;

    public static final String EXTRA_SCORE = "EXTRA_SCORE";
    public static final String STATE_SCORE = "currentScore";
    public static final String STATE_QUESTION = "currentQuestion";

    private void displayQuestion(final Question question) {
        // Set the text for the question text view and the four buttons
        mQuestionText.setText(question.getQuestion());
        mGameAnswer1.setText(question.getChoiceList().get(0));
        mGameAnswer2.setText(question.getChoiceList().get(1));
        mGameAnswer3.setText(question.getChoiceList().get(2));
        mGameAnswer4.setText(question.getChoiceList().get(3));
    }

    private void endGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Well done!");
        alert.setContentText("Your score is " + mScore);
    }

    private QuestionBank generateQuestion() {

        Question question1 = new Question("A quel écrivain doit-on le personnage de Boule-de-Suif ? ",
                Arrays.asList("Guy de Maupassant", "Gustave Flaubert", "Honoré de Balzac", "Théodore Rousseau"),
                0);

        Question question2 = new Question("Avec quel chanteur Carole Fredericks & Michael Jones ont-il formé un trio ?",
                Arrays.asList("Patrick Bruel", "Yannick Noah", "Pascal Obispo","J.-J. Goldman " ),
                3);

        Question question3 = new Question("Quel conseil régional est présidé par Ségolène Royal depuis 2004 ? ",
                Arrays.asList("Midi-Pyrénées","Poitou-Charentes ","Auvergne","Corse"),
                1);

        Question question4 = new Question("Comment se prénommait la soeur, sculptrice, de Paul Claudel ?",
                Arrays.asList("Julie","Marie","Camille","Suzanne"),
                2);

        Question question5 = new Question("A quel pape a succédé Jean-Paul II ? ",
                Arrays.asList("François Jorge Mario Bergoglio", "Clément XII Lorenzo Corsini","Jean-Paul Ier","Innocent V Pierre de Tarentaise"),
                2);

        Question question6 = new Question("Dans quel jeu télévisé intervenaient Barjabule et Mironton ?",
                Arrays.asList("Pyramide","Jeopardy","Le Juste Prix","Deschiffres et des lettres"),
                0);

        Question question7 = new Question("Quel nom rime avec Paul-Loup Sulitzer dans 'Foule sentimentale' de Souchon ?",
                Arrays.asList("Cindy Lauper","Claudia Schiffer","Jennifer","Fox Mulder"),
                1);

        Question question8 = new Question("De quel pays Tirana est-elle la capitale",
                Arrays.asList("L'Albanie", "L'Azerbaïdjan","L'Arménie", "Le Nicaragua"),
                0);

        Question question9 = new Question("Comment étaient surnommés les enrôlés de force dans la Wehrmacht ? ",
                Arrays.asList("les on a pas eu le choix","Les on nous a obligé","les nous sommes dégoutés","Les malgré-nous "),
                3);

        Question question10 = new Question("Qui est le père de la fille de Vincent Cassel ?",
                Arrays.asList("L'ex de la mère", "Vincent Cassel", "Mathieu Kassovitz", "Luc Besson"),
                2);

        Question question11 = new Question("De quel groupe Jim Morrison était-il le chanteur ?",
                Arrays.asList("Sex Pistols","The Doors","Kiss","AC/DC"),
                1);

        Question question12 = new Question("Quel est l'impératif du verbe peindre à la 2e personne du pluriel ?",
                Arrays.asList("Peigniez","Peignissiez","Peignîtes","Peignez"),
                3);

        Question question13 = new Question("En géométrie, combien de côtés possède un losange ?",
                Arrays.asList("3","5","4","8"),
                2);

        Question question14 = new Question("Dans quelle ville française se trouve la Cité de l'espace ?",
                Arrays.asList("Toulouse", "Houston", "Kiev", "Hong-Kong"),
                0);

        Question question15 = new Question("Combien de mercenaires combattaient aux côtés de Yul Brynner en 1960 ?",
                Arrays.asList("7","12","6","9"),
                2);

        Question question16 = new Question("Quel nom porte le bateau dont Théodore Géricault peint le radeau ?",
                Arrays.asList("L'albatros","La Méduse ","Le Titanic","Le Black Pearl"),
                1);

        Question question17 = new Question("Quel nom porte le siège de la police londonienne ?",
                Arrays.asList("MI-6","Interpol","36 Quai des Orfèvres","Scotland Yard"),
                3);

        Question question18 = new Question("Quel parti politique a son siège place du Colonel-Fabien à Paris ?",
                Arrays.asList("Le Parti Communiste Français ", "Le Parti Socialiste","La République En Marche", "Le MoDem"),
                0);

        Question question19 = new Question("Qui cause des problèmes à Michel Blanc dans 'Grosse Fatigue' ?",
                Arrays.asList("Michel Noir", "Son Oncle","Son sosie","Louis de Funès"),
                2);

        Question question20 = new Question("A quelle saison le boeuf est-il le plus fécond ?",
                Arrays.asList("Aucune","L'hiver","Le printemps","l'automne"),
                0);



        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9,
                question10,
                question11,
                question12,
                question13,
                question14,
                question15,
                question16,
                question17,
                question18,
                question19,
                question20));



        /*        "Dans quelle ville se déroule chaque année le Festival interceltique ? \n" +
                "Lorient \n"

                " \n" +
                "\n"

                "Sous quel titre français connaît-on le film \"Vertigo\" d'Alfred Hitchcock ? \n" +
                "Sueurs froides \n"

                "Quel comédien est le mari de Mélanie Griffith ? \n" +
                "Antonio Banderas \n"

                "De quoi parle-t-on quand on évoque la robe d'un cheval ? \n" +
                "Son pelage \n"

                "Quel chanteur a longtemps formé un duo avec Art Garfunkel ? \n" +
                "Paul Simon \n"

                "Si ce n'est pas un fruit, qu'est-ce qu'un kiwi ? \n" +
                "Un oiseau \n"

                "A quel mouvement littéraire sont associés Ronsard et du Bellay ? \n" +
                "La Pléiade \n" +
                " \n" +
                "Aucune \n" +
                "Où le général de Gaulle prononce-t-il son fameux : \"Je vous ai compris\" ? \n" +
                "Alger ") */

    }


    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param gameStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage gameStage) {

        mQuestionBank = this.generateQuestion();

        if (mScore != 0){
            mScore = Integer.valueOf(STATE_SCORE);
            mNumberOfQuestions = Integer.valueOf(STATE_QUESTION);
        } else {
            mScore = 0;
            mNumberOfQuestions = 8;
        }

        mQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mQuestion);

        if (--mNumberOfQuestions == 0) {
            // End the game
            endGame();
        } else {
            mQuestion = mQuestionBank.getQuestion();
            displayQuestion(mQuestion);
        }

    }
}
