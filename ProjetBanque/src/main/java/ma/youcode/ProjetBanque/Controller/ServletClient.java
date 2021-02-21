package ma.youcode.ProjetBanque.Controller;

import ma.youcode.ProjetBanque.DAO.ClientsDImp;
import ma.youcode.ProjetBanque.Modele.Client;

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
  private ClientsDImp clientsDImp ;

  @Override
  public void init() throws ServletException {
    clientsDImp =new ClientsDImp();
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

    List<Client> listClients=clientsDImp.AffichAllClients();
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
    List<Client> existingclient =this.clientsDImp.AfficheByID(id);
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    request.setAttribute("client", existingclient);
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
    clientsDImp.ModifierClients(id,nom,prenom,numeroCompt,solde,type);
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
    List<Client> listClients=clientsDImp.AfficheClients(type);
    request.setAttribute("listClients",listClients);
    
      }




}
