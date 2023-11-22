package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.Doenca;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoencaRepository extends Repository{
    public static Doenca save(Doenca doenca){
        String sql = "insert into t_mdv_doencas(nm_doenca,tp_doenca,fx_etaria,ds_doenca,id_usuario,id_doenca) " +
                "values(?,?,?,?,?,seq_id_doenca)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1,doenca.getNome());
            ps.setString(2, doenca.getTipo());
            ps.setString(3, doenca.getFaixaEtaria());
            ps.setString(4, doenca.getDescricao());
            ps.setLong(5,doenca.getIdUsuario());

            if (ps.executeUpdate() > 0){
                return doenca;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
}
