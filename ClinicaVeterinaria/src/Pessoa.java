//CLASSE BASE
public class Pessoa {
    //ENCAPSULAMENTO
    private String nome;
    private String cpf;
    private String telefone;
    protected String endereco;

    //CONSTRUTOR
    public Pessoa(String nome, String cpf, String telefone, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    //GETTERS E SETTERS
    public String getNome(){
        return nome;
    }
      public void setNome(String nome){
        this.nome = nome;
    }

     public String getTelefone(){
        return telefone;
     }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

     public String getCpf(){
        return cpf;
    }

     public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    //METÓDO
    //MÉTODO PARA CADASTRAR PESSOAS
    public void cadastrarPessoa() {
        System.out.println("Cadastro realizado com sucesso!");
    }
    
    //POLIMORFISMO
    //MÉTODO PARA EXIBIR DADOS
    public void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
    }

    //POLIMORFISMO POR ESCRITA
    //MÉTODO PARA ATUALIZAR OS DADOS (Tutor e Veterinário)
    public void atualizarDados(String telefone, String endereco) {
        this.setTelefone(telefone);
        this.setEndereco(endereco);
        System.out.println("Dados atualizados com sucesso!");
    }

    //MÉTODO PARA CONSULTAR O CADASTRO (Tutor, Animal e Veterinário)
    public void consultarCadastro() {
        System.out.println("-- Consulta de Cadastro --");
        exibirDados();
    }
}
