package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.Doenca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoencaRepository extends Repository {
    public static Doenca save(Doenca doenca) {
        String sql = "insert into t_mdv_doencas(nm_doenca,tp_doenca,fx_etaria,ds_doenca,id_usuario,id_doenca) " +
                "values(?,?,?,?,?,seq_id_doenca.nextval)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, doenca.getNome());
            ps.setString(2, doenca.getTipo());
            ps.setString(3, doenca.getFaixaEtaria());
            ps.setString(4, doenca.getDescricao());
            ps.setLong(5, doenca.getIdUsuario());

            if (ps.executeUpdate() > 0) {
                return doenca;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public static ArrayList<Doenca> findAll() {
        ArrayList<Doenca> doencas = new ArrayList<Doenca>();
        String sql = "select * from T_MDV_DOENCAS";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Doenca doenca = new Doenca();
                doenca.setIdDoenca(rs.getLong("ID_DOENCA"));
                doenca.setIdUsuario(rs.getLong("ID_USUARIO"));
                doenca.setDescricao(rs.getString("DS_DOENCA"));
                doenca.setFaixaEtaria(rs.getString("FX_ETARIA"));
                doenca.setTipo(rs.getString("TP_DOENCA"));
                doenca.setNome(rs.getString("NM_DOENCA"));
                doencas.add(doenca);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return doencas;
    }

    public static boolean delete(Long id) {
        String sql = "delete from T_MDV_DOENCAS where ID_DOENCA = ?";
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

    public static Doenca update(Doenca doenca) {
        String sql = "UPDATE T_MDV_DOENCAS SET NM_DOENCA = ?, TP_DOENCA = ?, FX_ETARIA = ?, DS_DOENCA = ?, ID_USUARIO = ?" +
                "WHERE ID_DOENCA = ?";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, doenca.getNome());
            ps.setString(2, doenca.getTipo());
            ps.setString(3, doenca.getFaixaEtaria());
            ps.setString(4, doenca.getDescricao());
            ps.setLong(5, doenca.getIdUsuario());
            ps.setLong(6, doenca.getIdDoenca());

            if (ps.executeUpdate() > 0) {
                return doenca;
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
