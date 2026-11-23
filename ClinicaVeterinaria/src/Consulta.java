public class Consulta {

    // ATRIBUTOS (ENCAPSULAMENTO)
    private String data;
    private String horario;
    private String status;

    // ASSOCIAÇÕES COM OUTRAS CLASSES
    private Animal animal;
    private Tutor tutor;
    private Veterinario veterinario;
    private Procedimento procedimento;

    // CONSTRUTOR
    public Consulta(String data, String horario, Tutor tutor, Animal animal, Veterinario veterinario, Procedimento procedimento) {
        this.data = data;
        this.horario = horario;
        this.animal = animal;
        this.tutor = tutor;
        this.veterinario = veterinario;
        this.procedimento = procedimento;
        this.status = "Agendada";
    }

    // GETTERS E SETTERS
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Tutor getTutor() {
        return tutor;
    }
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    // MÉTODOS
    // MÉTODO MARCAR CONSULTA
    public void marcarConsulta() {
        status = "Agendada";
        
        System.out.println("Consulta agendada com sucesso!");
        System.out.println("Animal: " + animal.getNome());
        System.out.println("Tutor: " + tutor.getNome());
        System.out.println("Veterinário: " + veterinario.getNome());
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horario);
    }

    //MÉTODO CANCELAR CONSULTA
    public void cancelarConsulta() {
        if (status.equals("Agendada")) {
            status = "Cancelada";
            System.out.println("Consulta cancelada com sucesso!");
        } else {
            System.out.println("Não é possível cancelar esta consulta.");
        }
    }

    // MÉTODO ALTERAR HORÁRIO DA CONSULTA
    public void alterarHorario(String novaData, String novoHorario) {
        if (status.equals("Agendada")) {
            data = novaData;
            horario = novoHorario;

            System.out.println("Horário da consulta atualizado!");
        } else {
            System.out.println("Não é possível alterar uma consulta cancelada.");
        }
    }

    // CONSULTAR INFORMAÇÕES DA CONSULTA
    public void consultarConsulta() {
        System.out.println("-- DADOS DA CONSULTA --");
        System.out.println("Animal: " + animal.getNome());
        System.out.println("Tutor: " + tutor.getNome());
        System.out.println("Veterinário: " + veterinario.getNome());
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horario);
        System.out.println("Status: " + status);
    }
}