package ma.youcode.ProjetBanque.DAO;

import ma.youcode.ProjetBanque.Modele.Client;
import ma.youcode.ProjetBanque.Modele.TypeClient;
import ma.youcode.ProjetBanque.PostgreConection.ClasseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDImp  implements ClientsDAO {

  Connection conn;

  @Override
  public void AjoutClients(String nom, String prenom, int neroCompt, double solde, String typeClient) throws ClassNotFoundException, SQLException {

    Client client = new Client();

    try {
      conn = ClasseConnection.getMyConnexion();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    TypeClient typeClient1 = new TypeClient();
    typeClient1.setNom(typeClient);

    TypeClientDImp typeClientDImp = new TypeClientDImp();
    for (int i = 0; i < typeClientDImp.getAllType().size(); i++) {

      if (typeClientDImp.getAllType().get(i).getNom().equals(typeClient)) {
        typeClient1.setId(typeClientDImp.getAllType().get(i).getId());
        System.out.println(typeClient1.getId());
      }

    }

    String req = "INSERT INTO compteBanque(nom,NumeroCompt,solde,id_type) VALUES (?,?,?,?)";
    PreparedStatement statement = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, nom);
    statement.setInt(2, neroCompt);
    statement.setDouble(3, solde);
    statement.setInt(4, typeClient1.getId());
    statement.executeUpdate();

    ResultSet rs = statement.getGeneratedKeys();

    if (typeClient.equals("Personne")  && rs.next()) {

      client.setId(rs.getInt(1));
      String qr = "INSERT INTO personne (prenom,id_compt) VALUES (?,?)";
      PreparedStatement preparedStatement1 = conn.prepareStatement(qr);
      preparedStatement1.setString(1, prenom);
      preparedStatement1.setInt(2, client.getId());
      preparedStatement1.executeUpdate();
      System.out.println("Inser personne");
    }
  }

  @Override
  public void ModifierClients(int id, String nom, String prenom, int neroCompt, double solde, String typeClient) throws SQLException {

    Client client = new Client();

    try {
      conn = ClasseConnection.getMyConnexion();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    TypeClient typeClient1 = new TypeClient();
    typeClient1.setNom(typeClient);

    TypeClientDImp typeClientDImp = new TypeClientDImp();
    for (int i = 0; i < typeClientDImp.getAllType().size(); i++) {

      if (typeClientDImp.getAllType().get(i).getNom().equals(typeClient)) {
        typeClient1.setId(typeClientDImp.getAllType().get(i).getId());
        System.out.println(typeClient1.getId());
      }

    }

    String req = "UPDATE  compteBanque SET nom=?,NumeroCompt=?,solde=?,id_type=? WHERE id_banq=?";
    PreparedStatement statement = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, nom);
    statement.setInt(2, neroCompt);
    statement.setDouble(3, solde);
    statement.setInt(4, typeClient1.getId());
    statement.setInt(5, id);
    statement.executeUpdate();


    if (typeClient=="Personne") {

      String qr = "UPDATE personne SET prenom=? WHERE id_compt=?";
      PreparedStatement preparedStatement1 = conn.prepareStatement(qr);
      preparedStatement1.setString(1, prenom);
      preparedStatement1.setInt(2, id);

      preparedStatement1.executeUpdate();
      System.out.println("modifier  personne");
    }

  }

  @Override
  public void SupprimeClinets(int id, String typeClient) throws SQLException {


    try {
      conn = ClasseConnection.getMyConnexion();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    if (typeClient=="Personne") {
      String qr = "DELETE FROM personne  WHERE id_compt=?";
      PreparedStatement preparedStatement1 = conn.prepareStatement(qr);
      preparedStatement1.setInt(1, id);
      preparedStatement1.executeUpdate();
      System.out.println("delete persone");


      String query = "DELETE FROM compteBanque  WHERE id_banq=?";
      PreparedStatement preparedStatement = conn.prepareStatement(query);
      preparedStatement.setInt(1, id);

      preparedStatement.executeUpdate();
      System.out.println("delete compte");
    }
    else
    {
      String query = "DELETE FROM compteBanque  WHERE id_banq=?";
      PreparedStatement preparedStatement = conn.prepareStatement(query);
      preparedStatement.setInt(1, id);

      preparedStatement.executeUpdate();
      System.out.println("delete compte");
    }
  }

  @Override
  public List<Client> AfficheClients(String typeCompt) {

    List<Client> listClient = new ArrayList<>();
    try {
      conn = ClasseConnection.getMyConnexion();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    if (typeCompt.equals("Personne")) {
      String qr = "select id_banq,nom,prenom,numerocompt,solde,nom_type from comptebanque,personne,typecompt where comptebanque.id_type=typecompt.id and comptebanque.id_banq=personne.id_compt and nom_type=?";

      try {
        PreparedStatement preparedStatement2 = conn.prepareStatement(qr);
        preparedStatement2.setString(1, typeCompt);
        ResultSet rs = preparedStatement2.executeQuery();
        Client client;
        while (rs.next()) {
          client = new Client(rs.getInt("id_banq"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("numerocompt"), rs.getDouble("solde"), rs.getString("nom_type"));
          listClient.add(client);
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }


    } else if (typeCompt.equals("Entreprise")) {
      String qr1 = "select id_banq,nom,numerocompt,solde,nom_type from comptebanque,typecompt where comptebanque.id_type=typecompt.id  and nom_type=?";

      try {
        PreparedStatement preparedStatement3 = conn.prepareStatement(qr1);
        preparedStatement3.setString(1, typeCompt);
        ResultSet rs1 = preparedStatement3.executeQuery();
        Client client;
        while (rs1.next()) {
          client = new Client(rs1.getInt("id_banq"), rs1.getString("nom"), rs1.getInt("numerocompt"), rs1.getDouble("solde"), rs1.getString("nom_type"));
          listClient.add(client);
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }

    return listClient;
  }

  @Override
  public List<Client> AffichAllClients() {
    List<Client> listClient = new ArrayList<>();
    try {
      conn = ClasseConnection.getMyConnexion();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }


    String qr = "select id_banq,nom,prenom,numerocompt,solde,nom_type from comptebanque,personne,typecompt where comptebanque.id_type=typecompt.id and comptebanque.id_banq=personne.id_compt";

    try {
      PreparedStatement preparedStatement2 = conn.prepareStatement(qr);
      ResultSet rs = preparedStatement2.executeQuery();
      Client client;
      while (rs.next()) {
        client = new Client(rs.getInt("id_banq"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("numerocompt"), rs.getDouble("solde"), rs.getString("nom_type"));
        listClient.add(client);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return listClient;
  }

  @Override
  public List<Client> AfficheByID(int id) {
    List<Client> listClient = new ArrayList<>();
    try {
      conn = ClasseConnection.getMyConnexion();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }


    String qr = "select id_banq,nom,prenom,numerocompt,solde,nom_type from comptebanque,personne,typecompt where comptebanque.id_type=typecompt.id and comptebanque.id_banq=personne.id_compt  and id_banq=?  ";

    try {
      PreparedStatement preparedStatement2 = conn.prepareStatement(qr);
      preparedStatement2.setInt(1, id);
      ResultSet rs = preparedStatement2.executeQuery();
      Client client;
      while (rs.next()) {
        client = new Client(rs.getInt("id_banq"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("numerocompt"), rs.getDouble("solde"), rs.getString("nom_type"));
        listClient.add(client);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


    return listClient;
  }

}




