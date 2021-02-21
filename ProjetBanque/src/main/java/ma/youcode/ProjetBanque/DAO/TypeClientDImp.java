package ma.youcode.ProjetBanque.DAO;

import ma.youcode.ProjetBanque.Modele.TypeClient;
import ma.youcode.ProjetBanque.PostgreConection.ClasseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeClientDImp implements TypeClientDAO{
  Connection conn;

  @Override
  public List<TypeClient> getAllType() throws SQLException {
    try {
      conn = ClasseConnection.getMyConnexion();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    List<TypeClient> listType = new ArrayList<>();
    String query = "SELECT * FROM typecompt";
    PreparedStatement preparedStatement = conn.prepareStatement(query);


    ResultSet rs = preparedStatement.executeQuery();
   TypeClient typeClient;
    while(rs.next()){
     typeClient = new TypeClient(rs.getInt("id"),rs.getString("nom_type"));
      listType.add(typeClient);
    }
    return listType;
  }
}
