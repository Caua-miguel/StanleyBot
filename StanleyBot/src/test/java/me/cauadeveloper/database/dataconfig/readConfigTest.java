package me.cauadeveloper.database.dataconfig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static me.cauadeveloper.database.dataconfig.readConfig.*;

public class readConfigTest {

    @DisplayName("Saida esperada Da Operacão De Transformar Lista Em Array Na Coluna A")
    @Test
    public void saidaEsperadaTranformandoListaEmArrayCollumnA(){

//        String[] saidaArr = dataUserCollumnA();
        String[] saidaEsperadaArr = {"caua", "lucas", "brendo"};

//        System.out.println(Arrays.toString(saidaArr));

//        Assertions.assertEquals(Arrays.toString(saidaEsperadaArr), Arrays.toString(saidaArr));

    }

    @DisplayName("Saida esperada Da Operacão De Transformar Lista Em Array Na Coluna E")
    @Test
    public void saidaEsperadaTranformandoListaEmArrayCollumnE(){

//        String[] saidaArr = dataUserCollumnE();
        String[] saidaEsperadaArr = {"coaLegal", "wash", "trocaFill"};
//
//        System.out.println(Arrays.toString(saidaArr));
//
//        Assertions.assertEquals(Arrays.toString(saidaEsperadaArr), Arrays.toString(saidaArr));

    }

    @DisplayName("Saida esperada Da Operacão De Transformar Lista Em Array Na Coluna I")
    @Test
    public void saidaEsperadaTranformandoListaEmArrayCollumnI(){

//        String[] saidaArr = dataUserCollumnI();
        String[] saidaEsperadaArr = {"teste", "teste123", "teste teste"};

//        System.out.println(Arrays.toString(saidaArr));
//
//        Assertions.assertEquals(Arrays.toString(saidaEsperadaArr), Arrays.toString(saidaArr));

    }

}
