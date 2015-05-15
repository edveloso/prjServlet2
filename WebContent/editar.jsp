<%@page import="modelo.Autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<%
	    Autor autor = (Autor) request.getAttribute("autor");
	
	%>

	<fieldset>
		<legend>Alteração de autor</legend>
		<form action="AutorController?acao=efetivarAlteracao" method="post">
			<input 
				type="hidden" 
				name="codigo" 
				value="<%= autor.getCodigo() %>">
			<p>
				Nome 
				<input type="text" 
						value="<%= autor.getNome()%>" 
						name="nome_autor" 
						size="80">
			</p>
			<p>
				Nacionalidade 
				<input type="text" 
						value="<%= autor.getNacionalidade() %>"
						name="nacionalidade_autor"
						size="80">
			</p>
			<p>
				<input type="submit" value="Alterar">
				<input onclick="cancela()" type="button" value="Cancelar">
			</p>
		</form>
	</fieldset>

	<script type="text/javascript">
	   function cancela(){
		   window.location.href = "autores.jsp";
	   }
	</script>


</body>
</html>