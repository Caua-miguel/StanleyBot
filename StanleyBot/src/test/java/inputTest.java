import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static me.cauadeveloper.utils.files.inputUser.readFileUserCollumnA;

public class inputTest {

    @Test
    @DisplayName("Deve retornar a saída esperada")
    public void saidaEsperada(){
        ArrayList<String> resultadoFinal = readFileUserCollumnA();
        ArrayList<String> resultadoEsperado = new ArrayList<>();

//        resultadoEsperado.add("Tabela Nomes Funcionários");
        resultadoEsperado.add("caua");
        resultadoEsperado.add("lucas");
        resultadoEsperado.add("brendo");

        System.out.println(resultadoFinal);

        Assertions.assertEquals(resultadoEsperado, resultadoFinal);
    }

}
