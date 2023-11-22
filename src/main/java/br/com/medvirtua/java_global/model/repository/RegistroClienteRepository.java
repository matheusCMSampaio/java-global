package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.RegistroCliente;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroClienteRepository extends Repository {
    public static RegistroCliente save(RegistroCliente registro) {
        String sql = "INSERT INTO T_MDV_REGISTRO_CLIENTE (id_usuario, dt_nascimento, nm_usuario, nm_senha, nr_cep) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setLong(1, registro.getId());
            ps.setDate(2, Date.valueOf(registro.getDataNascimento()));
            ps.setString(3, registro.getNome());
            ps.setString(4, registro.getSenha());
            ps.setInt(5, registro.getCep());

            if (ps.executeUpdate() > 0) {
                return registro;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
