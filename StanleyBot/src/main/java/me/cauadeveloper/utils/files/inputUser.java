package me.cauadeveloper.utils.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class inputUser {

    public static File file = new File("//home/caua/Documentos/Dev/Backend/LearnFolders/Data/grupos.xls");

    public static ArrayList<String> readFileUserCollumnA(){

        //Esse aqui vai pegar os valores que vierem do anexo que o usuário vai enviar

        ArrayList<String> list = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(file))){

            String line = bf.readLine();
            bf.readLine();
//            bf.readLine();

            while (line != null) {

                String[] collumnA = line.split(",");
                list.add(collumnA[0]);
                line = bf.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<String> readFileUserCollumnE(){

        ArrayList<String> list = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(file))){

            String line = bf.readLine();
            bf.readLine();

            while (line != null) {

                String[] collumnE = line.split(",");
                if(collumnE.length > 4){
                    list.add(collumnE[4]);
                }
                line = bf.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<String> readFileUserCollumnI(){

        ArrayList<String> list = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(file))){

            String line = bf.readLine();
            bf.readLine();

            while (line != null) {

                String[] collumnI = line.split(",");
                if(collumnI.length > 8){
                    list.add(collumnI[8]);
                }
                line = bf.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

}
