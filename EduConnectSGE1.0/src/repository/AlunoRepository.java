package repository;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunos;
    }

    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public boolean remover(String matricula) {
        return alunos.removeIf(a -> a.getMatricula().equals(matricula));
    }
}
