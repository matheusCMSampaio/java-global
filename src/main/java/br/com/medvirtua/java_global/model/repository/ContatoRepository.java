package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.Contato;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoRepository extends Repository{
    public static Contato save(Contato contato){
        String sql = "insert into t_mdv_contato(tp_contato, nr_telefone, nm_email, id_usuario) values(?,?,?,?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1,contato.getTipoContato());
            ps.setInt(2,contato.getNumero());
            ps.setString(3,contato.getEmail());
            ps.setLong(4,contato.getId());

            if (ps.executeUpdate() >0){
                return contato;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
