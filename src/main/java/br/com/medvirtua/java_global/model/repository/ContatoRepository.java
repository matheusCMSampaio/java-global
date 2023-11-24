package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.Contato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContatoRepository extends Repository {
    public static Contato save(Contato contato) {
        String sql = "insert into t_mdv_contato(tp_contato, nr_telefone, nm_email, id_usuario) values(?,?,?,?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, contato.getTipoContato());
            ps.setLong(2, contato.getNumero());
            ps.setString(3, contato.getEmail());
            ps.setLong(4, contato.getId());

            if (ps.executeUpdate() > 0) {
                return contato;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Contato> findAll() {
        ArrayList<Contato> contatos = new ArrayList<Contato>();
        String sql = "select * from T_MDV_CONTATO";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getLong("ID_USUARIO"));
                contato.setEmail(rs.getString("NM_EMAIL"));
                contato.setTipoContato(rs.getString("TP_CONTATO"));
                contato.setNumero(rs.getLong("NR_TELEFONE"));

                contatos.add(contato);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return contatos;
    }

    public static boolean delete(Long id) {
        String sql = "delete from T_MDV_CONTATO where ID_USUARIO = ?";
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

    public static Contato update(Contato contato) {
        String sql = "UPDATE T_MDV_CONTATO SET TP_CONTATO = ?, NR_TELEFONE = ?, NM_EMAIL = ? WHERE ID_USUARIO = ?";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, contato.getTipoContato());
            ps.setLong(2, contato.getNumero());
            ps.setString(3, contato.getEmail());
            ps.setLong(4, contato.getId());

            if (ps.executeUpdate() > 0) {
                return contato;
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
