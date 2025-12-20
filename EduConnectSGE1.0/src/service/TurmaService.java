package service;

import model.Aluno;
import model.Turma;
import repository.TurmaRepository;
import java.util.List;

public class TurmaService {
    private final TurmaRepository repo;

    public TurmaService(TurmaRepository repo) {
        this.repo = repo;
    }

    public void criarTurma(Turma turma) {
        repo.salvar(turma);
    }

    public Turma buscar(String codigo) {
        return repo.buscarPorCodigo(codigo);
    }

    public boolean remover(String codigo) {
        return repo.remover(codigo);
    }

    public List<Turma> listar() {
        return repo.listarTodos();
    }

    public boolean adicionarAluno(String codigoTurma, Aluno aluno) {
        Turma t = repo.buscarPorCodigo(codigoTurma);
        if (t == null) throw new IllegalArgumentException("Turma não encontrada");
        return t.adicionarAluno(aluno);
    }

    public boolean removerAluno(String codigoTurma, String matricula) {
        Turma t = repo.buscarPorCodigo(codigoTurma);
        if (t == null) throw new IllegalArgumentException("Turma não encontrada");
        return t.removerAlunoPorMatricula(matricula);
    }
}
