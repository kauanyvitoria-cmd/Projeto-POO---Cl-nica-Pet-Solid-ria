public class Veterinario extends Pessoa{

    // ATRIBUTO PRÓPRIO (ENCAPSULAMENTO)
    private String registroProfissional;
    private String especialidade;
    private double salario;

    //CONSTRUTOR
    public Veterinario(String nome, String cpf, String telefone, String endereco, String registroProfissional, String especialidade) {
        super(nome, cpf, telefone, endereco);
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
        this.salario = 1621.00;
    }

    //GETTERS
    public String getespecialidade(){
        return especialidade;
    }
    public String getregistroProfissional(){
        return registroProfissional;
    }
    public double getsalario(){
        return salario;
    }

      //MÉTODOS
    // MÉTODO PARA REALIZAR O ATENDIMENTO
    public void realizarAtendimento(Animal animal) {
        System.out.println("O veterinário " + getNome() + " realizou o atendimento do animal " + animal.getNome() + "!");
    }

    //POLIMORFISMO
    //MÉTODO PARA EXIBIR DADOS DO VETERINÁRIO
    public void exibirDados() {
        System.out.println("-- Dados do Veterinário --");
       super.exibirDados();
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Registro Profissional: " + registroProfissional);
        System.out.println("Salário: " + salario);
    }
}
