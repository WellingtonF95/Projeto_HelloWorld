package Wrappers.Exercicio_Wrappers;

import java.util.Objects;

public class Radio {

    private String estacao;

    private int volume;

    public Radio(String estacao, int volume) {
        this.estacao = estacao;
        this.volume = volume;
    }

    public Radio () {}

    public String getEstacao() {
        return this.estacao;
    }

    public int getVolume() {
        return this.volume;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Radio radio = (Radio) obj;
        return Objects.equals(this.estacao, radio.estacao) && this.volume == radio.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(estacao, volume);
    }

    @Override
    public String toString() {
        return String.format("Radio {estacao=%s, volume=%d}", this.estacao, this.volume);
    }
}
