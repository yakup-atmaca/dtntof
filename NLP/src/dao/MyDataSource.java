/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 *
 * @author Yakup
 */
public class MyDataSource {
    public  MysqlDataSource getMySQLDataSource() throws
            FileNotFoundException, IOException {

        Properties props = new Properties();
        FileInputStream fis = null;
        MysqlDataSource ds = null;

        fis = new FileInputStream("src\\resources\\db.properties");
        props.load(fis);

        ds = new MysqlConnectionPoolDataSource();
        ds.setURL(props.getProperty("mysql.url"));
        ds.setUser(props.getProperty("mysql.username"));
        ds.setPassword(props.getProperty("mysql.password"));

        return ds;
    }

}
