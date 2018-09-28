/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionare;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nedas
 */
public class SecondController implements Initializable {

    @FXML
    private ToggleGroup Question1;
    @FXML
    private ToggleGroup Question2;
    @FXML
    private ToggleGroup Question3;
    @FXML
    private ToggleGroup Question4;
    @FXML
    private ToggleGroup Question5;
    @FXML
    private ToggleGroup Question6;
    @FXML
    private ToggleGroup Question7;
    @FXML
    private ToggleGroup Question8;
    @FXML
    private ToggleGroup Question9;
    @FXML
    private Label playerName;
    @FXML
    private Button backButton;
    @FXML
    private Label satisfactoryLabel;
    @FXML
    private Label satisfactoryScore;

    private int score = 0 ;
    private boolean hasSetScore = false;
    private String name = "";
    String[] nameList;
    int[] scoreList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    @FXML
    private void minusScore(MouseEvent event) {
      if(!hasSetScore)  score = score -1 ;
    }

    @FXML
    private void addScore(MouseEvent event) {
       if(!hasSetScore)  score = score +1 ;
    }

    @FXML
    private void displayScore(MouseEvent event) {
        if(!hasSetScore){
        satisfactoryLabel.setVisible(true);
        satisfactoryScore.setVisible(true);
        satisfactoryScore.setText(""+score);
        backButton.setVisible(true);
        hasSetScore = true;
        }
    }

    @FXML
    private void goBackToMainMeniu(MouseEvent event) throws IOException {
        Stage stage;
        Parent root1;
        stage = (Stage) backButton.getScene().getWindow();
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("first.fxml"));
            root1 = (Parent) fxmlLoader.load();
            FirstController controller = fxmlLoader.<FirstController>getController();
            controller.setInfo(name ,nameList , scoreList ,score);
            stage.setScene(new Scene(root1, 700, 700));
            stage.show();
    }

   void setInfo(String playersName,String[] names,  int[] scores ) {
        name = playersName;
        nameList = names;
        scoreList = scores;
        playerName.setText(name);
        playerName.setVisible(true);
    }
    
}
