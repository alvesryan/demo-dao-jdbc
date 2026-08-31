package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connection = null; // Connection é uma interface

    //Método
    public static Connection getConnection(){
        if(connection == null){ //se ainda não houver conexão com o banco
            try {
                Properties properties = loadProperties(); // carrego as informações que o método obteve, pra dentro da variável
                String url = properties.getProperty("url"); //busca a propriedade cuja o nome é "url" dentro do arquivo
                connection = DriverManager.getConnection(url, properties); // o driver conecta ao banco usando a url e as outras propriedades obtidas acima(properties).
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.propeties")){ //abro o arquivo de propriedades
            Properties props = new Properties(); //instanca de estrutura voltada a ler arquivos no formato chave=valor
            props.load(fs); // carrega as informações do arquivo pra dentro da memória do objeto
            return props;
        } catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }

    /*Passo 1: Criamos um método estático (loadProperties) para ler o arquivo e carregar as credenciais de acesso para a memória usando a classe Properties.

    Passo 2: Criamos o método principal (getConnection) que usa a classe gerenciadora DriverManager chamando o método .getConnection(...) para nos devolver um objeto que implementa a interface Connection (a nossa "linha telefônica" aberta).

    Passo 3: Criamos um método seguro (closeConnection) que verifica se a conexão existe e a encerra formalmente usando connection.close(), liberando os recursos da máquina.*/

    public static void closeStatement(Statement statement){ //Método para fechar a interface responsável por enviar querys ao banco.
        if(statement != null){
            try{
                statement.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet){ //Método para fechar a interface que tras os resultados das querys.
        if(resultSet != null){
            try{
                resultSet.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
}
