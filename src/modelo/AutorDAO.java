package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AutorDAO {
	
	private static List<Autor> bancoDeDados = new ArrayList<Autor>();
	//ALTEREI
	private static int cont;
	
	public void gravar(Autor autor){
		//ALTEREI
		autor.setCodigo(cont++);
		bancoDeDados.add(autor);
	}
	
	public void deletar(Integer codigo){
		for(Iterator<Autor> it = bancoDeDados.iterator(); it.hasNext();){
			Autor autor =  it.next();
			if(autor.getCodigo().equals(codigo)){
				bancoDeDados.remove(autor);
				break;
			}
		}
		
		
	}
	
	public List<Autor> listaTodos(){
		return bancoDeDados;
	}
	
	
	public void alterar(Autor autor){
		for(Autor autorBD : bancoDeDados){
			if(autorBD.getCodigo().equals(autor.getCodigo())){
				autorBD.setNacionalidade(autor.getNacionalidade());
				autorBD.setNome(autor.getNome()); 
			}
		}
	}
	
	public Autor obterAutorPeloCodigo(Integer codigo){
		for(Autor autor : bancoDeDados){
			if(autor.getCodigo().equals(codigo))
				return autor;
		}
		return null;
	}
	
	

}
