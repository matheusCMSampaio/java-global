package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.Calendario;
import br.com.medvirtua.java_global.model.entity.Contato;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CalendarioRepository extends Repository {
    public static Calendario save(Calendario calendario) {

        String sql = "insert into t_mdv_calendario(id_calendario,dt_marcada, nm_evento,tp_evento,id_usuario) " +
                "values(seq_id_calendario.nextval,?,?,?,?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setDate(1, Date.valueOf(calendario.getDataMarcada()));
            ps.setString(2, calendario.getNomeEvento());
            ps.setString(3, calendario.getTipoEvento());
            ps.setLong(4, calendario.getIdUsuario());

            if (ps.executeUpdate() > 0) {
                return calendario;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public static ArrayList<Calendario> findAll() {
        ArrayList<Calendario> calendarios = new ArrayList<Calendario>();
        String sql = "select * from T_MDV_CALENDARIO";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Calendario calendario = new Calendario();
                calendario.setIdCalendario(rs.getLong("ID_USUARIO"));
                calendario.setIdCalendario(rs.getLong("ID_CALENDARIO"));
                calendario.setTipoEvento(rs.getString("TP_EVENTO"));
                calendario.setNomeEvento(rs.getString("NM_EVENTO"));
                calendario.setDataMarcada((rs.getDate("DT_MARCADA").toLocalDate()));
                calendarios.add(calendario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return calendarios;
    }

    public static boolean delete(Long id) {
        String sql = "delete from T_MDV_CALENDARIO where id_calendario = ?";
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

    public static Calendario update(Calendario calendario) {
        String sql = "UPDATE T_MDV_CALENDARIO SET DT_MARCADA = ?, NM_EVENTO = ?, TP_EVENTO = ?, ID_USUARIO = ? WHERE ID_CALENDARIO = ?";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setDate(1, Date.valueOf(calendario.getDataMarcada()));
            ps.setString(2, calendario.getNomeEvento());
            ps.setString(3, calendario.getTipoEvento());
            ps.setLong(4, calendario.getIdUsuario());
            ps.setLong(5, calendario.getIdCalendario());

            if (ps.executeUpdate() > 0) {
                return calendario;
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
