<%@page import="fornecedorModel.Fornecedor"%>
<%@page import="java.sql.SQLException"%>
<%@page import="fornecedorDAO.FornecedorDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fornecedor Inserido!</title>
</head>
<body>
	<%
	 String codigo = request.getParameter("codigo");
	 String nome = request.getParameter("nome");
	 String apelido = request.getParameter("apelido");
	 String genero = request.getParameter("genero");
	 String endereco = request.getParameter("endereco");
	 String dataNascimento = request.getParameter("dataNascimento");
	 String nacionalidade = request.getParameter("nacionalidade");
	 String email = request.getParameter("email");
	 String telefone = request.getParameter("telefone");
	 
	 FornecedorDAO forn = new FornecedorDAO();

	 forn.InserirFornecedorDAO(codigo, nome, apelido, genero, endereco, dataNascimento, nacionalidade, email, telefone);
	%>

	
	<script type="text/javascript">
	window.location.href="http://localhost:8080/FornecedorJSP/index.jsp"
	</script>
</body>
</html>