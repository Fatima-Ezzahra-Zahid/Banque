package ma.youcode.ProjetBanque.Modele;

public class Personne extends CompteBanck{
  String prenom;

  public Personne(String prenom) {
    this.prenom = prenom;
  }

  public Personne(String nom, int neroCompt, double solde, String typeClient, String prenom) {
    super(nom, neroCompt, solde, typeClient);
    this.prenom = prenom;
  }

  public Personne(int id, String nom, String prenom, int neroCompt, double solde, String typeClient) {
    super(id, nom, neroCompt, solde, typeClient);
    this.prenom = prenom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }
}
