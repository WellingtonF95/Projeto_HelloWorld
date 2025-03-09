package Excessoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UsandoFinally {

    /*
    * O finally � executado idependentemente se o bloco try foi executado com sucesso ou com erro
    * Ele serve para limpeza e libera��o de recursos do sistema. Exemplo: conex�o com banco, leitura e escrita de arquivos, etc
    *
    * Boas praticas ao usar o finally:
    * - N�o lan�ar excess�es no bloco finally para n�o sobreescrever a causa raiz do problema
    * - Em algumas situa��es onde � necess�rio "fechar" alguma conex�o, o ideal � usar o try-with-resources
    *
    * */
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/home/wfsantos/familia.txt");
        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(path);
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.printf("Erro ao ler o arquivo: %s\n", e.getMessage());
            throw new RuntimeException(e);
        } finally {
            reader.close();
            System.out.println("Conclui leitura do arquivo");
        }

        //try-with-resources
        try (BufferedReader br = Files.newBufferedReader(path)) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.printf("Erro ao ler o arquivo novamente: %s\n", e.getMessage());
        }
    }

}
