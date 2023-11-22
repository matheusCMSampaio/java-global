package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.Registro;
import br.com.medvirtua.java_global.model.entity.RegistroEspecialista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public static ArrayList<RegistroEspecialista> findByName(String name) {
        String sql = "SELECT * FROM t_mdv_registro_especialista where nm_usuario = ?";
        ArrayList<RegistroEspecialista> registros = new ArrayList<RegistroEspecialista>();
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RegistroEspecialista registro = new RegistroEspecialista();
                registro.setId(rs.getLong("id_usuario"));
                registro.setNome(rs.getString("nm_usuario"));
                registro.setSenha(rs.getString("nm_senha"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return registros;
    }
}
