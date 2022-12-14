package tests;

import org.junit.Assert;
import org.junit.Test;
import utulities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C02 {

    // Ogrenciler tablosundan Yazili not ortalamasının 90dan kucuk oldugunu test edın

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
        String query = "select avg(yazili_notu) from ogrenciler;";

        // 4.Adim : Query calistir.
        ResultSet rs = st.executeQuery(query);
        rs.next();
        double ort = rs.getDouble(1);
        System.out.println(ort);

        // sorgu yapma
        Assert.assertTrue(ort<90);

        // kapatma
        DBUtils.connectionVeStatementKapatma();

    }






















}
