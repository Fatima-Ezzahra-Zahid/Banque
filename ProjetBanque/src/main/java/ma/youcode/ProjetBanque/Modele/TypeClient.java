package ma.youcode.ProjetBanque.Modele;

public class TypeClient {

  private int id_type;
  private String nom;

  public TypeClient()
  {

  }

  public TypeClient(int id, String nom) {
    super();
    this.id_type = id;
    this.nom = nom;
  }

  public int getId() {
    return id_type;
  }

  public void setId(int id) {
    this.id_type = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
}
