package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import static java.util.prefs.Preferences.userRoot;

public class MainActivity extends Application {

    private static final String PREF_KEY_SCORE = "PREF_KEY_SCORE"; // Create a class variable to store key's score name
    @FXML
    private TextField mGreetingText;
    @FXML
    private TextField mNameInput;
    @FXML
    private Button mPlayButton;
    @FXML
    private User mUser;
    private static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME"; // Create a class variable to store key's firstname name
    @FXML
    private AnchorPane fxWelcomeScene;
    private Preferences mPreferences; //Returns the preference node from the calling user's preference

    public void greetUser() {

        String firstName = null; // Create and instantiate a variable 'firstName' by getting PREF_KEY_FIRSTNAME and setting it to null
        try {
            firstName = mPreferences.get(PREF_KEY_FIRSTNAME, null);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (firstName != null) {// If firstName isn't null
            int score = Integer.parseInt(PREF_KEY_SCORE);
            String fulltext = "Welcome back, " + firstName + "!\nYour last score was " + score + ", will you do better this time?"; // Create a variable 'fullText' and instantiate with ("Welcome back, " + firstname + "!\nYour last score was " + score + ", will you do better this time?")
            mGreetingText.setText(fulltext); // Set fullText in mGreetingText
            mNameInput.setText(firstName); // Set firstName in mNameInput
            mNameInput.positionCaret(firstName.length()); // Positions the caret at the end of 'firstName'  *
            mPlayButton.setDisable(false); // Make it so 'mPlayButton' is not greyed anymore
            mPreferences.getInt(PREF_KEY_SCORE, 0); // then create a variable 'score' and instantiate by getting PREF_KEY_SCORE and setting to 0 for a new game
        } else {
            String fulltext = null;
            try {
                fulltext = "Welcome in TopQuiz!";
                mGreetingText.setText(fulltext);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void onMouseclicked() {

        try {
            String firstName = mNameInput.getText(); // We declare that firstName is the string put in mNameInput
            mUser.setmFirstName(firstName); // Make input declared the user's firstName
            mPreferences.put(PREF_KEY_FIRSTNAME, mUser.getmFirstName()); // Associate PREF_KEY_FIRSTNAME and this user's firstName
            mPreferences.sync(); // Make sure the change is applied
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }

        // User clicked the button
        mPlayButton.setOnMouseClicked((event) -> {
            GameActivity gameActivity = new GameActivity();
            gameActivity.start(new Stage());
        });
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
        mPreferences = userRoot();

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setRoot(fxWelcomeScene);
            loader.setLocation(MainActivity.class.getResource("MainActivity.view.fxml"));
            fxWelcomeScene = loader.load();

            Scene welcomeScene = new Scene(fxWelcomeScene);
            primaryStage.setTitle("TopQuiz - Welcome");
            primaryStage.setScene(welcomeScene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e);
        }

       /* try {
            mPlayButton.setDisable(true); // Grey out the playButton if firstName is null (no user created)
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        greetUser(); // If done right, "playButton" shouldn't be grey anymore at this point


    }

    public static void main(String[] args) {
        launch(args);
    }
}
