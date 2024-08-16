package me.cauadeveloper.utils.arquivos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static me.cauadeveloper.utils.arquivos.funcionarios.outputMemberTeam.writeFileDefaltMember;

public class outputTest {

    @Test
    @DisplayName("escreve um novo arquivo com o mesmo")
    public void outputFileMembers(){

        writeFileDefaltMember("fodase");

    }

}
