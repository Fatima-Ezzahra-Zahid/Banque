package ma.youcode.ProjetBanque.Modele;

public class TypeClient {

  private int id;
  private String nom;

  public TypeClient()
  {

  }

  public TypeClient(int id, String nom) {
    super();
    this.id = id;
    this.nom = nom;
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
}
