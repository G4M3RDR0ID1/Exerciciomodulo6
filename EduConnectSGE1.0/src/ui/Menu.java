package ui;

import model.Aluno;
import model.Professor;
import model.Curso;
import model.CursoPresencial;
import model.CursoEAD;
import model.Turma;
import repository.AlunoRepository;
import repository.ProfessorRepository;
import repository.CursoRepository;
import repository.TurmaRepository;
import service.AlunoService;
import service.ProfessorService;
import service.CursoService;
import service.TurmaService;
import service.AvaliacaoService;

import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);

    private final AlunoService alunoService;
    private final ProfessorService professorService;
    private final CursoService cursoService;
    private final TurmaService turmaService;
    private final AvaliacaoService avaliacaoService;

    public Menu() {
        // Inicializa os repositórios
        AlunoRepository alunoRepo = new AlunoRepository();
        ProfessorRepository professorRepo = new ProfessorRepository();
        CursoRepository cursoRepo = new CursoRepository();
        TurmaRepository turmaRepo = new TurmaRepository();

        // Inicializa os serviços
        this.alunoService = new AlunoService(alunoRepo);
        this.professorService = new ProfessorService(professorRepo);
        this.cursoService = new CursoService(cursoRepo);
        this.turmaService = new TurmaService(turmaRepo);
        this.avaliacaoService = new AvaliacaoService();
    }

    public void iniciar() {
        int opc;
        do {
            mostrarMenu();
            opc = lerInt("Escolha: ");
            try {
                switch (opc) {
                    case 1 -> cadastrarAluno();
                    case 2 -> cadastrarProfessor();
                    case 3 -> cadastrarCurso();
                    case 4 -> criarTurma();
                    case 5 -> associarAlunoATurma();
                    case 6 -> registrarAvaliacao();
                    case 7 -> gerarRelatorios();
                    case 8 -> listarTurmas();
                    case 0 -> System.out.println("Saindo... Obrigado!");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opc != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n=== Sistema de Gestão Educacional ===");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Cadastrar Professor");
        System.out.println("3. Cadastrar Curso (Presencial/EAD)");
        System.out.println("4. Criar Turma");
        System.out.println("5. Associar Aluno à Turma");
        System.out.println("6. Registrar Avaliação");
        System.out.println("7. Gerar Relatórios");
        System.out.println("8. Listar Turmas");
        System.out.println("0. Sair");
    }

    private void cadastrarAluno() {
        System.out.println("\nCadastro de Aluno");
        String nome = lerString("Nome: ");
        String login = lerString("Login: ");
        String senha = lerString("Senha: ");
        String matricula = lerString("Matrícula: ");
        String cursoMatriculado = lerString("Curso: ");
        Aluno a = new Aluno(nome, login, senha, matricula, cursoMatriculado);
        alunoService.cadastrar(a);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private void cadastrarProfessor() {
        System.out.println("\nCadastro de Professor");
        String nome = lerString("Nome: ");
        String login = lerString("Login: ");
        String senha = lerString("Senha: ");
        String especialidade = lerString("Especialidade: ");
        String registro = lerString("Registro: ");
        Professor p = new Professor(nome, login, senha, especialidade, registro);
        professorService.cadastrar(p);
        System.out.println("Professor cadastrado com sucesso!");
    }

    private void cadastrarCurso() {
        System.out.println("\nCadastro de Curso");
        String tipo = lerString("Tipo (P para Presencial / E para EAD): ").toUpperCase();
        String nome = lerString("Nome: ");
        String codigo = lerString("Código: ");
        int ch = lerInt("Carga horária: ");
        Curso c;
        if ("P".equals(tipo)) {
            String sala = lerString("Sala de aula: ");
            c = new CursoPresencial(nome, codigo, ch, sala);
        } else {
            String plataforma = lerString("Plataforma: ");
            c = new CursoEAD(nome, codigo, ch, plataforma);
        }
        cursoService.cadastrar(c);
        System.out.println("Curso cadastrado com sucesso!");
    }

    private void criarTurma() {
        System.out.println("\nCriação de Turma");
        String codigoTurma = lerString("Código da turma: ");
        String codigoCurso = lerString("Código do curso: ");
        String registroProf = lerString("Registro do professor: ");

        Curso curso = cursoService.buscar(codigoCurso);
        Professor professor = professorService.buscar(registroProf);

        if (curso == null || professor == null) {
            System.out.println("Curso ou professor não encontrado!");
            return;
        }

        Turma t = new Turma(codigoTurma, professor, curso);
        turmaService.criarTurma(t);
        System.out.println("Turma criada com sucesso!");
    }

    private void associarAlunoATurma() {
        System.out.println("\nAssociação de Aluno à Turma");
        String codigoTurma = lerString("Código da turma: ");
        String matricula = lerString("Matrícula do aluno: ");
        Aluno a = alunoService.buscar(matricula);
        if (a == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        boolean ok = turmaService.adicionarAluno(codigoTurma, a);
        System.out.println(ok ? "Aluno associado com sucesso!" : "Aluno já está na turma.");
    }

    private void registrarAvaliacao() {
        System.out.println("\nRegistro de Avaliação");
        String codigoTurma = lerString("Código da turma: ");
        String matricula = lerString("Matrícula do aluno: ");
        String descricao = lerString("Descrição da avaliação: ");
        double nota = lerDouble("Nota (0 a 10): ");

        Turma t = turmaService.buscar(codigoTurma);
        if (t == null) {
            System.out.println("Turma não encontrada!");
            return;
        }

        avaliacaoService.registrarNota(t, matricula, descricao, nota);
        System.out.println("Avaliação registrada com sucesso!");
    }

    private void gerarRelatorios() {
        System.out.println("\n--- Relatórios ---");
        alunoService.listar().forEach(a -> System.out.println(a.gerarRelatorio()));
        professorService.listar().forEach(p -> System.out.println(p.gerarRelatorio()));
        cursoService.listar().forEach(c -> System.out.println(c.gerarRelatorio()));
    }

    private void listarTurmas() {
        System.out.println("\n--- Turmas ---");
        turmaService.listar().forEach(t -> System.out.println(t.resumoTurma()));
    }

    // Métodos auxiliares para leitura
    private String lerString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    private int lerInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine());
    }

    private double lerDouble(String msg) {
        System.out.print(msg);
        return Double.parseDouble(sc.nextLine());
    }
}
