package modelo;

import java.util.ArrayList;
import java.util.List;


public class AutorDAO {
	
	private static List<Autor> bancoDeDados = new ArrayList<Autor>();
	
	public void gravar(Autor autor){
		autor.setCodigo(bancoDeDados.size()); 
		bancoDeDados.add(autor);
	}
	
	public void deletar(Integer codigo){
		System.out.println(bancoDeDados);
		System.out.println(bancoDeDados.remove(codigo));
		System.out.println(bancoDeDados);
	}
	
	public List<Autor> listaTodos(){
		return bancoDeDados;
	}
	
	
	

}
