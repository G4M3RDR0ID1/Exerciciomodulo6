package repository;

import model.Curso;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();

    public void salvar(Curso curso) {
        cursos.add(curso);
    }

    public List<Curso> listarTodos() {
        return cursos;
    }

    public Curso buscarPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    public boolean remover(String codigo) {
        return cursos.removeIf(c -> c.getCodigo().equals(codigo));
    }
}
