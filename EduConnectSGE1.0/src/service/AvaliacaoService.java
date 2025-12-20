package service;

import model.Avaliacao;
import model.Turma;

public class AvaliacaoService {
    public void registrarNota(Turma turma, String matricula, String descricao, double nota) {
        if (turma == null) throw new IllegalArgumentException("Turma obrigatória");
        Avaliacao av = new Avaliacao(descricao);
        av.atribuirNota(nota);
        turma.registrarAvaliacao(matricula, av);
    }
}
