package utulities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    // connection
    // statement
    // con ve statement kapatma

    private static Connection conection;
    private static Statement statement;

    // 1.Adim : Connection olustur
    public static Connection connectionOlustur(String hostname,String databaseismi,String username,String password){

        // 1.Adim Driver'a kaydol
        try {
            Class.forName("org.postgresql.Driver");  // bu kisim sabit bir sey bu hep yazilir.
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 2.Adim connection olustur
        //url syntax:jdbc:postgresql://hostname:portnumber/databaseismi
        String url = "jdbc:postgresql://"+hostname+":5432/"+databaseismi;
        try {
            conection= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conection;
    }


    // 3.Adim statement olusturma
    public static Statement statementOlustur(){

        try {
            statement=conection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;
    }


    // 4.Adim connection ve statement kapatma
    public static void connectionVeStatementKapatma(){
        try {
            conection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }











}
