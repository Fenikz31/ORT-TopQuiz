package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    /* A r�utiliser tel quel, juste ces 3 param�tres � changer */
    private static String url = "jdbc:mysql://localhost/testjdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String passwd = "";

    /** * Objet Connection */
    private static Connection connect;

    /** * M�thode qui va nous retourner notre instance * et la cr�er si elle 	n'existe pas... * @return */
    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
