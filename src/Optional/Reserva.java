package Optional;

import java.util.Objects;
import java.util.Optional;

public class Reserva {

    private String codigo;
    private Voo voo;
    private Passageiro passageiro;
    private int quantidadeBagagens;

    public Reserva(String codigo, Voo voo, String nomePassageiro) {
        Objects.requireNonNull(codigo);
        Objects.requireNonNull(codigo);
        Objects.requireNonNull(codigo);
        this.codigo = codigo;
        this.voo = voo;
        this.passageiro = new Passageiro(nomePassageiro);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    // Metodo criado para simular o uso do flatMap
    public Optional<Passageiro> getPassageiro2() {
        return Optional.of(passageiro);
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public int getQuantidadeBagagens() {
        return quantidadeBagagens;
    }

    public void adicionarBagagens(int quantidadeBagagens) {
        this.quantidadeBagagens += quantidadeBagagens;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reserva that = (Reserva) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo='" + codigo + '\'' +
                ", voo=" + voo +
                ", passageiro=" + passageiro +
                ", quantidadeBagagens=" + quantidadeBagagens +
                '}';
    }
}
