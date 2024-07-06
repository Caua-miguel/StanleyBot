package me.cauadeveloper.database.dataconfig;

import java.util.ArrayList;

import static me.cauadeveloper.utils.files.inputUser.*;

public class readConfig {

    public static String[] dataUserCollumnA(){

        ArrayList<String> dataUser = readFileUserCollumnA();
        String[] data = new String[dataUser.size()];

        try{
            for (int i = 0; i < dataUser.size(); i++){
                data[i] = dataUser.get(i);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no dataUser - readConfig\n" + e.getMessage());
        }

        return data;
    }

    public static String[] dataUserCollumnI(){

        ArrayList<String> dataUser = readFileUserCollumnI();
        String[] data = new String[dataUser.size()];

        try{
            for (int i = 0; i < dataUser.size(); i++){
                data[i] = dataUser.get(i);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no dataUser - readConfig\n" + e.getMessage());
        }

        return data;
    }

    public static String[] dataUserCollumnO(){

        ArrayList<String> dataUser = readFileUserCollumnO();
        String[] data = new String[dataUser.size()];

        try{
            for (int i = 0; i < dataUser.size(); i++){
                data[i] = dataUser.get(i);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no dataUser - readConfig\n" + e.getMessage());
        }

        return data;
    }

}
