package String;

public class StringIndexOfExemplo {

    public static void main(String[] args) {

        //Extrai a string 65468 - TATOOINE BRAND KARATE 1638975335029 separando por " - "
        //metodo indexOf retorna o numero da posição do caracter passado no parametro - contagem dos index vai da esquerda para direita
        //metodo substring retorna a string particionada de acordo com o numero da posiçao passada no parametro
        String segment = "65468 - TATOOINE BRAND KARATE 1638975335029";
        int indexOf = segment.indexOf(" - ");
        System.out.println(indexOf);
        System.out.println(segment.substring(0, indexOf));// Resultado:65468
        System.out.println(segment.substring(indexOf + 3).trim()); // Resultado:TATOOINE BRAND KARATE 1638975335029

        String nome = "Wellington Francelino dos Santos";
        int posicaoNome = nome.indexOf(" ");
        System.out.println(posicaoNome);
        String primeiroNome = nome.substring(0, posicaoNome); //Resultado: Wellington
        String sobrenome = nome.substring(11, 21); //Resultado: Francelino

        System.out.println("Primeiro Nome:" + primeiroNome);
        System.out.println("Primeiro Sobrenome:" + obterSegundoNome(nome));

        String outroNome = "Thais Francelino dos Santos";
        System.out.println("Ultimo sobrenome:" + obterUltimoNome(outroNome));

    }

    private static String obterSegundoNome(String nome) {
        int posicaoPrimeiroEspaco = nome.indexOf(" "); //obtem a posicao do primeiro espaço
        int posicaoSegundoEspaco = nome.indexOf(" ", posicaoPrimeiroEspaco + 1); //obtem a posicao do segundo espaço

        if (posicaoPrimeiroEspaco == -1) {
            throw new RuntimeException("Erro ao obter o segundo nome");
        }
        //retorna o segundo nome. Se não existir o segundo nome, retorna o nome completo
        return nome.substring(posicaoPrimeiroEspaco + 1, posicaoSegundoEspaco == -1 ?
                nome.length() : posicaoSegundoEspaco);
    }

    private static String obterUltimoNome(String nome) {
        int posicaoUltimoEspaco = nome.lastIndexOf(" ");

        //retorna o ultimo nome
        return nome.substring(posicaoUltimoEspaco + 1);
    }

}
