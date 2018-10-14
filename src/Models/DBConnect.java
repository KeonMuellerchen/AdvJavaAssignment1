package Models;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {

    private static String userName = "root";
    private static String password = "066981408";

    /**
     * This method connects to the database and pull the data from the person table.
     * Throws SQLException if anything is wrong.
     * @return
     * @throws SQLException
     */
    public static ArrayList<Contact> getPerson() throws SQLException {
        ArrayList<Contact> person = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts?useSSL=false",
                    userName, password);

            //2.  Create a statement object
            statement = conn.createStatement();

            //3.  create and execute the query
            resultSet = statement.executeQuery("SELECT * FROM person");

            //4.  loop over the results and add to the ArrayList
            while (resultSet.next())
            {
                Contact newContact = new Contact(
                        resultSet.getInt("personID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getDate("birthday").toLocalDate(),
                        resultSet.getString("image"));

                person.add(newContact);
            }
        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
        finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }

        return person;
    }//end of getPerson()

    /**
     * This method connects the the database and inserts a new Contact object into the person table.
     * Throws SQLException if anything is wrong.
     * @param newContact
     * @throws SQLException
     */
    public static void insertContactIntoDB(Contact newContact) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            //1. connect to DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts?useSSL=false",  userName, password);

            //2. create a sql statement
            String sql = "INSERT INTO person (firstName, lastName, address, phoneNumber, birthday, image) VALUES (?, ?, ?, ?, ?, ?);";

            //3. Create a prepared statement
            ps = conn.prepareStatement(sql);

            //4. bind the paramters
            ps.setString(1, newContact.getFirstName());
            ps.setString(2, newContact.getLastName());
            ps.setString(3, newContact.getAddress());
            ps.setString(4, newContact.getPhoneNumber());
            ps.setObject(5, newContact.getBirthday());          ///////need to figure out
            ps.setString(6, newContact.getImage());

            //5. execute the update
            ps.executeUpdate();

        }
        catch (SQLException e)
        {
            System.err.println("Error" + e);
        }
        finally {
            if (conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }//end of insertContactIntoDB


}//end of DBConnect
