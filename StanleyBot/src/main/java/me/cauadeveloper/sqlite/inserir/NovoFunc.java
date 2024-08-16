package me.cauadeveloper.sqlite.inserir;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static me.cauadeveloper.sqlite.consulta.tabelas.ListarTimes.selectNomeTime;
import static me.cauadeveloper.sqlite.consulta.geral.VerificarTabelaVazia.check_if_tableFunc_is_null;

public class NovoFunc {

    public static void insert_novo_func(String func, String nomeTime) throws SQLException {
        String sql = """
                INSERT INTO funcionario(id, nome, idTime) values (?,?,?)
                """;
        //Contador para os id da tabela time
        int contCollumnIdFunc = check_if_tableFunc_is_null();

        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            int  idTime = selectNomeTime(nomeTime);

            if (idTime != -1){
                stmt.setInt(1, contCollumnIdFunc + 1);
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
