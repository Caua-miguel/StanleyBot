package me.cauadeveloper.utils.files;

import java.io.*;
import java.util.ArrayList;

public class inputUser {

    public static ArrayList<String> readFileUserCollumnA(String path){

        //Esse aqui vai pegar os valores que vierem do anexo que o usuário vai enviar

        ArrayList<String> list = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){

            bf.readLine();
            bf.readLine();
            String line = bf.readLine();

            while (line != null) {

                String[] collumnA = line.split(",");
                if(collumnA.length > 0){
                    list.add(collumnA[0]);
                }
                line = bf.readLine();
            }
        }catch (IOException e){
            System.out.println("Erro no readFileUserCollumnA: " + e);
        }
        return list;
    }

    public static ArrayList<String> readFileUserCollumnE(String path){

        ArrayList<String> list = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){

            bf.readLine();
            bf.readLine();
            String line = bf.readLine();

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

    public static ArrayList<String> readFileUserCollumnI(String path){

        ArrayList<String> list = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){

            bf.readLine();
            bf.readLine();
            String line = bf.readLine();

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
