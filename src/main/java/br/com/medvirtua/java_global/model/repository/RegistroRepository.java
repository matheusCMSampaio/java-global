package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.Registro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistroRepository extends Repository{
    public static Registro save(Registro registro){
        String sql = "insert into t_mdv_registro(id_usuario, nm_usuario, nm_senha) values(seq_id_usuario.nextval, ?,?)";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, registro.getNome());
            ps.setString(2, registro.getSenha());
            if (ps.executeUpdate() >0){
                return registro;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
    public static ArrayList<Registro> findAll() {
        String sql = "SELECT * FROM t_mdv_registro";
        ArrayList<Registro> registros = new ArrayList<Registro>();
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Registro registro = new Registro();
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
