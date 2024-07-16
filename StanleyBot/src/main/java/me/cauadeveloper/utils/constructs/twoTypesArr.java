package me.cauadeveloper.utils.constructs;

import net.dv8tion.jda.api.entities.Message;

public class twoTypesArr {

    private String userMenssage;
    private Message.Attachment userAtt;

    public twoTypesArr(String userMenssage, Message.Attachment userAtt) {
        this.userMenssage = userMenssage;
        this.userAtt = userAtt;
    }

    public String getUserMenssage(){
        return userMenssage;
    }

    public Message.Attachment getUserAtt(){
        return userAtt;
    }

}
