package ma.youcode.ProjetBanque.Modele;

public class Client {

  private int id;
  private String nom;
  private String prenom;
  private int NeroCompt;
  private double solde;
  private String typeClient;


  public Client()
  {

  }


  public Client( String nom, int neroCompt, double solde, String typeClient) {
    this.nom = nom;
    NeroCompt = neroCompt;
    this.solde = solde;
    this.typeClient = typeClient;
  }
  public Client(int id, String nom, int neroCompt, double solde, String typeClient) {
    this.id = id;
    this.nom = nom;
    NeroCompt = neroCompt;
    this.solde = solde;
    this.typeClient = typeClient;
  }

  public Client(int id, String nom,String prenom, int neroCompt, double solde, String typeClient) {
    this.id = id;
    this.nom = nom;
    this.prenom=prenom;
    NeroCompt = neroCompt;
    this.solde = solde;
    this.typeClient = typeClient;

  }

  public Client( String nom,String prenom, int neroCompt, double solde, String typeClient) {
    this.nom = nom;
    this.prenom=prenom;
    NeroCompt = neroCompt;
    this.solde = solde;
    this.typeClient = typeClient;

  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
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
