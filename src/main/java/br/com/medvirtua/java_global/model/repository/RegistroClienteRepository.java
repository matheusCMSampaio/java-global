package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.RegistroCliente;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static ArrayList<RegistroCliente> findByName(String name) {
        String sql = "SELECT * FROM T_MDV_REGISTRO_CLIENTE where NM_USUARIO = ?";
        ArrayList<RegistroCliente> registros = new ArrayList<RegistroCliente>();
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RegistroCliente registroCliente = new RegistroCliente();
                registroCliente.setId(rs.getLong("ID_USUARIO"));
                registroCliente.setNome(rs.getString("NM_USUARIO"));
                registroCliente.setSenha(rs.getString("NM_SENHA"));
                registroCliente.setCep(rs.getInt("NR_CEP"));
                registroCliente.setDataNascimento(rs.getDate("DT_NASCIMENTO").toLocalDate());
                registros.add(registroCliente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return registros;
    }

    public static boolean delete(Long id) {
        String sql = "delete from T_MDV_REGISTRO_CLIENTE where ID_USUARIO = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setLong(1, id);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public static RegistroCliente update(RegistroCliente registroCliente) {
        String sql = "UPDATE T_MDV_REGISTRO_CLIENTE SET NM_USUARIO = ?, NM_SENHA = ?, NR_CEP = ?, DT_NASCIMENTO = ? WHERE ID_USUARIO = ?";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, registroCliente.getNome());
            ps.setString(2, registroCliente.getSenha());
            ps.setInt(3, registroCliente.getCep());
            ps.setDate(4, Date.valueOf(registroCliente.getDataNascimento()));
            ps.setLong(5, registroCliente.getId());

            if (ps.executeUpdate() > 0) {
                return registroCliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

}
