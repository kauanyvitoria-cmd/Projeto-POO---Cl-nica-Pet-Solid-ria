import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US);

        // Listas dinâmicas para armazenamento em tempo de execução
        ArrayList<Tutor> listaTutores = new ArrayList<>();
        ArrayList<Animal> listaAnimais = new ArrayList<>();
        ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();
        ArrayList<Consulta> listaConsultas = new ArrayList<>();
        ArrayList<Procedimento> listaProcedimentos = new ArrayList<>();
        ArrayList<String> donosDosAnimais = new ArrayList<>();


        // Pré-cadastrado os procedimentos padrões da clínica com os preços solidários
        listaProcedimentos.add(new Procedimento("Banho", "Higienização completa do pet", 0.5, true));
        listaProcedimentos.add(new Procedimento("Tosa", "Tosa higiênica e estética", 0.5, true));
        listaProcedimentos.add(new Procedimento("Vacina", "Imunização antirrábica/polivalente", 1.0, true));
        listaProcedimentos.add(new Procedimento("Castração", "Cirurgia de esterilização", 1.0, true));

        int opcao = -1;

        do {
            System.out.println("\n==========================================");
            System.out.println("   BICHÔ | SISTEMA DE CLÍNICA SOLIDÁRIA     ");
            System.out.println("==========================================");
            System.out.println("1. Cadastrar Tutor");
            System.out.println("2. Cadastrar Animal");
            System.out.println("3. Cadastrar Veterinário");
            System.out.println("4. Listar Procedimentos e Preços");
            System.out.println("5. Atualizar Dados (Tutor, Animal ou Veterinário)");
            System.out.println("6. Marcar Consulta");
            System.out.println("7. Consultar Cadastros (Tutores, Animais e Vets)");
            System.out.println("8. Gerenciar Consultas (Alterar Horário / Cancelar)");
            System.out.println("9. Realizar Atendimento e Registrar Histórico do Pet");
            System.out.println("10. Consultar Histórico do Animal");
            System.out.println("11. Cadastrar Novo Procedimento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        System.out.println("\n--- CADASTRO DE TUTOR ---");
                        System.out.print("Nome: ");
                        String nomeTutor = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = scanner.nextLine();
                        
                        // O sistema gera o código automaticamente
                        int codigoTutor = listaTutores.size() + 1;
                        System.out.println("Código do Tutor gerado: " + codigoTutor);

                        System.out.print("Renda Familiar (Custo Social): ");
                        double renda = scanner.nextDouble();
                        scanner.nextLine(); // limpar buffer

                        // Criando o tutor
                        Tutor novoTutor = new Tutor(nomeTutor, cpf, telefone, endereco, codigoTutor, renda, "Nenhum");
                        listaTutores.add(novoTutor);
                        System.out.println("Tutor cadastrado com sucesso!");
                        break;
        

                    case 2:
                        if (listaTutores.isEmpty()) {
                            System.out.println("\n[Aviso] Cadastre um tutor primeiro antes de cadastrar um animal!");
                            break;
                        }
                        System.out.println("\n--- CADASTRO DE ANIMAL ---");
                        
                        // Escolher de quem é o animal
                        System.out.println("Selecione o tutor responsável por este animal:");
                        for (int i = 0; i < listaTutores.size(); i++) {
                            System.out.println(i + " - " + listaTutores.get(i).getNome());
                        }
                        System.out.print("Número do tutor: ");
                        int idxDono = scanner.nextInt();
                        scanner.nextLine();

                        if (idxDono < 0 || idxDono >= listaTutores.size()) {
                            System.out.println("Tutor inválido! Cadastro cancelado.");
                            break;
                        }

                        Tutor donoSelecionado = listaTutores.get(idxDono);

                        System.out.print("Nome do Animal: ");
                        String nomeAnimal = scanner.nextLine();
                        
                        System.out.println("Escolha a espécie:");
                        System.out.println("1 - Cão");
                        System.out.println("2 - Gato");
                        System.out.print("Opção: ");
                        int opEspecie = scanner.nextInt();
                        scanner.nextLine();
                        
                        String especie = (opEspecie == 1) ? "Cão" : (opEspecie == 2) ? "Gato" : "Outro";

                        System.out.print("Raça: ");
                        String raca = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Observações: ");
                        String obs = scanner.nextLine();

                        Animal novoAnimal = new Animal(nomeAnimal, especie, raca, idade, obs, donoSelecionado.getNome());
                        listaAnimais.add(novoAnimal);
                        donosDosAnimais.add(donoSelecionado.getNome()); // Salva o dono na lista paralela
                        
                        // Sincroniza e atualiza o texto de animais cadastrados DENTRO do objeto Tutor
                        String atuais = donoSelecionado.getanimaisCadastrados();
                        if (atuais == null || atuais.isEmpty() || atuais.equalsIgnoreCase("nenhum")) {
                            donoSelecionado.setanimaisCadastrados(nomeAnimal);
                        } else {
                            donoSelecionado.setanimaisCadastrados(atuais + ", " + nomeAnimal);
                        }

                        donoSelecionado.cadastrarAnimal(novoAnimal);
                        System.out.println("Animal cadastrado e vinculado com sucesso ao tutor " + donoSelecionado.getNome() + "!");
                        break;

                    case 3:
                        System.out.println("\n--- CADASTRO DE VETERINÁRIO ---");
                        System.out.print("Nome do Veterinário: ");
                        String nomeVet = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpfVet = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telVet = scanner.nextLine();
                        System.out.print("Endereço: ");
                        String endVet = scanner.nextLine();
                        System.out.print("Registro Profissional (CRMV): ");
                        String crmv = scanner.nextLine();
                        System.out.print("Especialidade: ");
                        String especialidade = scanner.nextLine();

                        Veterinario novoVet = new Veterinario(nomeVet, cpfVet, telVet, endVet, crmv, especialidade);
                        listaVeterinarios.add(novoVet);
                        System.out.println("Veterinário cadastrado com sucesso!");
                        break;

                   case 4:
                        System.out.println("\n--- TABELA DE PROCEDIMENTOS E PREÇOS ---");
                        for (Procedimento p : listaProcedimentos) {
                            // Imprime diretamente os dados usando os gets da classe Procedimento
                            System.out.println("Procedimento: " + p.getNomeProcedimento() + " | Descrição: " + p.getDescricao() + " | Custo Social: R$ " + p.getcustoSocial());
                            System.out.println("------------------------------------------");
                        }
                        break;

                    case 5:
                            System.out.println("\n--- ATUALIZAR DADOS ---");
                            System.out.println("O que deseja atualizar?");
                            System.out.println("1. Dados de um Tutor");
                            System.out.println("2. Dados de um Animal");
                            System.out.println("3. Dados de um Veterinário");
                            System.out.println("4. Atualizar Custo Social de Procedimento");
                            System.out.print("Escolha: ");
                            int tipoAtualizacao = scanner.nextInt();
                            scanner.nextLine();

                            if (tipoAtualizacao == 1) {
                                if (listaTutores.isEmpty()) {
                                    System.out.println("Nenhum tutor cadastrado.");
                                    break;
                                }
                                System.out.println("\nEscolha o tutor pelo número:");
                                for (int i = 0; i < listaTutores.size(); i++) {
                                    System.out.println(i + " - " + listaTutores.get(i).getNome());
                                }
                                System.out.print("Número do tutor: ");
                                int idxTutor = scanner.nextInt();
                                scanner.nextLine();

                                if (idxTutor >= 0 && idxTutor < listaTutores.size()) {
                                    Tutor t = listaTutores.get(idxTutor);
                                    System.out.print("Novo telefone: ");
                                    String novoTel = scanner.nextLine();
                                    System.out.print("Novo endereço: ");
                                    String novoEnd = scanner.nextLine();
                                    System.out.println("Novos animais Cadastrados: ");
                                    String novosAnimais = scanner.nextLine();
                                    t.atualizarDados(novoTel, novoEnd, novosAnimais);
                                    System.out.println("Dados do tutor atualizados com sucesso!");
                                } else {
                                    System.out.println("Tutor inválido.");
                                }

                            } else if (tipoAtualizacao == 2) {
                                if (listaAnimais.isEmpty()) {
                                    System.out.println("Nenhum animal cadastrado.");
                                    break;
                                }
                                System.out.println("\nEscolha o animal pelo número:");
                                for (int i = 0; i < listaAnimais.size(); i++) {
                                    System.out.println(i + " - " + listaAnimais.get(i).getNome() + " (" + listaAnimais.get(i).getEspecie() + ")");
                                }
                                System.out.print("Número do animal: ");
                                int idxAnimal = scanner.nextInt();
                                scanner.nextLine();

                                if (idxAnimal >= 0 && idxAnimal < listaAnimais.size()) {
                                    Animal a = listaAnimais.get(idxAnimal);
                                    System.out.print("Novo nome: ");
                                    String novoNome = scanner.nextLine();
                                    System.out.print("Nova espécie: ");
                                    String novaEsp = scanner.nextLine();
                                    System.out.print("Nova raça: ");
                                    String novaRaca = scanner.nextLine();
                                    System.out.print("Nova idade: ");
                                    int novaIdade = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Novas observações: ");
                                    String novasObs = scanner.nextLine();

                                    a.atualizarDadosAnimal(novoNome, novaEsp, novaRaca, novaIdade, novasObs);
                                    System.out.println("Dados do animal atualizados com sucesso!");
                                } else {
                                    System.out.println("Animal inválido.");
                                }

                            } else if (tipoAtualizacao == 3) {
                                if (listaVeterinarios.isEmpty()) {
                                    System.out.println("Nenhum veterinário cadastrado.");
                                    break;
                                }
                                System.out.println("\nEscolha o veterinário pelo número:");
                                for (int i = 0; i < listaVeterinarios.size(); i++) {
                                    System.out.println(i + " - " + listaVeterinarios.get(i).getNome());
                                }
                                System.out.print("Número do veterinário: ");
                                int idxVetUpdate = scanner.nextInt();
                                scanner.nextLine();

                                if (idxVetUpdate >= 0 && idxVetUpdate < listaVeterinarios.size()) {
                                    Veterinario vetEscolhido = listaVeterinarios.get(idxVetUpdate);
                                    System.out.print("Novo telefone: ");
                                    String novoTelVet = scanner.nextLine();
                                    System.out.print("Novo endereço: ");
                                    String novoEndVet = scanner.nextLine();
                                    
                                    vetEscolhido.atualizarDados(novoTelVet, novoEndVet);
                                    System.out.println("Dados do veterinário atualizados com sucesso!");
                                } else {
                                    System.out.println("Veterinário inválido.");
                                }

                            } else if (tipoAtualizacao == 4) {
                                if (listaProcedimentos.isEmpty()) {
                                    System.out.println("Nenhum procedimento cadastrado.");
                                    break;
                                }
                                System.out.println("\n--- ATUALIZAR CUSTO SOCIAL ---");
                                for (int i = 0; i < listaProcedimentos.size(); i++) {
                                    Procedimento p = listaProcedimentos.get(i);
                                    System.out.println(i + " - " + p.getNomeProcedimento() + " (Atual: R$ " + p.getcustoSocial() + ")");
                                }
                                System.out.print("Escolha o número do procedimento: ");
                                int idxProc = scanner.nextInt();
                                scanner.nextLine();

                                if (idxProc >= 0 && idxProc < listaProcedimentos.size()) {
                                    Procedimento procEscolhido = listaProcedimentos.get(idxProc);

                                    System.out.print("Digite o novo custo social: ");
                                    double novoValor = scanner.nextDouble();
                                    scanner.nextLine();

                                    procEscolhido.atualizarCustoSocial(novoValor);
                                    System.out.println("[Sucesso] Custo social atualizado com sucesso!");
                                } else {
                                    System.out.println("Procedimento inválido.");
                                }

                            } else {
                                System.out.println("Opção inválida.");
                            }
                            break;

                   case 6:
                    System.out.println("\n--- MARCAR CONSULTA ---");
                    if (listaTutores.isEmpty() || listaAnimais.isEmpty() || listaVeterinarios.isEmpty() || listaProcedimentos.isEmpty()) {
                        System.out.println("[Aviso] É necessário ter ao menos 1 Tutor, 1 Animal, 1 Veterinário e 1 Procedimento cadastrados!");
                        break;
                    }

                    // 1. Selecionar o Tutor
                    System.out.println("\nSelecione o Tutor:");
                    for (int i = 0; i < listaTutores.size(); i++) {
                        System.out.println(i + " - " + listaTutores.get(i).getNome());
                    }
                    System.out.print("Número do tutor: ");
                    int idxTutor = scanner.nextInt();
                    scanner.nextLine();

                    if (idxTutor < 0 || idxTutor >= listaTutores.size()) {
                        System.out.println("Tutor inválido!");
                        break;
                    }
                    Tutor tutorEscolhido = listaTutores.get(idxTutor);

                    // 2. Filtrar e exibir APENAS os animais deste tutor
                    ArrayList<Integer> indicesAnimaisDoTutor = new ArrayList<>();
                    System.out.println("\n--- ANIMAIS DE " + tutorEscolhido.getNome().toUpperCase() + " ---");
                    
                    for (int i = 0; i < listaAnimais.size(); i++) {
                        String donoDoAnimal = (i < donosDosAnimais.size()) ? donosDosAnimais.get(i) : "";
                        if (donoDoAnimal.equals(tutorEscolhido.getNome())) {
                            indicesAnimaisDoTutor.add(i); // Guarda a posição real na lista geral
                            int opcaoVisual = indicesAnimaisDoTutor.size() - 1; // Índice sequencial para o usuário (0, 1, 2...)
                            Animal a = listaAnimais.get(i);
                            System.out.println(opcaoVisual + " - " + a.getNome() + " (" + a.getEspecie() + " - " + a.getRaca() + ")");
                        }
                    }

                    if (indicesAnimaisDoTutor.isEmpty()) {
                        System.out.println("[Aviso] Este tutor não possui nenhum animal cadastrado. Cadastre um animal para ele primeiro!");
                        break;
                    }

                    System.out.print("Número do animal escolhido: ");
                    int escolhaPet = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaPet < 0 || escolhaPet >= indicesAnimaisDoTutor.size()) {
                        System.out.println("Opção de animal inválida!");
                        break;
                    }

                    // Pega o índice real do animal na lista global
                    int idxAnimalReal = indicesAnimaisDoTutor.get(escolhaPet);
                    Animal animalEscolhido = listaAnimais.get(idxAnimalReal);

                    // 3. Selecionar o Veterinário
                    System.out.println("\nSelecione o Veterinário:");
                    for (int i = 0; i < listaVeterinarios.size(); i++) {
                        System.out.println(i + " - " + listaVeterinarios.get(i).getNome());
                    }
                    System.out.print("Número do veterinário: ");
                    int idxVet = scanner.nextInt();
                    scanner.nextLine();

                    if (idxVet < 0 || idxVet >= listaVeterinarios.size()) {
                        System.out.println("Veterinário inválido!");
                        break;
                    }

                    // 4. Selecionar o Procedimento
                    System.out.println("\nSelecione o Procedimento:");
                    for (int i = 0; i < listaProcedimentos.size(); i++) {
                        Procedimento p = listaProcedimentos.get(i);
                        System.out.println(i + " - " + p.getNomeProcedimento() + " | R$ " + p.getcustoSocial());
                    }
                    System.out.print("Número do procedimento: ");
                    int idxProc = scanner.nextInt();
                    scanner.nextLine();

                    if (idxProc < 0 || idxProc >= listaProcedimentos.size()) {
                        System.out.println("Procedimento inválido!");
                        break;
                    }

                    // 5. Data e Horário
                    System.out.print("Data da consulta (DD/MM/AAAA): ");
                    String data = scanner.nextLine();
                    System.out.print("Horário (HH:MM): ");
                    String horario = scanner.nextLine();

                    // Criando e salvando a consulta com os objetos corretos
                    Consulta novaConsulta = new Consulta(data, horario, tutorEscolhido, animalEscolhido, listaVeterinarios.get(idxVet), listaProcedimentos.get(idxProc));
                    listaConsultas.add(novaConsulta);
                    
                    System.out.println("\n[Sucesso] Consulta agendada para o pet " + animalEscolhido.getNome() + " com o(a) Dr(a). " + listaVeterinarios.get(idxVet).getNome() + "!");
                    break;

                    case 7:
                        System.out.println("\n--- CONSULTAR CADASTROS ---");
                        
                        if (listaTutores.isEmpty()) {
                            System.out.println("Nenhum tutor cadastrado.");
                        } else {
                            System.out.println("== TUTORES ==");
                            for (Tutor t : listaTutores) {
                                t.consultarCadastro();
                                System.out.println("-------------------------");
                            }
                        }

                        if (listaAnimais.isEmpty()) {
                            System.out.println("Nenhum animal cadastrado.");
                        } else {
                            System.out.println("\n== ANIMAIS E TUTORES RESPONSÁVEIS ==");
                            for (int i = 0; i < listaAnimais.size(); i++) {
                                Animal a = listaAnimais.get(i);
                                String nomeDonoReal = (i < donosDosAnimais.size()) ? donosDosAnimais.get(i) : "Não vinculado";
                                
                                System.out.println("Animal: " + a.getNome());
                                System.out.println("Espécie: " + a.getEspecie() + " | Raça: " + a.getRaca() + " | Idade: " + a.getIdade() + " anos");
                                System.out.println("Tutor Responsável: " + nomeDonoReal);
                                System.out.println("Observações: " + a.getObservacoes());
                                System.out.println("-------------------------");
                            }
                        }

                        if (listaVeterinarios.isEmpty()) {
                            System.out.println("Nenhum veterinário cadastrado.");
                        } else {
                            System.out.println("\n== VETERINÁRIOS ==");
                            for (Veterinario v : listaVeterinarios) {
                                v.exibirDados();
                                System.out.println("-------------------------");
                            }
                        }
                        break;
                        

                    case 8:
                        if (listaConsultas.isEmpty()) {
                            System.out.println("\n[Aviso] Nenhuma consulta agendada no momento.");
                            break;
                        }
                        System.out.println("\n--- GERENCIAR CONSULTAS ---");
                        for (int i = 0; i < listaConsultas.size(); i++) {
                            System.out.println("Consulta [" + i + "]");
                            listaConsultas.get(i).consultarConsulta();
                            System.out.println("-------------------------");
                        }
                        
                        System.out.print("Digite o número da consulta que deseja gerenciar: ");
                        int idxConsulta = scanner.nextInt();
                        scanner.nextLine();

                        if (idxConsulta >= 0 && idxConsulta < listaConsultas.size()) {
                            Consulta c = listaConsultas.get(idxConsulta);
                            System.out.println("\n1. Alterar Horário");
                            System.out.println("2. Cancelar Consulta");
                            System.out.println("3. Não ALterar Nada!");
                            System.out.print("Escolha: ");
                            int subOpcao = scanner.nextInt();
                            scanner.nextLine();

                            if (subOpcao == 1) {
                                System.out.print("Nova Data (DD/MM/AAAA): ");
                                String novaData = scanner.nextLine();
                                System.out.print("Novo Horário (HH:MM): ");
                                String novoHorario = scanner.nextLine();
                                c.alterarHorario(novaData, novoHorario);
                            } else if (subOpcao == 2) {
                                c.cancelarConsulta();
                            } else if (subOpcao == 3) {
                                System.out.println("Retornando ao menu. Nenhuma alteração realizada.");
                            } else {
                                System.out.println("Opção inválida.");
                            }
                        } else {
                            System.out.println("Consulta inválida.");
                        }
                        break;

                    case 9:
                        System.out.println("\n--- ATENDIMENTO VETERINÁRIO E HISTÓRICO ---");
                        if (listaAnimais.isEmpty() || listaVeterinarios.isEmpty() || listaProcedimentos.isEmpty()) {
                            System.out.println("\n[Aviso] É necessário ter ao menos 1 Animal, 1 Veterinário e 1 Procedimento cadastrados!");
                            break;
                        }

                        // 1. Escolher o Animal que está sendo atendido
                        System.out.println("\nSelecione o Animal para atendimento:");
                        for (int i = 0; i < listaAnimais.size(); i++) {
                            Animal a = listaAnimais.get(i);
                            System.out.println(i + " - " + a.getNome() + " (" + a.getEspecie() + ")");
                        }
                        System.out.print("Número do animal: ");
                        int idxAnimalAtend = scanner.nextInt();
                        scanner.nextLine();

                        if (idxAnimalAtend < 0 || idxAnimalAtend >= listaAnimais.size()) {
                            System.out.println("Animal inválido!");
                            break;
                        }
                        Animal petAtendimento = listaAnimais.get(idxAnimalAtend);

                        // 2. Escolher o Veterinário responsável
                        System.out.println("\nSelecione o Veterinário:");
                        for (int i = 0; i < listaVeterinarios.size(); i++) {
                            System.out.println(i + " - " + listaVeterinarios.get(i).getNome());
                        }
                        System.out.print("Número do veterinário: ");
                        int idxVetAtend = scanner.nextInt();
                        scanner.nextLine();

                        if (idxVetAtend < 0 || idxVetAtend >= listaVeterinarios.size()) {
                            System.out.println("Veterinário inválido!");
                            break;
                        }
                        Veterinario vetAtendimento = listaVeterinarios.get(idxVetAtend);

                        // 3. Escolher o Procedimento realizado (Ex: Castração, Vacina, etc.)
                        System.out.println("\nSelecione o Procedimento realizado:");
                        for (int i = 0; i < listaProcedimentos.size(); i++) {
                            Procedimento p = listaProcedimentos.get(i);
                            System.out.println(i + " - " + p.getNomeProcedimento() + " | R$ " + p.getcustoSocial());
                        }
                        System.out.print("Número do procedimento: ");
                        int idxProcAtend = scanner.nextInt();
                        scanner.nextLine();

                        if (idxProcAtend < 0 || idxProcAtend >= listaProcedimentos.size()) {
                            System.out.println("Procedimento inválido!");
                            break;
                        }
                        Procedimento procRealizado = listaProcedimentos.get(idxProcAtend);

                        // 4. Executar as ações e SALVAR no histórico do animal
                        vetAtendimento.realizarAtendimento(petAtendimento);
                     
                        // ESSA É A LINHA QUE SALVA O REGISTRO PARA APARECER NA OPÇÃO 10:
                        petAtendimento.cadastrarProcedimentoRealizado(procRealizado);
                        
                        System.out.println("\n[Sucesso] Atendimento de " + procRealizado.getNomeProcedimento() + " registrado e salvo para o pet " + petAtendimento.getNome() + "!");
                        break;

                    case 10:
                        System.out.println("\n--- HISTÓRICO DE ATENDIMENTOS DO ANIMAL ---");
                        if (listaAnimais.isEmpty()) {
                            System.out.println("Nenhum animal cadastrado no sistema.");
                            break;
                        }

                        // 1. Listar os animais disponíveis
                        System.out.println("Escolha o animal para ver o histórico:");
                        for (int i = 0; i < listaAnimais.size(); i++) {
                            Animal a = listaAnimais.get(i);
                            System.out.println(i + " - " + a.getNome() + " (" + a.getEspecie() + ")");
                        }
                        System.out.print("Número do animal: ");
                        int idxHistAnimal = scanner.nextInt();
                        scanner.nextLine(); // limpar buffer

                        if (idxHistAnimal < 0 || idxHistAnimal >= listaAnimais.size()) {
                            System.out.println("Animal inválido!");
                            break;
                        }

                        Animal animalHistorico = listaAnimais.get(idxHistAnimal);

                        // 2. Chamar o método de histórico do próprio animal
                        System.out.println("\n------------------------------------------");
                        System.out.println("Histórico do pet: " + animalHistorico.getNome());
                        animalHistorico.consultarHistorico();
                        System.out.println("------------------------------------------");
                        break;

                    case 11:
                        System.out.println("\n--- CADASTRAR NOVO PROCEDIMENTO ---");
                        System.out.print("Nome do procedimento: ");
                        String nomeProc = scanner.nextLine();
    
                        System.out.print("Descrição do procedimento: ");
                        String descProc = scanner.nextLine();
    
                        System.out.print("Custo social (ex: 50.0): ");
                        double custoProc = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer do teclado
    
                        System.out.print("Está disponível? (true/false): ");
                        boolean dispProc = scanner.nextBoolean();
                        scanner.nextLine(); // Limpar o buffer do teclado

                        // Cria o novo procedimento passando os dados para o construtor
                        Procedimento novoProc = new Procedimento(nomeProc, descProc, custoProc, dispProc);
    
                        // Adiciona na lista global de procedimentos da clínica
                        listaProcedimentos.add(novoProc);
    
                        System.out.println("[Sucesso] Procedimento '" + nomeProc + "' cadastrado e adicionado à lista!");
                        break;

                    case 0:
                        System.out.println("\nSaindo do sistema... Obrigado por utilizar o Sistema Bichô (Equipe NEXUS)!");
                        break;

                    default:
                        System.out.println("\nOpção inválida! Escolha um número entre 0 e 10.");
                }
            } else {
                System.out.println("\nEntrada inválida! Por favor, digite um número inteiro.");
                scanner.next();
            }

        } while (opcao != 0);

        scanner.close();
    }
}