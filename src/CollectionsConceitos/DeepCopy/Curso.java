package CollectionsConceitos.DeepCopy;

import java.io.Serializable;

public class Curso implements Cloneable, Serializable {

    private Integer id;
    private String nome;

    public Curso() {}

    public Curso(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public Curso clone() {
        Curso curso;
        try {
            curso = (Curso) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
        return curso;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "cursoId=" + id +
                ", cursoNome='" + nome + '\'' +
                '}';
    }

   /* public Curso deepCopy() {
        return new Curso(this.id, this.nome);
    }*/

}
