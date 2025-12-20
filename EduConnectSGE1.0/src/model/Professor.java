package model;

public class Professor extends Usuario {
    private String especialidade;
    private String registro;

    public Professor(String nome, String login, String senha, String especialidade, String registro) {
        super(nome, login, senha);
        if (registro == null || registro.isBlank()) throw new IllegalArgumentException("Registro inválido");
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getEspecialidade() { return especialidade; }
    public String getRegistro() { return registro; }

    public String gerarRelatorio() {
        return "Relatório Professor: " + getNome() + " | Registro: " + registro + " | Especialidade: " + especialidade;
    }

    @Override
    public String toString() {
        return "Professor{" + "nome='" + getNome() + '\'' + ", registro='" + registro + '\'' + ", especialidade='" + especialidade + '\'' + '}';
    }
}
