package model.DAO;

import model.User;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO extends DAO<User>{


    /**
     * Permet de récupérer un objet via son ID * @param id * @return
     *
     * @param id
     */
    @Override
    public User find(long id) {
        User user = new User();

        try {
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from userdao where id=" + id);
            while (rs.next()) {
                int bd_id = rs.getInt("iduser");
                String bd_firstName = rs.getString("Prénom");
                String bd_score = rs.getString("score");
                String bd_date = rs.getString("date");

                user.setId(bd_id);
                user.setmFirstName(bd_firstName);
                user.setEXTRA_SCORE(bd_score);
                user.setmDate(bd_date);
            }
            return user;
        }
        catch (Exception e) {
            System.out.println("UserDAO: find() failed: "+e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * Permet de créer une entrée dans la base de données * par rapport à un objet
     *
     * @param obj
     */
    @Override
    public User create(User obj) {
        return null;
    }

    /**
     * Permet de créer une entrée dans la base de données * par rapport à un objet
     *
     * @param name
     */
    @Override
    public User create(String name) {
        User user = new User();

        try {
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("insert into userdao (prenom)values(?);");
            while (rs.next()) {
                String bd_firstName = rs.getString("Prénom");
                user.setmFirstName(bd_firstName);
            }
            return user;
        } catch (Exception e) {
            System.out.println("UserDAO: create() failed: " + e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * Permet de mettre à jour les données d'une entrée dans la base
     *
     * @param obj
     */
    @Override
    public User update(User obj) {
        return null;
    }

    /**
     * Permet la suppression d'une entr�e de la base * @param obj
     *
     * @param obj
     */
    @Override
    public void delete(User obj) {

    }
}
