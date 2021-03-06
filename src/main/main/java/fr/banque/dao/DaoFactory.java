package fr.banque.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * La DAO Factory (DaoFactory.java) permet d'initialiser le DAO en chargeant 
 * notamment les drivers n?cessaires(ici un driver JDBC MySQL) et se connecte ? 
 * la base de donn?es. La Factory peut
 *  fournir plusieurs DAO (ici, il n'y en a qu'un seul, UtilisateurDao,
 *    qui correspond ? une table de la base).
 * 
 */
public class DaoFactory {
	private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    	//ICI ON MODIFIE L ID D'ACCES A LA BDD
        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/banque", "root", "root");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // R?cup?ration du Dao utilisateur
    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl(this);
    }
    // R?cuperation du Dao Compte
    public CompteDao getCompteDao()
    {
    	return new CompteDaoImpl(this);
    }

}
