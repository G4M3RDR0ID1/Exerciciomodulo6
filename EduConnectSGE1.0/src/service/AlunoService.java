package service;

import model.Aluno;
import repository.AlunoRepository;
import java.util.List;

public class AlunoService {
    private final AlunoRepository repo;

    public AlunoService(AlunoRepository repo) {
        this.repo = repo;
    }

    public void cadastrar(Aluno aluno) {
        repo.salvar(aluno);
    }

    public Aluno buscar(String matricula) {
        return repo.buscarPorMatricula(matricula);
    }

    public boolean remover(String matricula) {
        return repo.remover(matricula);
    }

    public List<Aluno> listar() {
        return repo.listarTodos();
    }
}
