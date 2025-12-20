package model;

public class CursoPresencial extends Curso {
    private String salaDeAula;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String salaDeAula) {
        super(nome, codigo, cargaHoraria);
        if (salaDeAula == null || salaDeAula.isBlank()) throw new IllegalArgumentException("Sala de aula inválida");
        this.salaDeAula = salaDeAula;
    }

    public String getSalaDeAula() { return salaDeAula; }

    @Override
    public String detalharCurso() {
        return super.detalharCurso() + " | Tipo: Presencial | Sala: " + salaDeAula;
    }
}
