package me.cauadeveloper.sqlite.tabelas;

import me.cauadeveloper.sqlite.config_banco.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TabelaFunc {

    public static void insert_data_user_func(List<String> dataUser) throws SQLException{
        String sql = """
                INSERT INTO funcionario(id, nome) values (?,?)
                """;
        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){

            List<String> data = dataUser;

            for (int i = 0; i < data.size(); i++){
                stmt.setInt(1, i + 1);
                stmt.setString(2, data.get(i));
                stmt.execute();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no insert_data_user_func\n" + e.getMessage());
        }
    }

//Preciso adicionar um idTime nessa tabela
// trocar o id para ser o idUser do discord
    public static void create_table() throws SQLException {

        String sql = """
                CREATE TABLE funcionario (
                    id integer PRIMARY KEY AUTOINCREMENT NOT NULL,
                    nome varchar(255) NOT NULL,
                    idTime,
                    FOREIGN KEY (idTime) REFERENCES time (id)
                )
                """;
        try(PreparedStatement stmt = ConexaoBanco.getConn().prepareStatement(sql)){
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
