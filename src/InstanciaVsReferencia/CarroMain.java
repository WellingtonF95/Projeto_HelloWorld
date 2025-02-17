package InstanciaVsReferencia;

public class CarroMain {

    public static void main(String[] args) {

        Carro carro = new Carro();
        carro.proprietario.setNome("Wellington");

        Pessoa proprietarioAntigo = carro.proprietario;

        Carro outroCarro = new Carro();
        outroCarro.proprietario.setNome("Thais");



    }
}
