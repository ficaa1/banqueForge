<%@ page import="fr.banque.beans.*" %>
<%
	
User user = (User) request.getSession().getAttribute("user");
	if(user == null)
	{
		response.sendRedirect("/index");
	}
%>