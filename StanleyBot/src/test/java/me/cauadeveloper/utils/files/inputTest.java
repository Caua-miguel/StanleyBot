package me.cauadeveloper.utils.files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static me.cauadeveloper.utils.files.member.inputMemberOnTeam.inputMemberDefault;

public class inputTest {

    @Test
    @DisplayName("Deve retornar a saída esperada para a coluna A")
    public void saidaEsperadaCollumnA(){
//        ArrayList<String> resultadoFinal = readFileUserCollumnA();
        ArrayList<String> resultadoEsperado = new ArrayList<>();

//        resultadoEsperado.add("Tabela Nomes Funcionários");
        resultadoEsperado.add("caua");
        resultadoEsperado.add("lucas");
        resultadoEsperado.add("brendo");

//        System.out.println(resultadoFinal);

//        Assertions.assertEquals(resultadoEsperado, resultadoFinal);
    }

    @Test
    @DisplayName("Deve retornar a saída esperada para a coluna E")
    public void saidaEsperadaCollumnE(){
//        ArrayList<String> resultadoFinal = readFileUserCollumnE();
        ArrayList<String> resultadoEsperado = new ArrayList<>();

//        resultadoEsperado.add("Tabela Nomes Funcionários");
        resultadoEsperado.add("coaLegal");
        resultadoEsperado.add("wash");
        resultadoEsperado.add("trocaFill");
//
//        System.out.println(resultadoFinal);
//
//        Assertions.assertEquals(resultadoEsperado, resultadoFinal);
    }

    @Test
    @DisplayName("Deve retornar a saída esperada para a coluna I")
    public void saidaEsperadaCollumnI(){
//        ArrayList<String> resultadoFinal = readFileUserCollumnI();
        ArrayList<String> resultadoEsperado = new ArrayList<>();

//        resultadoEsperado.add("Tabela Nomes Funcionários");
        resultadoEsperado.add("teste");
        resultadoEsperado.add("teste123");
        resultadoEsperado.add("teste teste");
//
//        System.out.println(resultadoFinal);
//
//        Assertions.assertEquals(resultadoEsperado, resultadoFinal);
    }

    @Test
    @DisplayName("Deve retornar a unica linha escrita no arquivo")
    public void saidaEsperadaArquivoMembers(){

            File file = new File("/home/caua/Documentos/Dev/Backend/CoffeBot/StanleyBot/StanleyBot/src/main/java/me/cauadeveloper/database/assents/MembersTeam.txt");

            try(BufferedReader bf = new BufferedReader(new FileReader(file))){

                String contentMemberFile = bf.readLine();
                String esperado = "Lista de nomes dos funcionários para o time :";
                System.out.println(contentMemberFile.length());
                String[] arr = inputMemberDefault();
                System.out.println(arr.length);
                for (int i = 0; i < arr.length; i++){
                    System.out.print(arr[i]);
                }

                Assertions.assertEquals(esperado, Arrays.toString(arr));

            }catch(IOException e){
                e.getMessage();
            }


    }

}
