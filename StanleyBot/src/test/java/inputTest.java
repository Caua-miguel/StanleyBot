import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static me.cauadeveloper.utils.files.inputUser.*;

public class inputTest {

    @Test
    @DisplayName("Deve retornar a saída esperada para a coluna A")
    public void saidaEsperadaCollumnA(){
        ArrayList<String> resultadoFinal = readFileUserCollumnA();
        ArrayList<String> resultadoEsperado = new ArrayList<>();

//        resultadoEsperado.add("Tabela Nomes Funcionários");
        resultadoEsperado.add("caua");
        resultadoEsperado.add("lucas");
        resultadoEsperado.add("brendo");

        System.out.println(resultadoFinal);

        Assertions.assertEquals(resultadoEsperado, resultadoFinal);
    }

    @Test
    @DisplayName("Deve retornar a saída esperada para a coluna E")
    public void saidaEsperadaCollumnE(){
        ArrayList<String> resultadoFinal = readFileUserCollumnE();
        ArrayList<String> resultadoEsperado = new ArrayList<>();

//        resultadoEsperado.add("Tabela Nomes Funcionários");
        resultadoEsperado.add("coaLegal");
        resultadoEsperado.add("wash");
        resultadoEsperado.add("trocaFill");

        System.out.println(resultadoFinal);

        Assertions.assertEquals(resultadoEsperado, resultadoFinal);
    }

    @Test
    @DisplayName("Deve retornar a saída esperada para a coluna I")
    public void saidaEsperadaCollumnI(){
        ArrayList<String> resultadoFinal = readFileUserCollumnI();
        ArrayList<String> resultadoEsperado = new ArrayList<>();

//        resultadoEsperado.add("Tabela Nomes Funcionários");
        resultadoEsperado.add("teste");
        resultadoEsperado.add("teste123");
        resultadoEsperado.add("teste teste");

        System.out.println(resultadoFinal);

        Assertions.assertEquals(resultadoEsperado, resultadoFinal);
    }

}
