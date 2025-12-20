package model;

public class CursoEAD extends Curso {
    private String plataforma;

    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataforma) {
        super(nome, codigo, cargaHoraria);
        if (plataforma == null || plataforma.isBlank()) throw new IllegalArgumentException("Plataforma inválida");
        this.plataforma = plataforma;
    }

    public String getPlataforma() { return plataforma; }

    @Override
    public String detalharCurso() {
        return super.detalharCurso() + " | Tipo: EAD | Plataforma: " + plataforma;
    }
}
