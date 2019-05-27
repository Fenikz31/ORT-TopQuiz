package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DAO.UserDAO;

import java.io.IOException;
import java.util.prefs.Preferences;

public class MainActivity extends Application {

    private static final String PREF_KEY_SCORE = "PREF_KEY_SCORE"; // Create a class variable to store key's score name
    @FXML
    private Label mGreetingText;
    @FXML
    private TextField mNameInput;
    @FXML
    private Button mPlayButton;
    @FXML
    private UserDAO mUser = new UserDAO();
    private static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME"; // Create a class variable to store key's firstname name
    @FXML
    private AnchorPane fxWelcomeScene;
    private Preferences mPreferences; //Returns the preference node from the calling user's preference

    public void greetUser() {

        String firstName; // Create and instantiate a variable 'firstName' by getting PREF_KEY_FIRSTNAME and setting it to null

        // Make sure the user's name is 3 characters or more long
        if (mNameInput.getText().isEmpty()) {// If firstName isn't null
            int score = mPreferences.getInt(PREF_KEY_SCORE, 0);
            firstName = mPreferences.get(PREF_KEY_FIRSTNAME, mNameInput.getText()); // Get the text the user insert

            String fulltext = "Welcome back, " + firstName + "!\nYour last score was " + score + ", will you do better this time?"; // Create a variable 'fullText' and instantiate with ("Welcome back, " + firstname + "!\nYour last score was " + score + ", will you do better this time?")

            if (firstName.equals(mUser.find(firstName).getmFirstName()))
                mGreetingText.setText(fulltext); // Set fullText in mGreetingText

            mPreferences.putInt(PREF_KEY_SCORE, 0); // then create a variable 'score' and instantiate by getting PREF_KEY_SCORE and setting to 0 for a new game
        } else while (mNameInput.getLength() <= 3) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error name input");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Make sure the user's name contains 3 characters or more");

            alert.showAndWait();
            if (mNameInput.getLength() > 3) {
                firstName = mNameInput.textProperty().getValue();
                String fulltext = "Welcome " + firstName + " in TopQuiz!";

                System.out.println("firstName = " + firstName);
                mUser.create_user(firstName);
                mGreetingText.setText(fulltext);
                mGreetingText.getText();

                // Create another user in database if the user's name is not in the database
                if (!firstName.equals(String.valueOf(mUser.find(firstName).getmFirstName()))) {
                    mUser = new UserDAO();
                    mUser.create_user(firstName).setmFirstName(firstName);
                    System.out.println(mUser.find(firstName).getmFirstName());
                } else {
                    mUser.find(firstName).setmFirstName(firstName);
                    System.out.println(mUser.find(firstName).getmFirstName());
                }
            }
        }
    }

    public void onMouseclicked() {

        // User clicked the button
        mPlayButton.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 1) {

                if (mNameInput.getLength() == 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error name input");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Make sure to fill the user's name");

                    alert.showAndWait();
                }
            }
            greetUser();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

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

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainActivity.class.getResource("MainActivity.view.fxml"));
            loader.setRoot(fxWelcomeScene);
            fxWelcomeScene = loader.load();

            Scene welcomeScene = new Scene(fxWelcomeScene);
            primaryStage.setTitle("TopQuiz - Welcome");
            primaryStage.setScene(welcomeScene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e);
        }



    }

    public static void main(String[] args) {
        launch(args);
    }
}
