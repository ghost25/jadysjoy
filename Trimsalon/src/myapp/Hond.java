package myapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class Hond
{
    private static String dbURL = "jdbc:derby://localhost:1527/trimsalon;create=true;user=admin;password=admin";
    private static String tableName = "hond";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void main(String[] args)
    {
        createConnection();
        insertHond(2, "Chiuaua", "Moetje", "Teeffelen", 5, 15);
        selectHond();
        shutdown();
    }
    
    private static void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
    private static void insertHond(int id, String soort, String naam, String woonplaats, int leeftijd, int gewicht)
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("insert into " + tableName + " values (" +
                    id + ",'" + soort + "','" + naam + "','" + woonplaats + "'," + leeftijd + "," + gewicht + ")");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    private static void selectHond()
    {
        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n------------------------------------------------------------------------------------------------------------------");

            while(results.next())
            {
                int id = results.getInt(1);
                String naam = results.getString(2);
                String soort = results.getString(3);
                String woonplaats = results.getString(4);
                int gewicht = results.getInt(5);
                int leeftijd = results.getInt(6);
                System.out.println(id + "\t\t" + soort + "\t\t" + naam + "\t\t" + woonplaats + "\t\t" + leeftijd + "\t\t" + gewicht);
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    private static void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    }
}

