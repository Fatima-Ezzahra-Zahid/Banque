<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Banque</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</head>
<body>


<header>
  <nav class="navbar navbar-expand-md navbar-dark"
       style="background-color: #8ea9f9">
    <div>
      <a href="" class="navbar-brand"> Gestion Clients</a>
    </div>

    <ul class="navbar-nav">
      <li><a href="<%=request.getContextPath()%>/list"
             class="nav-link">Clients</a></li>
    </ul>
  </nav>
</header>
<table >

  <div class="wrapper">


    <div id="body" class="active">

      <div class="content">
        <div class="container-fluid">
          <div class="page-title">
            <h3>CompteBancaire</h3>
          </div>
          <div class="row">


            <div class="col-lg-12">
              <div class="card">
                <div class="card-header">Modifier Client</div>
                <div class="card-body">
                  <h5 class="card-title"></h5>
                  <form class="form-horizontal" action="update" method="post">


                    <c:if test="${compte!= null}">
                      <input type="hidden" name="id" value="<c:out value='${compte.id}' />" />
                    </c:if>
                    <div class="form-group row">
                        <label class="col-sm-2">Type</label>
                        <div class="col-sm-10">
                          <select class="form-select" aria-label="Default select example"    name="typeclient"  id="slt" onclick="changeType()">
                            <option  value="<c:out value='${compte.typeClient}' />" selected><c:out value='${compte.typeClient}' /></option>
                            <option value="Personne">Personne</option>
                            <option value="Entreprise">Entreprise</option>
                          </select>
                        </div>
                      </div>
                      <div class="line"></div><br>
                      <div class="form-group row">
                        <label class="col-sm-2">Nom</label>
                        <div class="col-sm-10">
                          <input type="text" name="nom" value="<c:out value='${compte.nom}' />" class="form-control">
                        </div>
                      </div>
                      <div class="line"></div><br>
                      <div class="form-group row"  id="div" style="visibility: hidden "  >
                        <label class="col-sm-2">Prenom</label>
                        <div class="col-sm-10" >
                          <input type="text"  name="prenom" value="<c:out value='${compte.prenom}' />" class="form-control">
                        </div>
                      </div>
                      <div class="line"></div><br>
                      <div class="form-group row">
                        <label class="col-sm-2">Numero de Compt</label>
                        <div class="col-sm-10">
                          <input type="text" name="numero"  value="<c:out value='${compte.neroCompt}' />" class="form-control">
                        </div>
                      </div>
                      <div class="line"></div><br>
                      <div class="form-group row">
                        <label class="col-sm-2">Solde</label>
                        <div class="col-sm-10">
                          <input type="text"   name="solde" value="<c:out value='${compte.solde}' />" class="form-control">
                        </div>
                      </div>




                      <div class="line"></div><br>
                      <div class="form-group row">
                        <div class="col-sm-4 offset-sm-2">
                          <button type="submit" id="annuler" class="btn btn-secondary mb-2"><i class="fas fa-times"></i> Annuler</button>
                          <button type="submit" class="btn btn-primary mb-2"><i class="fas fa-save"></i> Modifier</button>
                        </div>
                      </div>
                    </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</table>


<script>

  var div=document.getElementById("div");

  var typeclient=document.getElementById("slt");


  function changeType() {

    if (typeclient.value == "Personne") {
      div.style.visibility = "visible";
    }
    else {
      div.style.visibility = "hidden";
    }

  }
</script>
</body>
</html>
