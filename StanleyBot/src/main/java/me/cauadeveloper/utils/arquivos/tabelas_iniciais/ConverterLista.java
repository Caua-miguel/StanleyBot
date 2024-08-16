package me.cauadeveloper.utils.arquivos.tabelas_iniciais;

import java.util.ArrayList;

public class ConverterLista {

    public static String[] dataUserCollumnA(ArrayList<String> list){

        ArrayList<String> dataUser = list;
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

    public static String[] dataUserCollumnE(ArrayList<String> list){

        ArrayList<String> dataUser = list;
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

    public static String[] dataUserCollumnI(ArrayList<String> list){

        ArrayList<String> dataUser = list;
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
