package repository;

import model.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {
    private List<Turma> turmas = new ArrayList<>();

    public void salvar(Turma turma) {
        turmas.add(turma);
    }

    public List<Turma> listarTodos() {
        return turmas;
    }

    public Turma buscarPorCodigo(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equals(codigo)) {
                return t;
            }
        }
        return null;
    }

    public boolean remover(String codigo) {
        return turmas.removeIf(t -> t.getCodigo().equals(codigo));
    }
}
