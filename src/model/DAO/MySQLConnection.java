package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    /* A r�utiliser tel quel, juste ces 3 param�tres � changer */
    private static String url = "jdbc:mysql://127.0.0.1/ort_topquiz?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "admin";
    private static String passwd = "admin";

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
