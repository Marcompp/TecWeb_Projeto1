package br.edu.insper.mvc.controller;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import javax.servlet.annotation.WebServlet;

@WebServlet("/remove")
public class Remove extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	}

	@Override
    protected void doPost(HttpServletRequest request,
    		HttpServletResponse response) 
    throws ServletException, IOException {

		   DAO dao = new DAO(); 
		   System.out.println(request.getParameter("id"));
		   dao.remove(Integer.valueOf(request.getParameter("id")));
		
		   PrintWriter out = response.getWriter();
	} 


}