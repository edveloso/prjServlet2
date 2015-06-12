<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.*,modelo.Autor" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Biblioteca on-line</h1>
	<br />
	<hr />
	<br />

	<fieldset>
		<legend>Cadastro de autores</legend>
		<form action="AutorController?acao=gravar" method="post">
			<p>
				Nome <input type="text" name="nome_autor" size="80">
			</p>
			<p>
				Nacionalidade <input type="text" name="nacionalidade_autor"
					size="80">
			</p>
			<p>
				<input type="submit" value="Gravar">
			</p>
		</form>
	</fieldset>

	<br />

	<table  width="100%"
	        cellpadding="1"
	        cellspacing="1"
	        border="1" 
	 >
		<tr style="background-color: teal; color: white;">
			<th>Nome</th>
			<th>Nacionalidade</th>
			<th>Opções</th>
		</tr>
		
		<%
		   List<Autor> autores = (List<Autor>) 
		   						request.getAttribute("lista_autores");
		
		   if(autores != null )
			   for(Autor autor : autores){
		%>
		
		<tr>
			<td> <%= autor.getNome() %> </td>
			<td>  <%= autor.getNacionalidade() %>  </td>
	
			<td style="padding-left: 20px">
			 
	 <a  onclick="return confirma()" href="AutorController?acao=deletar&codigo=<%= autor.getCodigo() %>">
	      <img width="30px" alt="Deletar" src="./img/file_delete.png">
	 </a>
	 &nbsp;&nbsp;&nbsp;		 
	 <a  href="AutorController?acao=iniciarAlterar&codigo=<%= autor.getCodigo() %>">
	      <img width="30px" alt="Alterar" src="./img/file_edit.png">
	 </a>

			
			</td>
		</tr>
		
		<% } else { %>
		<tr>
			<td colspan="2" align="center">  Não há itens disponíveis!  </td>
		</tr>
		<% } %>
		
		
	</table>


  <script type="text/javascript">
      function confirma(){
    	  	var retorno = confirm("Deseja mesmo deletar?");
    	  	if(retorno)
    	  		return true;
    	  
    	    return false;
      }
  </script>



</body>
</html>








