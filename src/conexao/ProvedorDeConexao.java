
package conexao;

import java.sql.Connection;

public interface ProvedorDeConexao {
    Connection getConnection();
}
