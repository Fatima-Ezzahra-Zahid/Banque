package ma.youcode.ProjetBanque.Controller;

import ma.youcode.ProjetBanque.DAO.ClientsDImp;
import ma.youcode.ProjetBanque.DAO.PersonneDAOImpl;
import ma.youcode.ProjetBanque.Modele.CompteBanck;
import ma.youcode.ProjetBanque.Modele.Personne;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.util.List;

@WebServlet( "/")
public class ServletClient extends HttpServlet {
  @Serial
  private static final long serialVersionUID = 1L;
  private ClientsDImp clientsDImp =new ClientsDImp();;

  @Override
  public void init() throws ServletException {
    super.init();


  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    doGet(request, response);


  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    String action = request.getServletPath();

    try {
      switch (action) {
        case "/new":
          showNewForm(request, response);
          break;
        case "/insert":
          insertClient(request, response);
          break;
        case "/delete":
          deleteClient(request, response);
          break;
        case "/edit":
          showEditForm(request, response);
          break;
        case "/update":
          updatClient(request, response);
          break;
        case "/recherche":
            RechercheClient(request, response);
          break;
        default:
          listclient(request, response);
          break;
      }
    } catch (SQLException | ClassNotFoundException ex) {
      throw new ServletException(ex);
    }

  }







  private void listclient(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {

    List<CompteBanck> listClients=clientsDImp.AffichAllClients();
    request.setAttribute("listClients",listClients);
    RequestDispatcher dispatcher = request.getRequestDispatcher("listeClients.jsp");
    dispatcher.forward(request, response);
  }

  private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response);
  }

  private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    System.out.println(id);
     Personne existingclient =clientsDImp.AfficheByID(id);
    RequestDispatcher dispatcher = request.getRequestDispatcher("Modifier.jsp");
    request.setAttribute("compte", existingclient);
    dispatcher.forward(request, response);
  }

  private void insertClient(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ClassNotFoundException {
    String type=request.getParameter("typeclient");
    String nom=request.getParameter("nom");
    String prenom=request.getParameter("prenom");
    int numeroCompt= Integer.parseInt(request.getParameter("numero"));
    double solde=Double.parseDouble(request.getParameter("solde"));

    clientsDImp.AjoutClients(nom,prenom,numeroCompt,solde,type);
    response.sendRedirect("listeClients");
  }

  private void updatClient(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));
    String nom=request.getParameter("nom");
    String prenom=request.getParameter("prenom");
    int numeroCompt= Integer.parseInt(request.getParameter("numero"));
    double solde=Double.parseDouble(request.getParameter("solde"));
    String type=request.getParameter("typeclient");
    clientsDImp.ModifierClients(id,nom,numeroCompt,solde,type);
    if (type.equals("Personne")){
      PersonneDAOImpl p = new PersonneDAOImpl();
      p.UpdatePersonne(id, prenom);
    }
    response.sendRedirect("listeClients");
  }

  private void deleteClient(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    String type=request.getParameter("typeclient");
    clientsDImp.SupprimeClinets(id,type);
    response.sendRedirect("listeClients");

  }

  private void RechercheClient(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {

    String type=request.getParameter("typeclient");
    List<CompteBanck> listClients=clientsDImp.AfficheClients(type);
    request.setAttribute("listClients",listClients);
    RequestDispatcher dispatcher = request.getRequestDispatcher("listeClients.jsp");
    dispatcher.forward(request, response);

      }




}
	/*public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new User(id, name, email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}*/
