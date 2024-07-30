package me.cauadeveloper.utils.files.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class inputMemberOnTeam  {

    public static String[] inputMemberDefault(){

        File file = new File("/home/caua/Documentos/Dev/Backend/CoffeBot/StanleyBot/StanleyBot/src/main/java/me/cauadeveloper/database/assents/MembersTeam.txt");

        try(BufferedReader bf = new BufferedReader(new FileReader(file))){

            String contentMemberFile = bf.readLine();
            ArrayList<String> list = new ArrayList<>();
            String[] arr = contentMemberFile.split(" ");

            while (contentMemberFile != null){
                list.add(contentMemberFile);
                contentMemberFile = bf.readLine();
            }

            for (int i = 1; i < list.size()-1; i++){
                arr[i] = list.get(i);
            }

            return arr;

        }catch(IOException e){
            e.getMessage();
        }
        return null;
    }

}
