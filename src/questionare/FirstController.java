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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nedas
 */
public class FirstController implements Initializable {

    @FXML
    private Button startButton;
    @FXML
    private TextField NameButton;
    @FXML
    private Label perticipant1;
    @FXML
    private Label perticipant2;
    @FXML
    private Label perticipant3;
    @FXML
    private Label perticipant4;
    @FXML
    private Label perticipant5;
    @FXML
    private Label perticipant6;
    @FXML
    private Label perticipant7;
    @FXML
    private Label perticipant8;
    @FXML
    private Label score1;
    @FXML
    private Label score2;
    @FXML
    private Label score3;
    @FXML
    private Label score4;
    @FXML
    private Label score5;
    @FXML
    private Label score6;
    @FXML
    private Label score7;
    @FXML
    private Label score8;
    @FXML
    private Label errrorMsg;
    String[] nameList = new String[8] ;
    int[] scoreList = new int[8];
        private String name = "";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    @FXML
    private void startGame(MouseEvent event) throws IOException {
        if(NameButton.getText() == null || NameButton.getText().trim().isEmpty()){
            errrorMsg.setText("Please enter your name before starting");
            errrorMsg.setVisible(true);
        }else{
        Stage stage;
        Parent root1;
        stage = (Stage) startButton.getScene().getWindow();
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("second.fxml"));
            root1 = (Parent) fxmlLoader.load(); 
            SecondController controller = fxmlLoader.<SecondController>getController();
            controller.setInfo(NameButton.getText(),nameList ,scoreList);
            stage.setScene(new Scene(root1, 700, 700));
            stage.show();
        }
    }
    
    void setInfo (String playerName ,String[] names ,int[] scores , int score){
        name = playerName;
        boolean isFound = false;
        nameList = names ;
        scoreList = scores;
        //check if existing name exists
        if(names.length != 0){
            for(int i=0 ; i<names.length ; i++ ){
            if(name.equals(names[i])){
                scoreList[i] = scores[i] + score;
                isFound = true;
            }
        }
        }

        //if not found , enter new entry
        boolean notInserted = false;
        if(!isFound){
        for(int i=0 ; i<names.length ; i++ ){
            if(names[i]==null && notInserted == false){
                nameList[i]=name;
                scoreList[i]=score;
                notInserted= true;
            }
        }
        }
        //display info
        for (int z = 0 ; z<names.length ; z++){
            if(z==0 && names[z]!=null){
                perticipant1.setText(names[z]);
                score1.setText(""+scores[z]);
                perticipant1.setVisible(true);
                score1.setVisible(true);
            }else if(z==1 && names[z]!=null){
                perticipant2.setText(names[z]);
                score2.setText(""+scores[z]);
                perticipant2.setVisible(true);
                score2.setVisible(true);  
            }else if (z==2 && names[z]!=null){
                perticipant3.setText(names[z]);
                score3.setText(""+scores[z]);
                perticipant3.setVisible(true);
                score3.setVisible(true);
            }else if (z==3 && names[z]!=null){
                perticipant4.setText(names[z]);
                score4.setText(""+scores[z]);
                perticipant4.setVisible(true);
                score4.setVisible(true);
            }else if (z==4 && names[z]!=null){
                perticipant5.setText(names[z]);
                score5.setText(""+scores[z]);
                perticipant5.setVisible(true);
                score5.setVisible(true);
            }else if (z==5 && names[z]!=null){
                perticipant6.setText(names[z]);
                score6.setText(""+scores[z]);
                perticipant6.setVisible(true);
                score6.setVisible(true);
            }else if (z==6 && names[z]!=null){
                perticipant7.setText(names[z]);
                score7.setText(""+scores[z]);
                perticipant7.setVisible(true);
                score7.setVisible(true);
            }else if (z==7 && names[z]!=null){
                perticipant8.setText(names[z]);
                score8.setText(""+scores[z]);
                perticipant8.setVisible(true);
                score8.setVisible(true);
            }
        }
    }
    
}
