package CollectionsConceitos.DeepCopy;

import java.io.Serializable;

public class Estudante implements Cloneable, Serializable {

    private Integer id;
    private String nome;
    private Curso curso;

    public Estudante() {
    }

    public Estudante(Integer id, String nome, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "idEstudante=" + id +
                ", nomeEstudante='" + nome + '\'' +
                ", curso=" + curso +
                '}';
    }

    @Override
    public Estudante clone() {
        Estudante estudante;
        try {
            estudante = (Estudante) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
        estudante.setCurso(this.getCurso().clone());
        return estudante;
    }


   /* public Estudante deepCopy() {
        return new Estudante(this.id, this.nome, this.curso.deepCopy());
    }*/

}
