package CollectionsConceitos.DeepCopy;

import java.io.Serializable;
import java.util.Objects;

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

    //Utilizando uma nova instancia de curso ao invocar o construtor de Estudante
    protected Estudante(Estudante estudante) {
        this.id = estudante.getId();
        this.nome = estudante.getNome();
        this.curso = new Curso(estudante.getCurso().getId(), estudante.getCurso().getNome());
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

    //Utilizando a interface Cloneable
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

    @Override
    public boolean equals(Object o) {
        System.out.printf("%s = %s\n", this.getNome(), ((Estudante) o).getNome()); //para fins de estudo
        if (o == null || getClass() != o.getClass()) return false;

        Estudante estudante = (Estudante) o;
        return Objects.equals(nome, estudante.nome);
    }

    @Override
    public int hashCode() {
        return nome.charAt(0); // <- para fins de estudo
        //return Objects.hashCode(nome); <- implementação correta
    }
}
