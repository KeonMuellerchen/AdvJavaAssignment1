package Controllers;

import Models.Contact;
import Models.DBConnect;
import Views.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateContactViewController implements Initializable {

    @FXML private TextField contactIDTextField;
    @FXML private TextField imageTextField;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField phoneTextField;
    @FXML private DatePicker birthdayDatePicker;
    @FXML private ImageView pictureImageView;
    @FXML private Button chooseImageButton;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;

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
    public void saveContactButtonPushed(ActionEvent event) throws IOException {

        Contact newContact = new Contact(
                contactIDTextField.getPrefColumnCount(),
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                addressTextField.getText(),
                phoneTextField.getText(),
                birthdayDatePicker.getValue(),
                imageTextField.getText());
                //pictureImageView.getImage());

        System.out.printf("New contact: %s%n", newContact);
        try {
            DBConnect.insertContactIntoDB(newContact);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SceneChanger.changeScenes(event, "ContactTableView.fxml", "Contacts Table");

    }//end of createPhoneButtonPushed()
}//end
