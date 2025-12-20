package model;

public class Administrador extends Usuario {

    public Administrador(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public String gerarRelatorio() {
        return "Relatório Administrador: " + getNome() + " | Login: " + getLogin();
    }
}
