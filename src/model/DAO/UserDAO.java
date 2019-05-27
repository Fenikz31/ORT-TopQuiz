package model.DAO;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
        } catch (Exception e) {
            System.out.println("UserDAO: find() failed: " + e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * Permet de récupérer un objet via son prenom * @param pseudo * @return
     *
     * @param pseudo
     */
    @Override
    public User find(String pseudo) {
        User user = new User();

        try {
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from userdao where prenom=" + pseudo);
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
        } catch (Exception e) {
            System.out.println("UserDAO: find() failed: "+e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * Permet de créer une entrée dans la base de données ort_quiz par rapport à un objet
     *
     * @param obj
     */
    @Override
    public User create(User obj) {
        return null;
    }

    /**
     * Permet de créer une entrée dans la base de données ort_quiz par rapport à un objet
     */
    @Override
    public User create_user() {
        User user = new User();
        try {
            Statement stmt = connect.createStatement();

            PreparedStatement prepStmt;
            String insertTableUserdao = "INSERT INTO userdao"
                    + "(prenom) VALUES"
                    + "(?)";
            Scanner inputPseudo = new Scanner(System.in);
            System.out.println("enter your name: ");
            user.setmFirstName(String.valueOf(inputPseudo));
            String bd_firstName = user.getmFirstName();

            prepStmt = connect.prepareStatement(insertTableUserdao);

            prepStmt.setString(1, bd_firstName);

            prepStmt.executeUpdate();

            // Récupérer l'utilisateur créé, avec son id auto-incrémenté
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM userdao");
            resultSet.next();

            int bd_iduser = resultSet.getInt("iduser");
            bd_firstName = resultSet.getString("prenom");

            prepStmt.close();

            return user;

        } catch (SQLException e) {
            System.out.println("Insert into table 'user' failed! " + e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * @param pseudo User's pseudonyme
     * @return
     */
    @Override
    public User create_user(String pseudo) {
        User user = new User();
        try {
            Statement stmt = connect.createStatement();

            PreparedStatement prepStmt;
            String insertTableUserdao = "INSERT INTO userdao"
                    + "(prenom) VALUES"
                    + "(?)";

            user.setmFirstName(pseudo);
            String bd_firstName = user.getmFirstName();

            prepStmt = connect.prepareStatement(insertTableUserdao);

            prepStmt.setString(1, bd_firstName);

            prepStmt.executeUpdate();

            // Récupérer l'utilisateur créé, avec son id auto-incrémenté
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM userdao");
            resultSet.next();

            int bd_iduser = resultSet.getInt("iduser");
            bd_firstName = resultSet.getString("prenom");

            prepStmt.close();

            return user;

        } catch (SQLException e) {
            System.out.println("Insert into table 'user' failed! " + e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * Permet de créer une entrée dans la base de données * par rapport à un objet
     *
     * @param pseudo
     * @param pseudoScore
     */
    @Override
    public User create_gameScore(String pseudo, String pseudoScore) {
        User user = new User();

        try {
            Statement stmt = connect.createStatement();

            PreparedStatement prepStmt;
            String insertTableGame = "INSERt INTO game"
                    + "(prenom, score) VALUES"
                    + "(?,?)";

            user.setmFirstName(pseudo);
            user.setEXTRA_SCORE(pseudoScore);
            String bd_firstName = user.getmFirstName();
            String bd_score = user.getEXTRA_SCORE();

            prepStmt = connect.prepareStatement(insertTableGame);

            prepStmt.setString(1, bd_firstName);
            prepStmt.setString(2, bd_score);

            prepStmt.executeUpdate();

            // Récupérer l'utilisateur, le score et la date de la partie créée, avec son id auto-incrémenté
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM game");
            resultSet.next();

            int bd_idgame = resultSet.getInt("idgame");
            bd_firstName = resultSet.getString("prenom");
            bd_score = resultSet.getString("score");
            String bd_date = resultSet.getString("datetime");

            prepStmt.close();

            return user;

        } catch (SQLException e) {
            System.out.println("Insert into table'game' failed! " + e.getLocalizedMessage());
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
        User user = new User();

        try {
            Statement stmt = connect.createStatement();

            // Récupérer l'utilisateur, le score et la date de la partie créée, avec son id auto-incrémenté
            ResultSet resultSet = stmt.executeQuery("SELECT prenom, score, datetime FROM game ORDER BY score LIMIT 10");
            resultSet.next();

            int bd_idgame = resultSet.getInt("idgame");
            String bd_firstName = resultSet.getString("prenom");
            String bd_score = resultSet.getString("score");
            String bd_datetime = resultSet.getString("datetime");

            return user;

        } catch (SQLException e) {
            System.out.println("Insert into table'game' failed! " + e.getLocalizedMessage());
        }
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

    /*public Auteur create(Auteur obj) {
        try {
            Statement stmt = connect.createStatement();

            //Ici on insere le nouvel auteur
            stmt.execute("INSERT INTO auteur VALUES ('"+obj.getNom()+"','"+obj.getPrenom()+"','"+obj.getPays()+"','"+obj.getDateNaissance()+"','"+obj.getDateDeces()+"')");


            // pour récupérer l'objet que l'on vient d'insérer, cette fois avec l'ID auto-généré
            ResultSet rs = stmt.executeQuery("Select * from auteur");

            //Je me place sur la dernière ligne
            rs.last();

            //Puis je fais comme avant (comme pour find() et findByName() )
            Auteur aut = new Auteur();
            int bd_id = rs.getInt("id");
            String bd_nom = rs.getString("nom");
            String bd_prenom = rs.getString("prenom");
            String bd_pays = rs.getString("pays");
            Date bd_dateNaissance = rs.getDate("dateNaissance");
            Date bd_dateDeces = rs.getDate("dateDeces");

            aut.setId(bd_id);
            aut.setNom(bd_nom);
            aut.setPrenom(bd_prenom);
            aut.setPays(bd_pays);
            aut.setDateNaissance(bd_dateNaissance);
            aut.setDateDeces(bd_dateDeces);
            return aut;

        }
        catch (Exception e) {
            System.out.println("AuteurDAO: create() failed: "+e.getLocalizedMessage());
        }


        return null;
    }*/
}
