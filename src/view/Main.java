package view;

import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.Autor;
import model.Cidade;
import model.Curso;
import model.DaoGenerics;
import model.Livro;
import model.LocacaoLivro;
import model.StatusLocacao;

public class Main {

    public static void main(String[] args) {
        //\\\\\\\\\\\\\\\\\\\\\\\\\\ autores e seus livros\\\\\\\\\\\\\\\\
        Livro livroTerror = new Livro();
        livroTerror.setNome("O Apocalipse");
        livroTerror.setEditora("Harper");
        livroTerror.setAno(1971);

        Livro livroTeologia = new Livro();
        livroTeologia.setNome("A Guerra");
        livroTeologia.setEditora("");
        livroTeologia.setAno(2004);

        Autor autor = new Autor();
        autor.setNome("Barbara Frale");
        autor.setListLivro(new ArrayList<Livro>());
        autor.getListLivro().add(livroTerror);
        autor.getListLivro().add(livroTeologia);

        DaoGenerics<Autor> daoAutor = new DaoGenerics<Autor>();
        daoAutor.save(autor);

        //\\\\\\\\\\\\\\\\\\\\\\\\\ curso \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        Curso curso = new Curso();
        curso.setNome("Quimica");

        DaoGenerics<Curso> daoCurso = new DaoGenerics<Curso>();
        daoCurso.save(curso);

        //\\\\\\\\\\\\\\\\\\\\\\\ cidades \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        Cidade cidade = new Cidade();
        cidade.setNome("Rio de Janeiro");
        cidade.setEstado("Rj");

        DaoGenerics<Cidade> daoCidade = new DaoGenerics<Cidade>();
        daoCidade.save(cidade);

        //\\\\\\\\\\\\\\\\\\\\\\\\\\\Aluno\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        Cidade cidade1 = daoCidade.findById(Cidade.class, 2L);
        Curso curso1 = daoCurso.findById(Curso.class, 2L);

        Aluno aluno = new Aluno();
        aluno.setNome("Maria");
        aluno.setEmail("Maria@gmail.com");
        aluno.setCpf("222222222");
        aluno.setCidade(cidade1);
        aluno.setCurso(curso1);
        aluno.setData_cadastro("28/07/2018");

        DaoGenerics<Aluno> daoAluno = new DaoGenerics<Aluno>();
        daoAluno.save(aluno);

        //\\\\\\\\\\\\\\\\status\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        StatusLocacao status = new StatusLocacao();
        status.setNome("Emprestado");
        DaoGenerics<StatusLocacao> daoStatus = new DaoGenerics<StatusLocacao>();
        daoStatus.save(status);

        Aluno aluno1 = daoAluno.findById(Aluno.class, 2L);
        StatusLocacao status1 = daoStatus.findById(StatusLocacao.class,2L);
        LocacaoLivro locacao = new LocacaoLivro();
        locacao.setAluno(aluno1);
        locacao.setStatus(status1);
        locacao.setData_locacao("30/10/2015");
        locacao.setData_entrega("10/02/2018");
        locacao.setLivro(livroTerror);
        locacao.setStatus(status);
        DaoGenerics<LocacaoLivro> daoLocacao = new DaoGenerics<LocacaoLivro>();
        daoLocacao.save(locacao);
        System.out.println("Dados cadastrados com sucesso!");
    }
}
