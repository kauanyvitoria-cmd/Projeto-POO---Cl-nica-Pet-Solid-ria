import java.util.ArrayList;

public class Animal {

    // ATRIBUTOS (ENCAPSULAMENTO)
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String observacoes;
    private String nomeTutor;

    // HISTÓRICO DE ATENDIMENTOS
    private ArrayList<Procedimento> historico = new ArrayList<>();

    // CONSTRUTOR
    public Animal(String nome, String especie, String raca, int idade, String observacoes, String nomeTutor) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.observacoes = observacoes;
        this.nomeTutor = nomeTutor;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // MÉTODOS
    // MÉTODO CADASTRAR PROCEDIMENTO REALIZADO
    public void cadastrarProcedimentoRealizado(Procedimento procedimento) {
        historico.add(procedimento);
        System.out.println("Histórico de procedimentos do animal cadastrado com sucesso!");
    }

    //MÉTODO ATUALIZAR DADOS DO ANIMAL
    public void atualizarDadosAnimal(String nome, String especie, String raca, int idade, String observacoes) {
        this.setNome(nome);
        this.setEspecie(especie);
        this.setRaca(raca);
        this.setIdade(idade);
        this.setObservacoes(observacoes);

        System.out.println("Dados do animal atualizados com sucesso!");
    }

    //MÉTODO CONSULTAR HISTÓRICO
    public void consultarHistorico() {
        System.out.println("Tutor Responsável: " + nomeTutor);
        if (historico.isEmpty()) {
            System.out.println("Nenhum registro encontrado.");
        } else {
            for (Procedimento registro : historico) {
                System.out.println(registro.getNomeProcedimento());
            }
        }
    }
}