package repository;

import model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private List<Professor> professores = new ArrayList<>();

    public void salvar(Professor professor) {
        professores.add(professor);
    }

    public List<Professor> listarTodos() {
        return professores;
    }

    public Professor buscarPorRegistro(String registro) {
        for (Professor p : professores) {
            if (p.getRegistro().equals(registro)) {
                return p;
            }
        }
        return null;
    }

    public boolean remover(String registro) {
        return professores.removeIf(p -> p.getRegistro().equals(registro));
    }
}
