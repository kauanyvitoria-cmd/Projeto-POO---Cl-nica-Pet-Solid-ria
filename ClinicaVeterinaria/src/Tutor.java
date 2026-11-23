// HERANÇA: PESSOA
public class Tutor extends Pessoa {
    //ATRIBUTO PRÓPRIO (ENCAPSULAMENTO)
    private int codigoTutor;
    private double rendaFamiliar;
    private String animaisCadastrados;

    //CONSTRUTOR
    public Tutor(String nome, String cpf, String telefone, String endereco, int codigoTutor, double rendaFamiliar, String animaisCadastrados) {
        super(nome, cpf, telefone, endereco);
        this.codigoTutor = codigoTutor;
        this.rendaFamiliar = rendaFamiliar;
        this.animaisCadastrados = animaisCadastrados;
    }
    
    //GETTERS E SETTERS
    public double getrendaFamiliar(){
        return rendaFamiliar;
    }
    public void setrendaFamiliar(double rendaFamiliar){
        this.rendaFamiliar = rendaFamiliar;
    }

    public String getanimaisCadastrados() {
        return animaisCadastrados;
    }
    public void setanimaisCadastrados(String animaisCadastrados){
        this.animaisCadastrados = animaisCadastrados;
    }

    //MÉTODOS
    //POLIMORFISMO
    //MÉTODO PARA EXIBIR OS DADOS DO TUTOR
    public void exibirDados(){
        super.exibirDados(); 
        System.out.println("Código do Tutor: " + codigoTutor);
        System.out.println("Renda da Família: " + rendaFamiliar);
        System.out.println("Animais Cadastrados: " + animaisCadastrados);
    }

    // MÉTODO PARA SOLICITAR CONSULTA
    public void solicitarConsulta(){
        System.out.println("O Tutor " + getNome() + " solicitou um Atendimento Solidário.");
    }

    //MÉTODO PARA CADASTRAR O ANIMAL
    public void cadastrarAnimal(Animal animal) {
        System.out.println("O Tutor " + getNome() + " cadastrou o animal: " + animal.getNome()); 
    }

    //POLIMORFISMO POR SOBRECARGA
    //MÉTODO PARA ATUALIZAR DADOS ESPECÍFICOS DO TUTOR
    public void atualizarDados(String telefone, String endereco, String novosAnimaisCadastrados) {
        super.atualizarDados(telefone, endereco); // Atualiza telefone e endereço básicos
        this.animaisCadastrados = novosAnimaisCadastrados; // Atualiza a lista de animais do tutor
        System.out.println("Dados e animais cadastrados do tutor atualizados com sucesso!");
    }
}
