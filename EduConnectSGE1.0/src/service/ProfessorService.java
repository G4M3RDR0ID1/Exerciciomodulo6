package service;

import model.Professor;
import repository.ProfessorRepository;
import java.util.List;

public class ProfessorService {
    private final ProfessorRepository repo;

    public ProfessorService(ProfessorRepository repo) {
        this.repo = repo;
    }

    public void cadastrar(Professor professor) {
        repo.salvar(professor);
    }

    public Professor buscar(String registro) {
        return repo.buscarPorRegistro(registro);
    }

    public boolean remover(String registro) {
        return repo.remover(registro);
    }

    public List<Professor> listar() {
        return repo.listarTodos();
    }
}
