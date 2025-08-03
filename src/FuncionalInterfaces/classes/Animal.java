package FuncionalInterfaces.classes;

public class Animal {

    private String especies;
    private boolean eh_nadador;
    private boolean eh_voador;
    private int age;

    public Animal(String especies, boolean eh_nadador, boolean eh_voador, Integer age) {
        this.especies = especies;
        this.eh_nadador = eh_nadador;
        this.eh_voador = eh_voador;
        this.age = age;
    }

    public Animal(String especies) {
        this.especies = especies;
    }

    public String getEspecies() {
        return especies;
    }

    public void setEspecies(String especies) {
        this.especies = especies;
    }

    public boolean isEh_nadador() {
        return eh_nadador;
    }

    public void setEh_nadador(boolean eh_nadador) {
        this.eh_nadador = eh_nadador;
    }

    public boolean isEh_voador() {
        return eh_voador;
    }

    public void setEh_voador(boolean eh_voador) {
        this.eh_voador = eh_voador;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "especies='" + especies + '\'' +
                ", eh_nadador=" + eh_nadador +
                ", eh_voador=" + eh_voador +
                ", age=" + age +
                '}';
    }
}
