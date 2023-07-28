package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import fornecedorModel.Fornecedor;
import fornecedorDAO.FornecedorDAO;


/**
 * Servlet implementation class GerenciarFornecedor
 */
public class GerenciarFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerenciarFornecedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String Mensagem = "";
		
		String acao = request.getParameter("acao");
		String codigo = request.getParameter("codigo");
		
		Fornecedor f = new Fornecedor();
		
		try {
			FornecedorDAO af = new FornecedorDAO();
			
			if(acao.equals("alterar")) {
				f = af.getPorCodigo(Integer.parseInt(codigo));
				if(f.getCodigo()>0) {
					RequestDispatcher disp = getServletContext().getRequestDispatcher("/formAtualizar.jsp");
					request.setAttribute("fornecedor", f);
					disp.forward(request, response);
				}else {
					Mensagem = "Fornecedor Não Encontrado!";
				}
			}
			FornecedorDAO excluirF = new FornecedorDAO();
			if(acao.equals("deletar")) {
				f.setCodigo(Integer.parseInt(codigo));
				if(excluirF.deletarFornecedor(f)) {
					Mensagem = "Fornecedor deletado com sucesso!"; 
				}else {
					Mensagem = "Erro ao deletar fornecedor!";
				}
			}
		} catch (Exception e) {
			out.println(e);
			Mensagem = "Erro ao executar acção!" + e;
		}
		
		out.println("<script type=\"text/javascript\">");
		out.println( "alert('"+Mensagem+"')");
		out.println("window.location.href=\"http://localhost:8080/FornecedorJSP/listaFornecedores.jsp\"");
		out.println("</script>");
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*PrintWriter out = response.getWriter();
		 String codigo = request.getParameter("codigo");
		 String nome = request.getParameter("nome");
		 String apelido = request.getParameter("apelido");
		 String genero = request.getParameter("genero");
		 String endereco = request.getParameter("endereco");
		 String dataNascimento = request.getParameter("dataNascimento");
		 String nacionalidade = request.getParameter("nacionalidade");
		 String email = request.getParameter("email");
		 String telefone = request.getParameter("telefone");
		 
		 String Mensagem = "";
		 Fornecedor f = new Fornecedor();
		 
		 try {
			InserirFornecedorDAO fDAO = new InserirFornecedorDAO();
			
			if(!codigo.isEmpty()) {
				f.setCodigo(Integer.parseInt(codigo));
			}
			
			f.setNome(nome);
			f.setApelido(apelido);
			f.setGenero(genero);
			f.setEndereco(endereco);
			f.setDataNascimento(dataNascimento);
			f.setNacionalidade(nacionalidade);
			f.setEmail(email);
			f.setTelefone(telefone);
			
			if(fDAO.gravar(f)) {
				Mensagem = "Gravado com sucesso!";
			}else {
				Mensagem = "Não gravado na base de dados";
			}
		} catch (Exception e) {
		
		}*/
		
	}

}
