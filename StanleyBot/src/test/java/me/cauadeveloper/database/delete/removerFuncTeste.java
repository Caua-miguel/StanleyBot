package me.cauadeveloper.database.delete;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static me.cauadeveloper.database.delete.removerFunc.removerFunc;

public class removerFuncTeste {

    @Test
    @DisplayName("Remove a o funcionario do banco de dados")
    public void removerFuncTabelaFunc() throws SQLException {

        removerFunc(2);

    }

}
