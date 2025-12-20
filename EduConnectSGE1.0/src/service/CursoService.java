package service;

import model.Curso;
import repository.CursoRepository;
import java.util.List;

public class CursoService {
    private final CursoRepository repo;

    public CursoService(CursoRepository repo) {
        this.repo = repo;
    }

    public void cadastrar(Curso curso) {
        repo.salvar(curso);
    }

    public Curso buscar(String codigo) {
        return repo.buscarPorCodigo(codigo);
    }

    public boolean remover(String codigo) {
        return repo.remover(codigo);
    }

    public List<Curso> listar() {
        return repo.listarTodos();
    }
}
