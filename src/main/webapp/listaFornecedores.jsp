<%@page import="fornecedorDAO.FornecedorDAO"%>
<%@page import="fornecedorModel.Fornecedor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Fornecedores</title>
    <style>
         *{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
    font-family: Poppins, sans-serif;
}
body{
    display: flex;
    height: 100vh;
    padding: 10px;
    justify-content: center;
    align-items: center;
    background:  #e41515;
}
html::-webkit-scrollbar {
    width: 7px;
  }
  html::-webkit-scrollbar-track {
    
    background:  #e41515;
  }
  html::-webkit-scrollbar-thumb {
    background: #ffffff;
    border-radius: 5rem;
  }
  .box-container2{
    position: absolute;
    width: 99%;
    margin: 5px;
    top: 1%;
    left: 5px;
    right: 1px;
    background-color: white;
    padding: 15px;
    border-radius: 10px;
}
.tittle{
    font-size: 25px;
    font-weight: 600;
    position: relative;
    margin: 10px 0;
}
.tittle::before{
    content: '';
    position: absolute;
    left: 0;
    bottom: 0;
    height: 3px;
    width: 150px;
    border-radius: 50px;
    background: linear-gradient(135deg, #d80000, #e95c5c);
}

td{
    padding-left: 4px;
}
.exclui{
    width: 100%;
    outline: none;
    justify-content: center;
    align-items: center;
    color: #fff;
    border: none;
    background: linear-gradient(145deg, #d80000, #f86e6e);
    font-size: 12px;
    padding: 5px;
    text-decoration: none;
    display: flex;
}
.atualiza{
    background: linear-gradient(145deg, #0004d8, #2d6bf0);
    width: 100%;
    outline: none;
    justify-content: center;
    align-items: center;
    color: #fff;
    border: none;
    font-size: 12px;
    padding: 5px;
    text-decoration: none;
    display: flex;
}
.btn-novo{
    text-decoration: none;
    width: 20%;
    outline: none;
    color: #fff;
    border: none;
    background: linear-gradient(145deg, #d80000, #f86e6e);
    font-size: 20px;
    font-weight: 600;
    border-radius: 5px;
    transition: 1s linear;
    letter-spacing: 1px;
    right: 0;
    padding: 15px;
    position: absolute;
    text-align: center;
}
.btn-novo:hover{
    background: linear-gradient(195deg, #d80000, #f74444);
    letter-spacing: 1.5px;
}
table{
    border: solid 3px #f74444;
    text-align: center;
    border-radius: 5px;
}
th{
    background-color: aquamarine;
    border: none;
    font-weight: 600;
}
tr{
    border: none;
    padding: 10px;
    transition: all .6s ease;
}
td{
	transition: all .6s ease;
}
td:hover{
    background-color: rgb(255, 255, 235);
}
    </style>
    <script type="text/javascript">
    function confirmarExclusao(codigo, nome, apelido){
    	if(confirm('Desejas excluir o fornecedor ' + codigo + ' - '+nome+' '+apelido +'?')){
    		
    		location.href='GerenciarFornecedor?acao=deletar&codigo='+codigo;
    	}
    }
    
    </script>
</head>
<body>
    <div class="box-container2">
        <hr><div class="tittle">Lista de Fornecedores <a href="index.jsp" class="btn-novo">Novo Fornecedor</a></div> <br><hr>
                <table width="100%" border=1 class="table table-hover"> 
                    <tr class="cabeçalho"  style="height: 25px;">
                        <th>Código</th>
                        <th>Nome Completo</th>
                       
                        <th>Gênero</th>
                        <th>Endereço</th>
                        <th>Data de Nascimento</th>
                        <th>Nacionalidade</th>
                        <th>E-mail</th>
                        <th>Telefone</th>
                        <th>Operações</th>
                    </tr>
                    <% 
                    	ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
                    
                    	try{
                    		FornecedorDAO fDAO = new FornecedorDAO();
                    		lista = fDAO.getLista();
                    	}catch(Exception e){
                    		out.print(e);
                    	}
                    	for(Fornecedor f:lista){
                    %>
                    <tr>
                        <th><%=f.getCodigo() %></th>
                        <td><%=f.getNome() +" "+ f.getApelido()%></td>
                        
                        <td><%=f.getGenero() %></td>
                        <td><%=f.getEndereco() %></td>
                        <td><%=f.getDataNascimento() %></td>
                        <td><%=f.getNacionalidade() %></td>
                        <td><%=f.getEmail() %></td>
                        <td><%=f.getTelefone() %></td>
                        <th class="valores"><a href="GerenciarFornecedor?acao=alterar&codigo=<%=f.getCodigo() %>" class="atualiza">Atualizar</a>
                         <button class="exclui" onclick="confirmarExclusao(<%= f.getCodigo() %>, '<%= f.getNome() %>', '<%= f.getApelido() %>')">Excluir</button></th>
                    </tr>
                    <% } %>
                </table>
    </div>
    
  
    
</body>
</html>
