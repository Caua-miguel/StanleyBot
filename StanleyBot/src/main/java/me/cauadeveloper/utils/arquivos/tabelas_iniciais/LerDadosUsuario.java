package me.cauadeveloper.utils.arquivos.tabelas_iniciais;

import net.dv8tion.jda.api.entities.Message;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class LerDadosUsuario {

    public static ArrayList<String> readFileUserCollumnA(Message.Attachment att) throws FileNotFoundException {

        ArrayList<String> list = new ArrayList<>();

        try{
            File arquivoTemp = File.createTempFile("arquivo_temp", att.getFileExtension());
            att.downloadToFile(arquivoTemp).join();

            BufferedReader bf = new BufferedReader(new FileReader(arquivoTemp));

            bf.readLine();
            bf.readLine();
            String line = bf.readLine();

            while (line != null) {

                String[] collumnA = line.split(",");
                if(collumnA.length > 0){
                    list.add(collumnA[0]);
                }
                line = bf.readLine();
            }

            Files.delete(arquivoTemp.toPath());

        }catch (IOException e){
            throw new FileNotFoundException();
        }
        return list;
    }

    public static ArrayList<String> readFileUserCollumnC(Message.Attachment att) throws FileNotFoundException {

        ArrayList<String> list = new ArrayList<>();

        try{
            File arquivoTemp = File.createTempFile("arquivo_temp", att.getFileExtension());
            att.downloadToFile(arquivoTemp).join();

            BufferedReader bf = new BufferedReader(new FileReader(arquivoTemp));

            bf.readLine();
            bf.readLine();
            String line = bf.readLine();

            while (line != null) {

                String[] collumnC = line.split(",");
                if(collumnC.length > 2){
                    list.add(collumnC[2]);
                }
                line = bf.readLine();
            }

            Files.delete(arquivoTemp.toPath());

        }catch (IOException e){
            throw new FileNotFoundException();
        }
        return list;
    }

    public static ArrayList<String> readFileUserCollumnE(Message.Attachment att){

        ArrayList<String> list = new ArrayList<>();

        try{
            File arquivoTemp = File.createTempFile("arquivo_temp", att.getFileExtension());
            att.downloadToFile(arquivoTemp).join();

            BufferedReader bf = new BufferedReader(new FileReader(arquivoTemp));


            bf.readLine();
            bf.readLine();
            String line = bf.readLine();

            while (line != null) {

                String[] collumnE = line.split(",");
                if(collumnE.length > 4){
                    list.add(collumnE[4]);
                }
                line = bf.readLine();
            }

            Files.delete(arquivoTemp.toPath());

        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<String> readFileUserCollumnI(Message.Attachment att){

        ArrayList<String> list = new ArrayList<>();

        try{
            File arquivoTemp = File.createTempFile("arquivo_temp", att.getFileExtension());
            att.downloadToFile(arquivoTemp).join();

            BufferedReader bf = new BufferedReader(new FileReader(arquivoTemp));

            bf.readLine();
            bf.readLine();
            String line = bf.readLine();

            while (line != null) {

                String[] collumnI = line.split(",");
                if(collumnI.length > 8){
                    list.add(collumnI[8]);
                }
                line = bf.readLine();
            }

            Files.delete(arquivoTemp.toPath());

        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

}
