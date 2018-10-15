package Controllers;

import Models.Contact;
import Models.DBConnect;
import Views.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateContactViewController implements Initializable {

    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField phoneTextField;
    @FXML private DatePicker birthdayDatePicker;
    @FXML
    private Label errMsgLabel;

    /**
     * Initializes the controller class.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * When the cancel button is pushed, it will take the user back to the ContactTableView.fxml GUI.
     * @param event
     * @throws IOException
     */
    @FXML
    public void cancelButtonPushed (ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "ContactTableView.fxml", "Contacts Table");
    }//end

    /**
     * This method will save a new Contact Object. If there is no invalid inputs, it will take the user back to the
     * ContactTableView.fxml GUI, where there will be an updated TableView with the new Contact in it.
     * @param event
     * @throws IOException
     */
    @FXML
    public void saveContactButtonPushed(ActionEvent event) {
        try {
            Contact newContact = new Contact(
                    0,
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    addressTextField.getText(),
                    phoneTextField.getText(),
                    birthdayDatePicker.getValue(),
                    "ProfilePicture.jpg");

            errMsgLabel.setText(""); //does not show errors if creating Volunteer was successful

            DBConnect.insertContactIntoDB(newContact);

            System.out.printf("New contact added: %s%n", newContact.toString());

            SceneChanger.changeScenes(event, "ContactTableView.fxml", "Contacts Table");

        } catch (Exception e) {
            errMsgLabel.setText(e.getMessage());
        }
    }//end of createPhoneButtonPushed()
}//end
