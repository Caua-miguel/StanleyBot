package me.cauadeveloper.utils.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class inputDefault {

    public static StringBuilder readFileDefault(){

        File file = new File("/home/caua/Documentos/Dev/Backend/CoffeBot/StanleyBot/StanleyBot/src/main/java/me/cauadeveloper/database/assents/grupos.csv");
        StringBuilder text = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            String txt = reader.readLine();

            while (txt != null){
                text.append(txt);
                text.append("\n");
                txt = reader.readLine();
            }

        }catch (
                IOException e){
            e.printStackTrace();
        }
        return text;

    }

}
