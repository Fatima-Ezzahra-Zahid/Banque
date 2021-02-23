package ma.youcode.ProjetBanque.DAO;

import java.sql.SQLException;

public interface PersonneDAO {

  public void UpdatePersonne(int id, String prenom) throws ClassNotFoundException, SQLException;
}
