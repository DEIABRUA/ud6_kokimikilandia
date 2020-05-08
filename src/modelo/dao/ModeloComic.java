package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Comic;
import modelo.bean.Genero;

public class ModeloComic extends Conector{
public ArrayList<Comic> selectAll(){
		
		ArrayList<Comic> comics=new ArrayList<Comic>();
		
		try {
			
			Statement st=super.conexion.createStatement();
			ResultSet rs=st.executeQuery("select * from comics inner join generos on generos.id=comics.genero_id");
			
			while(rs.next()) {
				
				Genero genero=new Genero();
				genero.setId(rs.getInt("generos.id"));
				genero.setNombre(rs.getString("generos.nombre"));
				
				Comic comic=new Comic();
				comic.setId(rs.getInt("comics.id"));
				comic.setNombre(rs.getString("comics.nombre"));
				comic.setTitulo(rs.getString("titulo"));
				comic.setNumero(rs.getInt("num"));
				comic.setFechaPublicacion(rs.getDate("fecha_publicacion"));
				comic.setImagen(rs.getString("imagen"));
				comic.setNumLikes(rs.getInt("num_likes"));
				comic.setGenero(genero);
				
				comics.add(comic);
			}
			
			return comics;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comics;
		
	}
}
