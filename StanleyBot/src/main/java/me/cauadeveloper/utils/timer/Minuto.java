package me.cauadeveloper.utils.timer;

import me.cauadeveloper.utils.fixValues.utilsStaticMethods;

import static me.cauadeveloper.utils.fixValues.utilsStaticMethods.txtMin;

public class Minuto implements Runnable{

        @Override
        public void run() {

            int i = Integer.parseInt(txtMin);

            for (;;){
                txtMin = i + "";
                i++;
                if(i == 59){
                    i = 0;
                }
                try {
                    Thread.sleep(60000);
                }catch (Exception e){
                    System.out.println("Erro no Minuto: " + e.getMessage());
                }
            }

        }
}
