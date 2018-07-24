package com.namlh.bookstore.main.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.namlh.bookstore.utils.Params.ROLE_ADMIN;
import static com.namlh.bookstore.utils.Params.ROLE_CUSTOMER;

/**
 * Created by app on 7/14/18.
 */
@Configuration
public class DbInitializeConfiguration {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void initialize(){
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            // role sql
            statement.execute("DROP TABLE IF EXISTS tbl_role");
            statement.executeUpdate(
                    "CREATE TABLE tbl_role(\n" +
                            "  id INTEGER PRIMARY KEY, \n" +
                            "  role_title VARCHAR(255) NOT NULL, \n" +
                            "  role_code VARCHAR(255) UNIQUE NOT NULL)"
            );

            statement.executeUpdate(
                    "INSERT INTO tbl_role(id, role_title, role_code) \n" +
                            "VALUES (1, 'admin', '"+ ROLE_ADMIN +"')"
            );

            statement.executeUpdate(
                    "INSERT INTO tbl_role(id, role_title, role_code) \n" +
                            "VALUES (2, 'customer', '"+ ROLE_CUSTOMER +"')"
            );

            // user sql
            statement.execute("DROP TABLE IF EXISTS tbl_user");
            statement.executeUpdate(
                    "CREATE TABLE tbl_user(\n" +
                            "  id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                            "  username VARCHAR(255) UNIQUE NOT NULL, \n" +
                            "  password VARCHAR(255) NOT NULL, \n" +
                            "  first_name VARCHAR(100), \n" +
                            "  last_name VARCHAR(100), \n" +
                            "  address VARCHAR(255), \n" +
                            "  role_id INT NOT NULL," +
                            "  email VARCHAR(255), \n" +
                            "  mobile VARCHAR(30), \n" +
                            "  started_date DATETIME," +
                            "  FOREIGN KEY (role_id) REFERENCES tbl_role(id))"
            );
            String adminPassEncrypted = bCryptPasswordEncoder.encode("12345678");
            statement.executeUpdate(
                    "INSERT INTO tbl_user(username, password, email, mobile, role_id) \n" +
                    "VALUES ('admin', '" + adminPassEncrypted +"', 'abc@gmail.com', '124123232', 1)");

            // token logout management
            statement.execute("DROP TABLE IF EXISTS tbl_bltokens");
            statement.executeUpdate(
                    "CREATE TABLE tbl_bltokens(\n" +
                            "  id INTEGER PRIMARY KEY, \n" +
                            "  token TEXT UNIQUE NOT NULL, \n" +
                            "  valid DATETIME NOT NULL)"
            );

            // author sql
//            statement.execute("DROP TABLE IF EXISTS tbl_author");
//            statement.executeUpdate(
//                    "CREATE TABLE tbl_author(\n" +
//                            "  id INTEGER PRIMARY KEY AUTOINCREMENT , \n" +
//                            "  name VARCHAR(255) UNIQUE NOT NULL, \n" +
//                            "  birth_year INTEGER )"
//            );
//            statement.executeUpdate(
//                    "INSERT INTO tbl_author(name, birth_year) \n" +
//                            "VALUES ('Văn Thanh', 1918)");
//            statement.executeUpdate(
//                    "INSERT INTO tbl_author(name, birth_year) \n" +
//                            "VALUES ('Hồng Sơn', 1998)");
//            statement.executeUpdate(
//                    "INSERT INTO tbl_author(name, birth_year) \n" +
//                            "VALUES ('Văn Quyến', 1988)");
//            statement.executeUpdate(
//                    "INSERT INTO tbl_author(name, birth_year) \n" +
//                            "VALUES ('Mario Puzo', 1968)");
//
//            // publisher sql
//            statement.execute("DROP TABLE IF EXISTS tbl_publisher");
//            statement.executeUpdate(
//                    "CREATE TABLE tbl_publisher(\n" +
//                            "  id INTEGER PRIMARY KEY, \n" +
//                            "  name VARCHAR(255) UNIQUE NOT NULL )"
//            );
//            statement.executeUpdate(
//                    "INSERT INTO tbl_publisher(name) \n" +
//                            "VALUES ('NXBT')");
//            statement.executeUpdate(
//                    "INSERT INTO tbl_publisher(name) \n" +
//                            "VALUES ('Tien Phong')");
//            statement.executeUpdate(
//                    "INSERT INTO tbl_publisher(name) \n" +
//                            "VALUES ('Tuoi Tre')");
//
//            // category sql
//            statement.execute("DROP TABLE IF EXISTS tbl_category");
//            statement.executeUpdate(
//                    "CREATE TABLE tbl_category(\n" +
//                            "  id INTEGER PRIMARY KEY, \n" +
//                            "  title VARCHAR(255) UNIQUE NOT NULL )"
//            );
//            statement.executeUpdate(
//                    "INSERT INTO tbl_category(title) \n" +
//                            "VALUES ('Math')");
//            statement.executeUpdate(
//                    "INSERT INTO tbl_category(title) \n" +
//                            "VALUES ('Technology')");
//            statement.executeUpdate(
//                    "INSERT INTO tbl_category(title) \n" +
//                            "VALUES ('History')");
//            statement.executeUpdate(
//                    "INSERT INTO tbl_category(title) \n" +
//                            "VALUES ('Economy')");

            // book sql
            statement.execute("DROP TABLE IF EXISTS tbl_book");
            statement.executeUpdate(
                    "CREATE TABLE tbl_book(\n" +
                            "  id INTEGER PRIMARY KEY, \n" +
                            "  title VARCHAR(255) NOT NULL, \n" +
                            "  price FLOAT default '0.0', \n" +
                            "  quantity INT default '0', \n" +
                            "  image_url VARCHAR(255), \n" +
                            "  author VARCHAR(255), \n" +
                            "  publisher VARCHAR(255), \n" +
                            "  category VARCHAR(255), \n" +
                            "  created DATETIME \n" +
                            ");"
            );

            // order sql
            statement.execute("DROP TABLE IF EXISTS tbl_order");
            statement.executeUpdate(
                    "CREATE TABLE tbl_order(\n" +
                            "  id INTEGER PRIMARY KEY, \n" +
                            "  order_code VARCHAR(255) UNIQUE, \n" +
                            "  customer_id INT NOT NULL, \n" +
                            "  order_date DATETIME,\n" +
                            "  FOREIGN KEY (customer_id) REFERENCES tbl_user(id)" +
                            ")"
            );

            // order detail sql
            statement.execute("DROP TABLE IF EXISTS tbl_order_detail");
            statement.executeUpdate(
                    "CREATE TABLE tbl_order_detail(\n" +
                            "  id INTEGER PRIMARY KEY, \n" +
                            "  order_id INT NOT NULL, \n" +
                            "  product_id INT NOT NULL, \n" +
                            "  quantity INT NOT NULL default '1', " +
                            "  total_price FLOAT DEFAULT '0.0', \n" +
                            "  FOREIGN KEY (order_id) REFERENCES tbl_order(id), \n" +
                            "  FOREIGN KEY (product_id) REFERENCES tbl_book(id)" +
                            ")"
            );

            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
