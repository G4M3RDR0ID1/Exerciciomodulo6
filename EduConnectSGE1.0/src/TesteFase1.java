import model.Aluno;
import model.Professor;
import model.Curso;

public class TesteFase1 {
    public static void main(String[] args) {

        Aluno a = new Aluno(
            "Lucas Eduardo Silva Lana",
            "lucas_login",
            "senha123",
            "2025001",
            "Análise e Desenvolvimento de Sistemas"
        );

        Professor p = new Professor(
            "Carlos",
            "carlos_login",
            "1234",
            "Matemática",
            "PR123"
        );

        Curso c = new Curso("POO", "C001", 60);

        System.out.println(a);
        System.out.println(p);
        System.out.println(c);
    }
}
