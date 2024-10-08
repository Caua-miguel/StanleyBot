package me.cauadeveloper.sqlite.inserir;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static me.cauadeveloper.sqlite.consulta.tabelas.ListaTimes.selectIdTime;

public class NovoFunc {

    public static void insert_novo_func(String idDisc, String func, String nomeTime) throws SQLException {
        String sql = """
                INSERT INTO funcionario(id, nome, idTime) values (?,?,?)
                """;

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            int  idTime = selectIdTime(nomeTime);

            if (idTime != -1){
                stmt.setString(1, idDisc);
                stmt.setString(2, func);
                stmt.setInt(3, idTime);
                stmt.execute();
            }else {
                throw new SQLException();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }
    }

}
