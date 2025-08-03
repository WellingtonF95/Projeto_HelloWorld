package FuncionalInterfaces.classes;

public class AnimalNadador implements AcaoAnimal {

    public boolean verificaAcao(Animal animal) {
        return animal.isEh_nadador();
    }

    // Implementação concreta do default method da interface AcaoAnimal

    @Override
    public boolean eh_animal_nadador(Animal animal) {
        System.out.printf("Animal %s é nadador? %s\n", animal.getEspecies(), animal.isEh_nadador());
        return animal.isEh_nadador();
    }

    public static String imprimeEspecie(Animal animal) {
        System.out.printf("Animal %s\n", animal.getEspecies());
        return animal.getEspecies();
    }

}
