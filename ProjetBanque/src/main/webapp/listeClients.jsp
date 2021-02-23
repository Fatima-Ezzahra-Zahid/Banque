<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 20/02/2021
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</head>
<body>

<form method="post"  action="recherche">
  <select class="form-select" aria-label="Default select example" name="typeclient" id="slt"  style="
    margin-top: 1em;
    margin-bottom: 2em;
">
    <option selected>Select Type</option>
    <option value="Personne">Personne</option>
    <option value="Entreprise">Entreprise</option>

  </select>
  <button type="submit" class="btn btn-success" onclick="changeType()">Recherche</button>
</form>

<div class="container text-left">

  <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Ajouter un client</a>
</div>

<div class="content">
  <div class="container-fluid">
    <div class="page-title">
      <h3>Listes des Clients

      </h3>
    </div>
    <div class="box box-primary">
      <div class="box-body">
        <table width="100%" class="table table-hover" id="dataTables-example">
          <thead>
          <tr>
            <th>id</th>
            <th>nom</th>
            <th id="div">Prenom</th>
            <th>Numero de compte</th>
            <th>Solde</th>
            <th>type de Client</th>
          </tr>
          </thead>
          <tbody>
      <c:forEach var="client" items="${listClients}">
          <tr>
            <td><c:out value="${client.id}" /></td>
            <td><c:out value="${client.nom}" /></td>
            <td><c:out value="${client.prenom}"/></td>
            <td><c:out value="${client.neroCompt}" /></td>
            <td><c:out value="${client.solde}" /></td>
            <td><c:out value="${client.typeClient}" /></td>
            <td class="text-right">
              <a href="edit?id=<c:out value='${client.id}'/>" class="btn btn-outline-info btn-rounded"><i class="fas fa-pen"></i></a>
              <a href="delete?id=<c:out value='${client.id}' />" class="btn btn-outline-danger btn-rounded"><i class="fas fa-trash"></i></a>
            </td>
          </tr>
      </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>


<script>

  var div=document.getElementById("div");

  var typeclient=document.getElementById("slt");


  function changeType() {

    if (typeclient.value == "Personne") {
      div.style.display = "table-cell";
    }
    else {
      div.style.display = "none";
    }

  }
</script>
</body>
</html>
