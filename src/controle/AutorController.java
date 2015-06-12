package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.tools.internal.ws.processor.model.Request;

import modelo.Autor;
import modelo.AutorDAO;


@WebServlet("/AutorController")
public class AutorController extends HttpServlet {

	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AutorDAO dao = new AutorDAO();
		String acao = req.getParameter("acao");
		if("deletar".equals(acao)){
			String codigo = req.getParameter("codigo");
			System.out.println(codigo);
			Integer codigoNumerico = Integer.parseInt(codigo);
			dao.deletar(codigoNumerico);
			List<Autor> autores = dao.listaTodos();
			req.setAttribute("lista_autores", autores);
			req.getRequestDispatcher("autores.jsp").forward(req, resp);
		}
		else if("iniciarAlterar".equals(acao)){
			String codigo = req.getParameter("codigo");
			Integer codigoNumerico = Integer.parseInt(codigo);
			Autor autor = dao.obterAutorPeloCodigo(codigoNumerico);
			req.setAttribute("autor", autor);
			req.getRequestDispatcher("editar.jsp").forward(req, resp);
		}
		
		else if("listar".equals(acao)){
			List<Autor> autores = dao.listaTodos();
			req.setAttribute("lista_autores", autores);
			req.getRequestDispatcher("autores.jsp").forward(req, resp);
		}
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		AutorDAO dao =  new AutorDAO();
		
		if("gravar".equals(acao)){
			String nome = request.getParameter("nome_autor");
			String nacionalidade = request.getParameter("nacionalidade_autor");
			
			Autor autor = new Autor();
			autor.setNacionalidade(nacionalidade);
			autor.setNome(nome);
			
			dao.gravar(autor);
		}
		else if("efetivarAlteracao".equals(acao)){
			String nome = request.getParameter("nome_autor");
			String nacionalidade = request.getParameter("nacionalidade_autor");
			String codigo = request.getParameter("codigo");
			Integer codigoNumerico = Integer.parseInt(codigo);
			Autor autor = new Autor();
			autor.setNacionalidade(nacionalidade);
			autor.setNome(nome);
			autor.setCodigo(codigoNumerico);
			dao.alterar(autor);
		}
		
		
		
		List<Autor> autores = dao.listaTodos();
		request.setAttribute("lista_autores", autores);
		request.getRequestDispatcher("autores.jsp").forward(request, response);
		
		
	}

}
