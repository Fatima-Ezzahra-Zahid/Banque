package ma.youcode.ProjetBanque.DAO;

import ma.youcode.ProjetBanque.Modele.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientsDAO {

  public void AjoutClients(String nom,String prenom, int neroCompt, double solde,String typeClient)throws ClassNotFoundException, SQLException;

  public void ModifierClients(int id, String nom, String prenom, int neroCompt, double solde, String typeClient) throws SQLException;

  public void SupprimeClinets(int id,String typeClient) throws SQLException;


  public List<Client> AfficheClients(String typeCompt);

  public  List<Client>AffichAllClients();

  public  List<Client>AfficheByID(int id);
}
