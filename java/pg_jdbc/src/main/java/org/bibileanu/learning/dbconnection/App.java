package org.bibileanu.learning.dbconnection;

import java.sql.*;
import org.postgresql.Driver;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * To create an user that would be allowed to connect to PG:
 * CREATE ROLE camza WITH LOGIN PASSWORD 'Test123'
 * GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO camza;
 * GRANT USAGE, SELECT ON SEQUENCE test_table_id_seq TO camza;
 *
 * test_table looks like this:
 * CREATE TABLE public.test_table
 * (
 *   id integer NOT NULL DEFAULT nextval('test_table_id_seq'::regclass),
 *   name character varying(50),
 *   value character varying(128),
 *   CONSTRAINT test_table_pkey PRIMARY KEY (id)
 * )
 */
public class App 
{

    public static Connection ConnectExample() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_test_db", "camza", "Test123");
            return conn;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ResultSet SelectExample(Connection conn) {
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM test_table");
            ResultSet res = prep.executeQuery();
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void InsertExample(Connection conn) {
        try {
            PreparedStatement prep = conn.prepareStatement("INSERT INTO test_table(name, value) VALUES('bibi', 666)");
            prep.execute();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ShowResultsExample(ResultSet res) {
        try {
            while (res.next()) {
                // Get the first column as int
                System.out.print(res.getInt(1) + " ");

                // Get the second column as string
                System.out.print(res.getString(2) + " ");

                // Get the third column as string
                System.out.print(res.getString(3) + " ");

                System.out.println();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main( String[] args ) {
        System.out.println("Connecting to db" );
        Connection con = ConnectExample();

        System.out.println("Inserting a value into the table");
        InsertExample(con);

        System.out.println("Selecting values from table");
        ResultSet res = SelectExample(con);

        System.out.println("Display values from table");
        ShowResultsExample(res);
    }
}
