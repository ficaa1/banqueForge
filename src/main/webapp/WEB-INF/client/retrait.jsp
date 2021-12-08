<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.banque.beans.*" %>
<%
	User user = (User) request.getSession().getAttribute("user");
	if(user == null)
	{
		response.sendRedirect("/banque/index");
	}
%>


<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>retrait</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link href="../assets/css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
<div class="container">
  <div class="row">
    <diV class="col-md-offset-3 col-md-6">
        <div class="panel panel-info">
          <diV class="panel-heading">
            <div class="page-header">
                  <p>
                        <h1 class="text-center"> Retrait</h1>
            
                  </p>
            </div>

          </diV>
          <div class="panel-body">
              <form class="text-center" id="form1" method="POST" >
              
            <label for="text">Numero du compte</label> 
                <div class="row">
                  <div class="col-md-offset-3 col-md-6">
              <input type="number"  name="numero_compte" class="form-control" tabindex="1" required placeholder="Numero du compte" autofocus> <br/>                     
                  </div>
                </div>
             
             <label for="text">Montant</label> 
                      <div class="row">
             
                      <div class="col-md-offset-3 col-md-6">
             <input type="number" name="montant"  class="form-control" tabindex="2" required placeholder="Montant" > <br/>

                      </div>  
                      </div>
             

            </form>

          </div>

          <div class="panel-footer">
              <button type="submit" class="btn btn-success" name="crediter"  form="form1">Retrait</button>             
              <button type="reset" class="btn btn-warning  pull-right"  onclick="history.go(-1)" >Annuler</button>

          </div>

        </div>

    </div>  
  </div>


</div>



<script src="../assets/js/jquery.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>

</body>
</html>