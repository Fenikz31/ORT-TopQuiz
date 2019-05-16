package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    /* A réutiliser tel quel, juste ces 3 paramètres à changer */
    private static String url = "jdbc:mysql://localhost/ort_topquiz?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "admin";
    private static String passwd = "admin";

    /** * Objet Connection */
    private static Connection connect;

    /**
     * M�thode qui va nous retourner notre instance * et la créer si elle 	n'existe pas... * @return
     */
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
