package tests;

import org.junit.Assert;
import org.junit.Test;
import utulities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class C01 {

    //ogrenciler tablosunda Merve Gul isimli ogrencinin oldugunu test edın

    @Test
    public void test01() throws SQLException {

        String hostname="localhost";
        String dbisim="Databasetesting";
        String username="postgres";
        String password="Mk.2243250";

        // 1.Adim : Connection olusturma
        DBUtils.connectionOlustur(hostname,dbisim,username,password);

        // 2.Adim : Statement olusturma
        Statement st = DBUtils.statementOlustur();

        // 3.Adim : Query olusturma
        String query = "select isim from ogrenciler;";

        // 4.Adim : Query calistir.
        ResultSet rs = st.executeQuery(query);
        List<String> isimler = new ArrayList<>();

        while(rs.next()){
           isimler.add(rs.getString(1));
        }

        // sorgu yaparken Assert kullanmamiz gerekiyor.
        Assert.assertTrue(isimler.contains("Merve Gul"));

        // kapatma
        DBUtils.connectionVeStatementKapatma();



    }








}
