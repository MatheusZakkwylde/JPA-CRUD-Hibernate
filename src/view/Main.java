package view;

import java.util.ArrayList;
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
        livroTerror.setNome("O Exocista");
        livroTerror.setEditora("Harper");
        livroTerror.setAno(1971);

        Livro livroTeologia = new Livro();
        livroTeologia.setNome("Os templários");
        livroTeologia.setEditora("");
        livroTeologia.setAno(2004);

        Autor autor = new Autor();
        autor.setNome("Barbara Frale");
        autor.setListLivro(new ArrayList<Livro>());
        autor.getListLivro().add(livroTerror);
        autor.getListLivro().add(livroTeologia);

        DaoGenerics<Autor> daoAutor = new DaoGenerics<Autor>();
        daoAutor.saveOrUpdate(autor);

        //\\\\\\\\\\\\\\\\\\\\\\\\\ curso \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        Curso curso = new Curso();
        curso.setNome("ADS");

        DaoGenerics<Curso> daoCurso = new DaoGenerics<Curso>();
        daoCurso.saveOrUpdate(curso);

        //\\\\\\\\\\\\\\\\\\\\\\\ cidades \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        Cidade cidade = new Cidade();
        cidade.setNome("Riacho da cruz");
        cidade.setEstado("RN");

        DaoGenerics<Cidade> daoCidade = new DaoGenerics<Cidade>();
        daoCidade.saveOrUpdate(cidade);

        //\\\\\\\\\\\\\\\\\\\\\\\\\\\Aluno\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        Cidade cidade1 = daoCidade.findById(Cidade.class, 1L);
        Curso curso1 = daoCurso.findById(Curso.class, 1L);

        Aluno aluno = new Aluno();
        aluno.setNome("Matheus");
        aluno.setEmail("matheus@gmail.com");
        aluno.setCpf("3144234234344");
        aluno.setCidade(cidade1);
        aluno.setCurso(curso1);
        aluno.setData_cadastro("26/03/1996");

        DaoGenerics<Aluno> daoAluno = new DaoGenerics<Aluno>();
        daoAluno.saveOrUpdate(aluno);

        //\\\\\\\\\\\\\\\\status\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        StatusLocacao status = new StatusLocacao();
        status.setNome("Ativa");
        DaoGenerics<StatusLocacao> daoStatus = new DaoGenerics<StatusLocacao>();
        daoStatus.saveOrUpdate(status);

        Aluno aluno1 = daoAluno.findById(Aluno.class, 1L);
        StatusLocacao status1 = daoStatus.findById(StatusLocacao.class,1L);
        LocacaoLivro locacao = new LocacaoLivro();
        locacao.setAluno(aluno1);
        locacao.setStatus(status1);
        locacao.setData_locacao("20/12/2018");
        locacao.setData_entrega("30/01/2019");
        locacao.setLivro(livroTerror);
        locacao.setStatus(status);
        DaoGenerics<LocacaoLivro> daoLocacao = new DaoGenerics<LocacaoLivro>();
        daoLocacao.saveOrUpdate(locacao);
        System.out.println("Dados cadastrados com sucesso!");
    }
}
