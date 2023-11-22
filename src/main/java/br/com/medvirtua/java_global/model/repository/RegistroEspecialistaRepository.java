package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.RegistroEspecialista;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroEspecialistaRepository extends Repository{
    public static RegistroEspecialista save(RegistroEspecialista registroEspecialista){
        String sql = "insert into t_mdv_registro_especialista(id_usuario, nm_usuario, nm_senha, nr_crm) " +
                "values(?,?,?,?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setLong(1,registroEspecialista.getId());
            ps.setString(2,registroEspecialista.getNome());
            ps.setString(3, registroEspecialista.getSenha());
            ps.setInt(4,registroEspecialista.getCrm());
            if (ps.executeUpdate() > 0){
                return registroEspecialista;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
}
