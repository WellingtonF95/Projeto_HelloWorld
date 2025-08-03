package FuncionalInterfaces.classes;

public class AnimalNadador implements AcaoAnimal {

    public boolean verificaAcao(Animal animal) {
        return animal.isEh_nadador();
    }

    // Implementa��o concreta do default method da interface AcaoAnimal

    @Override
    public boolean eh_animal_nadador(Animal animal) {
        System.out.printf("Animal %s � nadador? %s\n", animal.getEspecies(), animal.isEh_nadador());
        return animal.isEh_nadador();
    }

    public static String imprimeEspecie(Animal animal) {
        System.out.printf("Animal %s\n", animal.getEspecies());
        return animal.getEspecies();
    }

}
