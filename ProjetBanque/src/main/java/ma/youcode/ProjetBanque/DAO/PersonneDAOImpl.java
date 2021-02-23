package ma.youcode.ProjetBanque.DAO;

import ma.youcode.ProjetBanque.PostgreConection.ClasseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonneDAOImpl implements PersonneDAO{
  Connection conn;
  public void UpdatePersonne(int id, String prenom) throws SQLException {
      try {
        conn = ClasseConnection.getMyConnexion();
      } catch (Exception throwables) {
        throwables.printStackTrace();
      }
    String req = "update personne set prenom=? where  id_compt=?";
    PreparedStatement statement = conn.prepareStatement(req);
    statement.setString(1, prenom);
    statement.setInt(2, id);

    statement.executeUpdate();
    System.out.println("personne update");

  }
}
