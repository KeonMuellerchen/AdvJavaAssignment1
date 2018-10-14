package Models;

import java.sql.SQLException;

public class DBTest {

    public static void main(String[] args){
        try {
            System.out.println(DBConnect.getPerson());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//end
}//end of DBTest
