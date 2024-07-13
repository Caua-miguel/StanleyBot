import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static me.cauadeveloper.database.dataconfig.readConfig.dataUserCollumnA;

public class readConfigTest {

    @DisplayName("Saida esperada Da Operacão De Transformar Lista Em Array Na Coluna A")
    @Test
    public void saidaEsperadaTranformandoListaEmArrayCollumnA(){

        String[] saidaArr = dataUserCollumnA();
        String[] saidaEsperadaArr = {"caua", "lucas", "brendo"};

        System.out.println(Arrays.toString(saidaArr));

        Assertions.assertEquals(Arrays.toString(saidaEsperadaArr), Arrays.toString(saidaArr));

    }

}
