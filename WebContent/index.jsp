<%@ page language="java" contentType="text/html;charset=UTF-8"
 pageEncoding="UTF-8"%>
 <html>
  <head>
    <title>Anotações</title>
  </head>
  <body>
  <%@ page import="java.util.*,br.edu.insper.mvc.controller.*,br.edu.insper.mvc.model.*" %>
  Anotações<br>
   <table border='1'>
           <% DAO dao = new DAO();
           if(request.getParameter("delete") != null){
               dao.remove(Integer.parseInt(request.getParameter("delete")));
           }
    	   System.out.println(request.getParameter("edit"));
           if(request.getParameter("edit") != null){
        	   Notes note = new Notes();
	    	   note.setId(Integer.valueOf(request.getParameter("edit")));
	    	   note.setNome(request.getParameter("nome"));   
	    	   note.setTexto(request.getParameter("texto"));
        	   dao.altera(note);
           } else if(request.getParameter("create") != null){
        	   Notes note = new Notes();
	    	   note.setNome(request.getParameter("nome"));   
	    	   note.setTexto(request.getParameter("texto"));
        	   dao.adiciona(note);
           }
           List<Notes> notes = dao.getLista();
           System.out.println(request.getParameter("edit"));
           %>
           <tr><td>Anotação</td><td>Conteúdo</td></tr><%
           for (Notes note : notes ) { %>
                <tr>
                    <td><%=note.getNome()%></td>
                    <td><%=note.getTexto()%></td>
                    <td>
                    	<form action="./edita.jsp" method="post">    
                    		<input type="hidden" name="edit" value="<%=note.getId()%>"/>
                    		<input type="hidden" name="nome" value="<%=note.getNome()%>"/>
                    		<input type="hidden" name="texto" value="<%=note.getTexto()%>"/>
            				<input type="submit" value ="Editar"/>
        				</form>	
        			</td> <td>
                    	<form action="#" method="post">    
                    		<input type="hidden" name="delete" value="<%=note.getId()%>"/>
            				<input type="submit" value ="Deletar"/>
        				</form>	
                    </td>
                </tr>
    <% } %> 
    </table> 
    <form action="./cria.jsp">
    <input type="submit" value="Nova Anotação" />
	</form>
   </body>
 </html>