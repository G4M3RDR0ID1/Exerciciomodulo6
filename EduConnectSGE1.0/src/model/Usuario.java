package model;

public abstract class Usuario implements Autenticacao {
    private String nome;
    private String login;
    private String senha;

    protected Usuario(String nome, String login, String senha) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido");
        if (login == null || login.isBlank()) throw new IllegalArgumentException("Login inválido");
        if (senha == null || senha.isBlank()) throw new IllegalArgumentException("Senha inválida");
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public String getLogin() { return login; }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
}
