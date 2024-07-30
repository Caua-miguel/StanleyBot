package me.cauadeveloper.utils.files.member;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static me.cauadeveloper.utils.files.initialDataBase.inputDefault.readFileDefault;
import static me.cauadeveloper.utils.files.member.inputMemberOnTeam.inputMemberDefault;

public class outputMemberTeam {

    public static void writeFileDefaltMember(String nomeTime){

        File file = new File("/home/caua/Documentos/Dev/Backend/CoffeBot/StanleyBot/StanleyBot/src/main/java/me/cauadeveloper/database/assents/MembersTeam.pdf");

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))){

            String memberSetUp = "Lista de nomes dos funcionários para o time " + nomeTime + ":";
            bf.write(memberSetUp);

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
