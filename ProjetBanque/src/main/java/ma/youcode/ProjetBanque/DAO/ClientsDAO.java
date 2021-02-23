package ma.youcode.ProjetBanque.DAO;

import ma.youcode.ProjetBanque.Modele.CompteBanck;
import ma.youcode.ProjetBanque.Modele.Personne;

import java.sql.SQLException;
import java.util.List;

public interface ClientsDAO {

  public void AjoutClients(String nom,String prenom, int neroCompt, double solde,String typeClient)throws ClassNotFoundException, SQLException;

  public void ModifierClients(int id, String nom,  int neroCompt, double solde, String typeClient) throws SQLException;

  public void SupprimeClinets(int id,String typeClient) throws SQLException;


  public List<CompteBanck> AfficheClients(String typeCompt);

  public  List<CompteBanck>AffichAllClients();

  public CompteBanck AfficheByID(int id);
}
