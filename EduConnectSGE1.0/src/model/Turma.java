package model;

import java.util.*;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;
    private Map<String, List<Avaliacao>> avaliacoesPorMatricula; // matricula -> avaliações

    public Turma(String codigo, Professor professor, Curso curso) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("Código da turma inválido");
        if (professor == null) throw new IllegalArgumentException("Professor obrigatório");
        if (curso == null) throw new IllegalArgumentException("Curso obrigatório");
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
        this.avaliacoesPorMatricula = new HashMap<>();
    }

    public String getCodigo() { return codigo; }
    public Professor getProfessor() { return professor; }
    public Curso getCurso() { return curso; }
    public List<Aluno> getListaAlunos() { return Collections.unmodifiableList(listaAlunos); }

    public boolean adicionarAluno(Aluno aluno) {
        if (aluno == null) return false;
        if (listaAlunos.stream().anyMatch(a -> a.getMatricula().equals(aluno.getMatricula()))) return false;
        listaAlunos.add(aluno);
        avaliacoesPorMatricula.putIfAbsent(aluno.getMatricula(), new ArrayList<>());
        return true;
    }

    public boolean removerAlunoPorMatricula(String matricula) {
        if (matricula == null) return false;
        boolean removed = listaAlunos.removeIf(a -> a.getMatricula().equals(matricula));
        if (removed) avaliacoesPorMatricula.remove(matricula);
        return removed;
    }

    public String resumoTurma() {
        return "Turma " + codigo + " | Professor: " + professor.getNome() + " | Curso: " + curso.getNome() +
               " | Alunos matriculados: " + listaAlunos.size();
    }

    public void registrarAvaliacao(String matricula, Avaliacao avaliacao) {
        List<Avaliacao> lista = avaliacoesPorMatricula.get(matricula);
        if (lista == null) throw new IllegalArgumentException("Aluno não matriculado na turma");
        lista.add(avaliacao);
    }

    public List<Avaliacao> obterAvaliacoes(String matricula) {
        return Collections.unmodifiableList(avaliacoesPorMatricula.getOrDefault(matricula, List.of()));
    }
}
