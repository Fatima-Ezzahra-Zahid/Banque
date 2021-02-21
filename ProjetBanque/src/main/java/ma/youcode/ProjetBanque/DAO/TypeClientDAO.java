package ma.youcode.ProjetBanque.DAO;

import ma.youcode.ProjetBanque.Modele.TypeClient;

import java.sql.SQLException;
import java.util.List;

public interface TypeClientDAO {

  public List<TypeClient> getAllType() throws SQLException;
}
