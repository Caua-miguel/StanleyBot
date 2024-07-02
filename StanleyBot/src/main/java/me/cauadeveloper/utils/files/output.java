package me.cauadeveloper.utils.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static me.cauadeveloper.utils.files.inputDefault.readFileDefault;

public class output {

    public static void writeFileDefalt(){

        File file = new File("//home/caua/Documentos/Dev/Backend/LearnFolders/Data/grupos.xls");

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))){

            StringBuilder tablesSetUP = readFileDefault();
            bf.write(String.valueOf(tablesSetUP));

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
