package br.com.pi.projetoIntegrador.auxiliar;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class FileToBase64 {

    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\nurag\\OneDrive\\Área de Trabalho\\Nova pasta (2)\\Eixos_Tematicos.pdf";
        byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
        String base64Content = Base64.getEncoder().encodeToString(fileContent);

        System.out.println(base64Content);
    }
}

