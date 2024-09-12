package me.cauadeveloper.sqlite.inserir;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static me.cauadeveloper.sqlite.consulta.geral.ContadorLinhasTabela.maxLinesTableTarefa;

public class NovaTarefa {


    public static void insertNovaTarefa(String descTarefa) throws SQLException {
        String sql = """
                INSERT INTO tarefa (id, descricao) values (?, ?)
                """;

        int contadorLinhasTarefa = maxLinesTableTarefa();

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            stmt.setInt(1, contadorLinhasTarefa + 1);
            stmt.setString(2, descTarefa);

            stmt.execute();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_novo_func\n" + e.getMessage());
        }
    }


}
