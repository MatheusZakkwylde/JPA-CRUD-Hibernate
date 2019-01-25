
package view;

import java.util.List;
import model.Aluno;
import model.Curso;
import model.DaoGenerics;
import model.Livro;

public class Consultas {
    public static void main(String[] args) {
        Aluno aluno = new Aluno ();
        Curso curso = new Curso();
        Livro livro = new Livro();
        
        DaoGenerics<Curso> daoCurso = new DaoGenerics<Curso>();
        DaoGenerics<Aluno> daoAluno = new DaoGenerics<Aluno>();
        DaoGenerics<Livro> daoLivro = new DaoGenerics<Livro>();
        
        Curso curso1 = daoCurso.findById(Curso.class,2l);
        
       
        List<Aluno> listAluno = daoAluno.alunoByIdCurso(curso1.getId());
        System.out.println("Lista de alunos pelo curso da quele ID");
        for (Aluno listAluno1 : listAluno) {
            System.out.println(listAluno1.getNome());
            System.out.println(listAluno1.getCurso().getNome());
        }
        
        System.out.println("Lista de aluno pelo livro");
        List<Aluno> listAlunoLivro = daoLivro.alunoByIdLivro(1L);
        for (Aluno list : listAlunoLivro) {
            System.out.println(list.getNome());
        }
        
        System.out.println("Lista de alunos por estado");
        List<Aluno> listAlunoEstado = daoAluno.AlunoByIdEstado("RN");
        for (Aluno listAlunoEstado1 : listAlunoEstado) {
            System.out.println(listAlunoEstado1.getCidade().getEstado());
            System.out.println(listAlunoEstado1.getNome());
        }
          
        System.out.println("Quantidade de aluno por curso :"+daoAluno.contAlunoByCurso(2L));
        
        System.out.println("Alunos com livros atrasados");
        ///List<Aluno> atrasado = daoAluno.alunoLivrosAtrasados();
        //for (Aluno atrasado1 : atrasado) {
          //  System.out.println(atrasado1.getNome());
        //}
        
        System.out.println("Lista de livros por autor");
        List<Livro> listLivro = daoLivro.LivroByAutor("Barbara Frale");
       for (Livro listLivro1 : listLivro) {
            System.out.println(listLivro1.getNome());
        }
       
        System.out.println("Todos os livros por status");
        List<Livro> livroStatus = daoLivro.LivroByStatus(3L);
        for (Livro livroStatu : livroStatus) {
            System.out.println(livroStatu.getNome());
        }
        
        System.out.println("Livros emprestados");
        List<Livro> livroEmp = daoLivro.LivrosEmprestado();
        for (Livro livroEmp1 : livroEmp) {
            System.out.println(livroEmp1.getNome());
        }
        List<Livro> livron = daoLivro.LivroByName("A Gue");
        
        System.out.println("Livros:");
        for (Livro livron1 : livron) {
            System.out.println(livron1.getNome());
        }
    }
 
}
