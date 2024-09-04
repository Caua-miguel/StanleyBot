package me.cauadeveloper.sqlite.tabelas;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TabelaFunc {

    public static void insert_data_user_func(List<String> dadosDisc, List<String> nomeFunc) throws SQLException{
        String sql = """
                INSERT INTO funcionario(id, nome) values (?,?)
                """;
        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            List<String> usuariosDiscord = dadosDisc;
            List<String> funcionarios = nomeFunc;

            for (int i = 0; i < usuariosDiscord.size()-1; i++){
                stmt.setString(1, usuariosDiscord.get(i));
                stmt.setString(2, funcionarios.get(i));
                stmt.execute();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_data_user_func\n" + e.getMessage());
        }
    }

    public static void create_table() throws SQLException {
        String sql = """
                CREATE TABLE funcionario (
                    id varchar(255) PRIMARY KEY NOT NULL,
                    nome varchar(255) NOT NULL,
                    idTime,
                    idTarefa,
                    FOREIGN KEY (idTime) REFERENCES time (id)
                    FOREIGN KEY (idTarefa) REFERENCES tarefa (id)
                )
                """;
        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
