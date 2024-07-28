package me.cauadeveloper.utils.files.member;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static me.cauadeveloper.utils.files.initialDataBase.inputDefault.readFileDefault;

public class outputMemberTeam {

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
