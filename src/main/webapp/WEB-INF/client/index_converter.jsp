                      

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

String res = "";
   if ( request.getAttribute("resultat_conversion") != null){
		 res =  request.getAttribute("resultat_conversion").toString();

	
   }
	
%>     


<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Convertisseur Devise</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link href="../assets/css/style.css" rel="stylesheet"></head>

<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="container">
  <div class="row">
    <diV class="col-md-offset-3 col-md-6">
        <div class="panel panel-info">
   <div class="panel-heading">
            <div class="page-header">
                  <p>
                        <h1 class="text-center"> Convertisseur devise</h1>
            
                  </p>
            </div>

          </div>
          
          
          
  <div>
  
  
  
   <div class="panel-body">
              <form class="text-center" id="form1" method="POST" >
   
   
    <label for="text">From</label> 
                <div class="row">
                  <div class="col-md-offset-3 col-md-6">
 			<select name="devise_from" id="devise_from" class="form-control" tabindex="1" required  autofocus>
            <option value="USD">USD - United States Dollar</option>
            <option value="EUR">EUR - Euro</option>
            <option value="GBP">GBP - British Pound Sterling</option>
            <option value="MXN">MXN - Mexican Peso</option>
            <option value="JPY">JPY - Japanese Yen</option>
            <option value="INR">INR - Indian Rupee</option>
            <option value="CNY">CNY - Chinese Yuan</option>
            <option value="CAD">CAD - Canadian Dollar</option>
            <option value="RUB">RUB - Russian Ruble</option>		
            <option value="KRW">KRW - South Korean Won</option>
	   		<option value="BTC">BTC - Bitcoin</option>
	  </select>                  </div>
                </div>
    
	 
      
      
      
       
             
       
        
        <label for="text">To</label> 
         <div class="row">
                  <div class="col-md-offset-3 col-md-6">
	  <select name="devise_to" id="devise_to" class="form-control" tabindex="1" autofocus>
            <option value="USD">USD - United States Dollar</option>
            <option value="EUR">EUR - Euro</option>
            <option value="GBP">GBP - British Pound Sterling</option>
            <option value="MXN">MXN - Mexican Peso</option>
            <option value="JPY">JPY - Japanese Yen</option>
            <option value="INR">INR - Indian Rupee</option>
            <option value="CNY">CNY - Chinese Yuan</option>
            <option value="CAD">CAD - Canadian Dollar</option>
            <option value="RUB">RUB - Russian Ruble</option>		
            <option value="KRW">KRW - South Korean Won</option>
	    <option value="BTC">BTC - Bitcoin</option>
	  </select>
	    </div>
                </div>  
                
                 <label for="text">Montant</label> 
                      <div class="row">
             
                      <div class="col-md-offset-3 col-md-6">
             <input type="number" name="montant"  class="form-control" tabindex="2" required placeholder="Montant" autofocus> <br/>

                      </div>  
                      </div>
                      
                      
                      

                      
          <label for="text">Résultat</label> 
                <div class="row">
                  <div class="col-md-offset-3 col-md-6">
              <text type=number  name="numero_compte" class="form-control" tabindex="1" autofocus ><%out.print(res);%><br/>                     
                  </div>
                </div>
                      
         
    
         
  </form>
  
  </div>
  
  
  
  </div>


  <div class="panel-footer">
              <button type="submit" class="btn btn-success" name="calcule"  form="form1">Calcule</button>             
              <button type="reset" class="btn btn-danger  pull-right"  onclick="history.go(-1)" >Annuler</button>

          </div>



    </div>  
  </div>


</div>
</div>



<script src="../assets/js/jquery.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>

</body>
