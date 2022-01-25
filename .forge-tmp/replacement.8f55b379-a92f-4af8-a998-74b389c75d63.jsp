<title>Home-Client</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link href="../assets/css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
<%
	List<Compte> mescomptes = new ArrayList<Compte>();
	mescomptes = (ArrayList<Compte>) request.getAttribute("mescomptes");
	if(mescomptes==null){
        
        %>
			<div class="container">
			<div class="alert alert-danger">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Error!</strong> <%out.println("Aucun compte"); %>!
		
			</div>
			</div>
       <%
    }else{
    	%>
    	<div class="col-md-12">
    	<h1 class="page-header">My bank accounts</h1>
				<div class="table-responsive">
					<table class="table  table-bordered table-striped table-condensed" id="mytable">
			  			<thead>
					      <tr class="active info">  
					        <th>Number </th>
					        <th>Statement</th>
					        <th>Maximum transfer amount</th>
					        <th>Maximum debt</th>	 