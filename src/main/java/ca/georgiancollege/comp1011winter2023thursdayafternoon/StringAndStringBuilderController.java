package ca.georgiancollege.comp1011winter2023thursdayafternoon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Locale;

public class StringAndStringBuilderController {

    @FXML
    private TextField argumentString;

    @FXML
    private TextField resultString;

    @FXML
    private TextField contentString;

    @FXML
    private ComboBox<String> methodString;

    @FXML
    private TextField argumentSB;

    @FXML
    private TextField resultSB;

    @FXML
    private TextField contentSB;

    @FXML
    private ComboBox<?> methodSB;

    @FXML
    void onSubmitSB(ActionEvent event) {

    }

    @FXML
    void onSubmitString(ActionEvent event) {

        StringBuilder sb = new StringBuilder();
        //get the values for content, method, arguments
        sb.append(contentString.getText());
        sb.append("-");
        sb.append(argumentString.getText());
        sb.append("-");
        sb.append(methodString.getSelectionModel().getSelectedItem());

        // add all those values to the result textfield
        //resultString.setText(sb.toString());

        String[] info = sb.toString().split("-");
        String content = info[0];
        String args = info[1];
        String method = info[2];
        /*
            Enhanced Switch statement

           returned Object =  switch(expression)

         */
        Object result = switch (method.toLowerCase()){
            case "length" : {yield content.length();}
            case "substring": yield content.substring(Integer.parseInt(args));
            default : yield "Unknown";
        };

        resultString.setText(result.toString());

    }

    @FXML
    void initialize(){
        //document on load method
        methodString.getItems().add("length");
        methodString.getItems().add("contains");
        methodString.getItems().add("startsWith");
        methodString.getItems().add("substring");
        methodString.getSelectionModel().selectFirst();
        /*
                ComboBox
                    Items
                        length
                        contains

            * Act of selecting is accomplished by Model
                SelectionModel
         */


    }


}
