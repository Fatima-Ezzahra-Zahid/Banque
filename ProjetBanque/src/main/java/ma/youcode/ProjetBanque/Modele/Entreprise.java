package ma.youcode.ProjetBanque.Modele;


public class Entreprise  extends CompteBanck {



  public Entreprise() {
  }

  public Entreprise(String nom, int neroCompt, double solde, String typeClient) {
    super(nom, neroCompt, solde, typeClient);
  }

  public Entreprise(int id, String nom, int neroCompt, double solde, String typeClient) {
    super(id, nom, neroCompt, solde, typeClient);
  }


}
