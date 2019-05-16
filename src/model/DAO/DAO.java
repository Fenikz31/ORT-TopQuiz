package model.DAO;

import java.sql.Connection;

import static model.DAO.MySQLConnection.getInstance;

public abstract class DAO <T>{

    Connection connect = getInstance();

    //Puis les méthodes "standard" pour le CRUD sur une entitée

    /**
     * Permet de récupérer un objet via son ID * @param id * @return
     */
    public abstract T find(long id);

    /**
     * Permet de créer une entrée dans la base de données ort_quiz par rapport à un objet
     */
    public abstract T create(T obj);

    /**
     * Permet de créer une entrée dans la base de données ort_quiz par rapport à un objet
     */
    public abstract T create_user(String pseudo);

    /**
     * Permet de créer une entrée dans la base de données ort_quiz par rapport à un objet
     */
    public abstract T create_gameScore(String prenom, String score);


    /** * Permet de mettre à jour les donn�es d'une entrée dans la base  */
    public abstract T update(T obj);

    /** * Permet la suppression d'une entrée de la base * @param obj */
    public abstract void delete(T obj);
}
