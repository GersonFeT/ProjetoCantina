package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conexao {
    private static final String URL = "jbdc:mysql://localhost:3306/cantina_senai_db" +
            "useSSL=false" +
            "&allowPublicKeyRetrieval=true" +
            "&serverTimexone=America/Sao_Paulo";
    //lalowPublicKeyRetrieval: permite que o driver JDBC solicite ao mysql uma chave publica
    //serverTimezone: informa oa Jdbc O FUSO HORÁRIO PARA TRABALHAR
    private static final String USUARIO = "cantina";
    private static final String SENHA = "cantina123";

    private Conexao(){}

    public static final Connection conectar() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
    public static void testar() throws SQLException{
        try (Connection conexao = conectar()){
            if(!conexao.isValid(2)){
                throw new SQLException("O MySQL não confirmou a conexão!");
            }
        }
    }
}