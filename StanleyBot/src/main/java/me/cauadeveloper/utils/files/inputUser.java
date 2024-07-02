package me.cauadeveloper.utils.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class inputUser {

    public static ArrayList<String> readFileUser(){

        //Esse aqui vai pegar os valores que vierem do anexo que o usuário vai enviar
        File file = new File("");
        ArrayList<String> list = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(file))){

            String line = bf.readLine();
            bf.readLine();
            bf.readLine();

            while (line != null) {

                String[] collumnA = line.split(",");
                list.add(collumnA[0]);
                line = bf.readLine();

            }


        }catch (IOException e){
            e.getMessage();
        }
        return list;
    }

}
