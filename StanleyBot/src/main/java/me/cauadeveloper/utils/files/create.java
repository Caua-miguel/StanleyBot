package me.cauadeveloper.utils.files;

import java.io.File;
import java.io.IOException;

import static me.cauadeveloper.utils.files.output.writeFileDefalt;

public class create {

    public static File createFile(){

        File file = new File("//home/caua/Documentos/Dev/Backend/LearnFolders/Data/grupos.xls");

        try{
            if(!file.exists()){
                file.createNewFile();

            }
            writeFileDefalt();
        }catch (IOException e){
            e.getMessage();
        }
        return file;
    }

}
