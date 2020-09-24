<%@ page language="java" contentType="text/html;charset=UTF-8"
 pageEncoding="UTF-8"%>
 <html>
  <head>
    <title>Criar</title>
  </head>
  <body>
  <%@ page import="java.util.*,br.edu.insper.mvc.controller.*,br.edu.insper.mvc.model.*" %>
  
	<form action="./index.jsp" method='post'>
	 	<input type="hidden" name="create" value="true"/>
        Nome: <input type='text' name='nome'%>"><br>
	    Texto: <input type=‘text' name='texto'%>"><br>
	    <input type='submit' value='Submit'>
	</form>
   </body>
 </html>