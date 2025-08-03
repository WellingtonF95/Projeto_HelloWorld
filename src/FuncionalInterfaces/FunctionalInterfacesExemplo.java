package FuncionalInterfaces;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;

public class FunctionalInterfacesExemplo {

    public static void main(String[] args) {

        /*Existem mais de 40 interfaces funcionais disponíveis para expressões lambdas mas, basicamente, elas derivam das
        * interfaces Predicate<T>, Function<T, R>, Supplier<T>, Consumer<T>
        *
        * Boa prática: Usar as interfaces padrão que ja existe no Java. Salvo se as interfaces funcionais existentes não
        * forem suficiente, pode ser criadas interfaces funcionais personalizadas.
        *
        *
        * */

        // Predicate - Recebe um argumento de um tipo genérico (parametrizado - T) e retorna um booleano
        Predicate<String> predicate = str -> str.startsWith("W");
        boolean comecaComW = predicate.test("Wellington");
        System.out.printf("Começa com W? %s\n", comecaComW);

        // Function - Recebe um argumento de um tipo genérico (parametrizado - T) e retorna um outro tipo generico (parametrizado - R)
        Function<Integer, String> function = idade -> idade > 18 ? "maior de idade" : "menor de idade";
        String maioridadePenal = function.apply(20);
        System.out.printf("Ele(a) é %s\n", maioridadePenal);

        // Supplier - Não recebe nenhum argumento e retorna um tipo generico (parametrizado - T)
        Supplier<String> supplier = () -> "Hello World!";
        System.out.println(supplier.get());

        // Consumer - Recebe um argumento de um tipo generico e não retorna nada (void)
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("Argumento recebido e processado");

        // Exemplos de uso de interfaces funcionais especificas - Exemplo recebendo e retornando um tipo primitivo int

        IntPredicate intPredicate = numero -> numero % 2 == 0;
        boolean eNumeroPar = intPredicate.test(5);
        System.out.printf("IntPredicate: É número par? %s\n", eNumeroPar);

        IntFunction<String> intFunction = numero -> String.valueOf(numero);
        String numeroEmString = intFunction.apply(30);
        System.out.printf("Numero %d convertido em %s\n", 30, numeroEmString.getClass());

        IntSupplier intSupplier = () -> RandomGenerator.getDefault().nextInt();
        int numeroAleatorio = intSupplier.getAsInt();
        System.out.printf("Numero aleatório: %d\n", numeroAleatorio);

        IntConsumer intConsumer = numero -> System.out.printf("Recebe o número %d\n", numero);
        intConsumer.accept(30);

    }

}
