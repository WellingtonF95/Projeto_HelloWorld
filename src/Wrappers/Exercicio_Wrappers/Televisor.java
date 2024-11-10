package Wrappers.Exercicio_Wrappers;

import java.util.Objects;

public class Televisor {

    private int canal = 130;
    private int volume = 20;

    public Televisor(int canal, int volume) {
        this.canal = canal;
        this.volume = volume;
    }

    public Televisor() {}

    public int getCanal() {
        return canal;
    }

    public int getVolume() {
        return volume;
    }

    void mudarCanal(Integer novoCanal) {
        Objects.requireNonNull(novoCanal, "Informe o numero do novo canal");

        if (canal == novoCanal) {
            System.out.println("Novo canal é também o canal atual.");
        } else {
            canal = novoCanal;
            System.out.println("Canal alterado para " + canal);
        }
    }

    void mudarVolume(Integer novoVolume) {
        Objects.requireNonNull(novoVolume, "Informe o numero do novo volume");

        if (novoVolume == volume) {
            System.out.println("Novo volume é também o volume atual.");
        } else {
            volume = novoVolume;
            System.out.println("Volume alterado para " + volume);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica se o objeto é ele mesmo
        if (obj == null) return false; // Verifica se o objeto recebido é nulo - Se não existir essa condição, pode acontecer um NullPointerException
        if (this.getClass() != obj.getClass()) return false; // Verifica se as classes são diferentes - Se não existir essa condição, pode acontecer um ClassCastException
        Televisor televisor = (Televisor) obj;// Faz o cast do objeto recebido para Televisor
        return (this.canal == televisor.canal && this.volume == televisor.canal); // Verifica se os atributos dos objetos são iguais
    }

    @Override
    public int hashCode() {
        return Objects.hash(canal, volume);
    }

    @Override
    public String toString() {
        return "Televisor{" +
                "canal=" + canal +
                ", volume=" + volume +
                '}';
    }
}
