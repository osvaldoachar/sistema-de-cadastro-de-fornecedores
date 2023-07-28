package fornecedorModel;

public class Fornecedor {

		private int codigo;
		private String nome;
		private String apelido;
		private String genero;
		private String endereco;
		private String dataNascimento;
		
		public Fornecedor(String nome, String apelido, String genero, String endereco, String dataNascimento,
				String nacionalidade, String email, String telefone) {
			super();
			this.nome = nome;
			this.apelido = apelido;
			this.genero = genero;
			this.endereco = endereco;
			this.dataNascimento = dataNascimento;
			this.nacionalidade = nacionalidade;
			this.email = email;
			this.telefone = telefone;
		}

		private String nacionalidade;
		private String email;
		private String telefone;
		
		public Fornecedor() {
			super();
		}

		public Fornecedor(int codigo, String nome, String apelido, String genero, String endereco, String dataNascimento,
				String nacionalidade, String email, String telefone) {
			super();
			this.codigo = codigo;
			this.nome = nome;
			this.apelido = apelido;
			this.genero = genero;
			this.endereco = endereco;
			this.dataNascimento = dataNascimento;
			this.nacionalidade = nacionalidade;
			this.email = email;
			this.telefone = telefone;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getApelido() {
			return apelido;
		}

		public void setApelido(String apelido) {
			this.apelido = apelido;
		}

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public String getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public String getNacionalidade() {
			return nacionalidade;
		}

		public void setNacionalidade(String nacionalidade) {
			this.nacionalidade = nacionalidade;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		@Override
		public String toString() {
			return "Fornecedor [nome=" + nome + ", apelido=" + apelido + ", genero=" + genero + ", endereco=" + endereco
					+ ", dataNascimento=" + dataNascimento + ", nacionalidade=" + nacionalidade + ", email=" + email
					+ ", telefone=" + telefone + "]";
		}
		
		

	}

