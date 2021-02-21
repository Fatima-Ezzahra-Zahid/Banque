package ma.youcode.ProjetBanque.PostgreConection;

import ma.youcode.ProjetBanque.DAO.ClientsDImp;
import ma.youcode.ProjetBanque.Modele.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestConnection {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    ClientsDImp cl = new ClientsDImp();
    //cl.AjoutClients("najma", "fatima",1,2,"Entreprise");


    //cl.ModifierClients(10,"zzzzzz","titim",23444,222,"Entreprise");
    //System.out.println("bien Modifier");




   /*for (int i=0;i<cl.AfficheByID(52,"Personne").size();i++)
    {
      System.out.println(cl.AfficheByID(52,"Personne").get(i).getId());
      System.out.println(cl.AfficheByID(52,"Personne").get(i).getNom());
      System.out.println(cl.AfficheByID(52,"Personne").get(i).getPrenom());
      System.out.println(cl.AfficheByID(52,"Personne").get(i).getNeroCompt());
      System.out.println(cl.AfficheByID(52,"Personne").get(i).getSolde());
      System.out.println(cl.AfficheByID(52,"Personne").get(i).getTypeClient());

    }

    cl.SupprimeClinets(34,"Personne");


  }*/
  }
}



