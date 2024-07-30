package me.cauadeveloper.utils.files;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static me.cauadeveloper.utils.files.member.outputMemberTeam.writeFileDefaltMember;

public class outputTest {

    @Test
    @DisplayName("escreve um novo arquivo com o mesmo")
    public void outputFileMembers(){

        writeFileDefaltMember("fodase");

    }

}
