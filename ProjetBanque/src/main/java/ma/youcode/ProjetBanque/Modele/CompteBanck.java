package ma.youcode.ProjetBanque.Modele;

public class CompteBanck {

  private int id;
  private String nom;
  private int NeroCompt;
  private double solde;
  private String typeClient;


  public CompteBanck()
  {

  }


  public CompteBanck(String nom, int neroCompt, double solde, String typeClient) {
    this.nom = nom;
    NeroCompt = neroCompt;
    this.solde = solde;
    this.typeClient = typeClient;
  }
  public CompteBanck(int id, String nom, int neroCompt, double solde, String typeClient) {
    this.id = id;
    this.nom = nom;
    NeroCompt = neroCompt;
    this.solde = solde;
    this.typeClient = typeClient;
  }




  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getNeroCompt() {
    return NeroCompt;
  }

  public void setNeroCompt(int neroCompt) {
    NeroCompt = neroCompt;
  }

  public double getSolde() {
    return solde;
  }

  public void setSolde(double solde) {
    this.solde = solde;
  }

  public String getTypeClient() {
    return typeClient;
  }

  public void setTypeClient(String typeClient) {
    this.typeClient = typeClient;
  }
}
