package Excessoes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckedException {

    public static void main(String[] args) {
        Path path = Path.of("/home/wfsantos/teste.txt");

        try {
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("Não foi possivel criar o arquivo, erro: %s", e.getMessage());
        }

    }

}
