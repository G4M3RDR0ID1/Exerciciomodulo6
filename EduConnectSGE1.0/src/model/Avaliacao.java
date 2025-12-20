package model;

public class Avaliacao {
    private double nota;     // 0 a 10
    private String descricao;

    public Avaliacao(String descricao) {
        if (descricao == null || descricao.isBlank()) throw new IllegalArgumentException("Descrição inválida");
        this.descricao = descricao;
        this.nota = -1.0; // não atribuída
    }

    public String getDescricao() { return descricao; }
    public double getNota() { return nota; }

    public void atribuirNota(double valor) {
        if (valor < 0.0 || valor > 10.0) throw new IllegalArgumentException("Nota deve estar entre 0 e 10");
        this.nota = valor;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "descricao='" + descricao + '\'' + ", nota=" + (nota < 0 ? "NA" : nota) + '}';
    }
}
