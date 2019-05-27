package controller;

import javafx.stage.Stage;
import model.Question;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        GameActivity game = new GameActivity();
        Stage testStage = new Stage();
        Question question = new Question();
        Question question1 = new Question("A quel écrivain doit-on le personnage de Boule-de-Suif ? ",
                Arrays.asList("Guy de Maupassant", "Gustave Flaubert", "Honoré de Balzac", "Théodore Rousseau"),
                0);

        game.displayQuestion(question1);
        game.start(testStage);
    }
}
