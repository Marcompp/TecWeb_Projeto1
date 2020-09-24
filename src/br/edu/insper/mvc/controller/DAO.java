package br.edu.insper.mvc.controller;

import java.util.*;

import br.edu.insper.mvc.model.Notes;

import java.sql.*;

public class DAO {
	private Connection connection = null; 
	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/notes?serverTimezone=UTC", "root", "84518442");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Notes> getLista() {
		List<Notes> notes = new ArrayList<Notes>();
		
		try {
			/*PreparedStatement stmm = connection.prepareStatement("SHOW DATABASES;");
			ResultSet rssm = stmm.executeQuery();
			
			System.out.println(rssm);
			stmm.close();*/
			
			PreparedStatement stmt = connection.
					prepareStatement("SELECT * FROM Notes");
			ResultSet rs = stmt.executeQuery();
		
		
			while (rs.next()) {
				Notes note = new Notes();
				note.setId(rs.getInt("id"));
				note.setNome(rs.getString("nome"));
				note.setTexto(rs.getString("texto"));
				notes.add(note);
			}
			rs.close();
			stmt.close();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notes;
	}
	

	public Notes acha(Integer id) {
		List<Notes> notes = new ArrayList<Notes>();
		for (Notes note: notes) {
			if (note.getId() == id) {
				return note;
			}
		}
		return null;
	}
	
	public void adiciona(Notes note) {
		String sql = "INSERT INTO Notes" +
				"(nome,texto) values(?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,note.getNome());
			stmt.setString(2,note.getTexto());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void altera(Notes note) {
		String sql = "UPDATE Notes SET " +
				"nome=?, texto=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, note.getNome());
			stmt.setString(2,note.getTexto());
			stmt.setInt(3, note.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(Integer id) {
		try {
			PreparedStatement stmt = connection
				.prepareStatement("DELETE FROM Notes WHERE id=?");
		
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}



}

