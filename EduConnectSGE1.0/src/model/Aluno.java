package model;

public class Aluno extends Usuario {
    private String matricula;
    private String curso; 

    public Aluno(String nome, String login, String senha, String matricula, String curso) {
        super(nome, login, senha);
        if (matricula == null || matricula.isBlank()) throw new IllegalArgumentException("Matrícula inválida");
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() { return matricula; }
    public String getCurso() { return curso; }

    public String gerarRelatorio() {
        return "Relatório Aluno: " + getNome() + " | Matrícula: " + matricula + " | Curso: " + curso;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome='" + getNome() + '\'' + ", matricula='" + matricula + '\'' + ", curso='" + curso + '\'' + '}';
    }
}
