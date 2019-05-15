package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

public class MainActivity extends Application {

    @FXML
    private TextField mGreetingText;
    @FXML
    private TextField mNameInput;
    @FXML
    private Button mPlayButton;
    @FXML
    private User mUser;

    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";

    public void greetUser() {

       // Create and instantiate a variable 'firstName' by getting PREF_KEY_FIRSTNAME

       // If firstName isn't null
        // then create a variable 'score' and instantiate by getting PREF_KEY_SCORE
        // Create a variable 'fullText' and instantiate with ("Welcome back, " + firstname + "!\nYour last score was " + score + ", will you do better this time?")
        // Set fullText in mGreetingText
        // Set firstName in mNameInput
        //mNameInput.positionCaret(firstName.length()); // Positions the caret at the end of 'firstName'
        mPlayButton.setDisable(false); // Make it so 'mPlayButton' is not greyed anymore
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
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     */
    @Override
    public void start(Stage primaryStage) {

        mUser = new User();
        mPlayButton.setDisable(true); // Grey out the playButton if firstName is null (no user created)

        greetUser(); // If done right, "playButton" shouldn't be grey anymore at this point

    }

    public static void main(String[] args) {
        launch(args);
    }
}
