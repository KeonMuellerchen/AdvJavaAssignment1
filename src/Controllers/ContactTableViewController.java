package Controllers;

import Models.Contact;
import Models.DBConnect;
import Views.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ContactTableViewController implements Initializable {

    @FXML private TableView<Contact> contactsTableView;
    @FXML private TableColumn<Contact, Integer> idColumn;
    @FXML private TableColumn<Contact, String> firstNameColumn;
    @FXML private TableColumn<Contact, String> lastNameColumn;
    @FXML private TableColumn<Contact, String> addressColumn;
    @FXML private TableColumn<Contact, String> phoneNumberColumn;
    @FXML private TextField searchTextField;

    /**
     * Initializes the controller class.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //configure the TableColumns to integrate with the Contact class
        idColumn.setCellValueFactory(new PropertyValueFactory<Contact, Integer>("personID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("lastName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("address"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("phoneNumber"));

        try {
            contactsTableView.getItems().addAll(DBConnect.getPerson());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//end of initialize

    /**
     * This method changes the scene to CreateContactView.fxml and gives it a title of "Create Contact"
     * @param event
     * @throws IOException
     */
    public void changeToCreateContactViewScene(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "CreateContactView.fxml", "Create Contact");
    }

}//end
