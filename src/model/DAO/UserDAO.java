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
            ResultSet rs = stmt.executeQuery("Select * from useriant where id="+id);
            while (rs.next()) {
                int bd_id = rs.getInt("id");
                String bd_nom = rs.getString("Nom");
                String bd_prenom = rs.getString("Prenom");
                String bd_filiere = rs.getString("fil");

                user.setId(bd_id);
                user.setNom(bd_nom);
                user.setPrenom(bd_prenom);
                user.setFiliere(bd_filiere);
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
