package me.cauadeveloper.database.dataconfig;

import java.util.ArrayList;

import static me.cauadeveloper.utils.files.inputUser.readFileUserCollumnA;

public class readConfig {

    public static String[] dataUser(){

        ArrayList<String> dataUser = readFileUserCollumnA();
        String[] data = new String[dataUser.size()];

        for (int i = 0; i < dataUser.size(); i++){
            data[i] = dataUser.get(i);
        }

        return data;
    }

}
