package me.cauadeveloper.utils.timer;

import static me.cauadeveloper.utils.fixValues.utilsStaticMethods.txtSeg;

public class Segundo implements Runnable{

    @Override
    public void run() {

        int i = Integer.parseInt(txtSeg);

        for (;;){
            txtSeg = i + "";
            i++;
            if(i == 59){
                i = 0;
            }
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Erro no Minuto: " + e.getMessage());
            }
        }

    }
}
