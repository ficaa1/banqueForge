<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=${encoding}">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
<link href="./assets/css/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Open+Sans" />
<title>Connexion</title>
</head>
<body>
<%
	String error = (String) request.getAttribute("error");
	if(error != null)
	{// on affiche le message d'erreur
		
%>
	<div class="conatiner">
	<div class="alert alert-danger">
	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong>Erreur ! </strong>${error}
		<a class="btn btn-success" href="#" onclick="history.go(-1)">retour</a>
			</div>
	</div>

 <%
	}else
	{
%>
		

<div class="container">
  <div class="row">
    <diV class="col-md-offset-3 col-md-6">
        <div class="panel panel-info">
          <diV class="panel-heading">
            <div class="page-header">
                  <p>
                        <h1 class="text-center"> Connexion</h1>
            
                  </p>
            </div>

          </diV>
          <div class="panel-body">
              <form class="text-center" id="form1" method="POST" >
              
            <label for="text">Email</label> 
                <div class="row">
                  <div class="col-md-offset-3 col-md-6">
              <input type="email" name="login"  class="form-control" tabindex="1" required placeholder="votre mail" autofocus> <br/>                     
                  </div>
                </div>
             
             <label for="text">Password</label> 
                      <div class="row">
             
                      <div class="col-md-offset-3 col-md-6">
             <input type="password" name="password"  class="form-control" tabindex="2" required placeholder="mot de passe" autofocus> <br/>

                      </div>  
                      </div>
             

            </form>

          </div>

          <div class="panel-footer">
              <button type="submit" class="btn btn-success" name="connexion"  form="form1">Connexion</button> 
                     
          </div>

        </div>

    </div>  
  </div>


</div>

<%		
	}	
%>


<script src="./assets/js/jquery.js"></script>
<script src="./assets/js/bootstrap.min.js"></script>
</body>
</html>