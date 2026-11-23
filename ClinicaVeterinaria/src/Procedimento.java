public class Procedimento {

    // ATRIBUTOS
    private String nomeProcedimento;
    private String descricao;
    private double custoSocial;
    private boolean disponibilidade;

    // CONSTRUTOR
    public Procedimento(String nomeProcedimento, String descricao, double custoSocial, boolean disponibilidade) {
        this.nomeProcedimento = nomeProcedimento;
        this.descricao = descricao;
        this.custoSocial = custoSocial;
        this.disponibilidade = disponibilidade;
    }

    //GET = ACESSAR
    public String getNomeProcedimento(){
        return nomeProcedimento;
    }

    public String getDescricao(){
        return descricao;
    }

    public double getcustoSocial(){
        return custoSocial;
    }

    //MÉTODOS
    // MÉTODO PARA CADASTRAR PROCEDIMENTO
    public void cadastrarProcedimento() {
        System.out.println("Procedimento cadastrado: " + nomeProcedimento);
    }

    // MÉTODO PARA ATUALIZAR CUSTO SOCIAL
    public void atualizarCustoSocial(double novoCusto) {
        this.custoSocial = novoCusto;
        System.out.println("Novo custo social: R$ " + custoSocial);
    }
}