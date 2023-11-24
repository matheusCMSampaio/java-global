package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.Medidas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedidasRepository extends Repository{
    public static Medidas save(Medidas medida) {
        String sql = "INSERT INTO T_MDV_MEDIDAS (NM_VACINA, ID_VACINA, DS_MEDIDA, ID_DOENCA, DS_REMEDIO,NM_REMEDIO) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, medida.getNomeVacina());
            ps.setLong(2, medida.getIdVacina());
            ps.setString(3, medida.getDescricaoMedida());
            ps.setLong(4, medida.getIdDoenca());
            ps.setString(5, medida.getDescricaoRemedio());
            ps.setString(6, medida.getNomeRemedio());

            if (ps.executeUpdate() > 0) {
                return medida;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Medidas> findAll() {
        ArrayList<Medidas> medidas = new ArrayList<Medidas>();
        String sql = "select * from T_MDV_MEDIDAS";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Medidas medida = new Medidas();
                medida.setIdDoenca(rs.getLong("ID_DOENCA"));
                medida.setIdVacina(rs.getLong("ID_VACINA"));
                medida.setNomeRemedio(rs.getString("NM_REMEDIO"));
                medida.setNomeVacina(rs.getString("NM_VACINA"));
                medida.setDescricaoMedida(rs.getString("DS_REMEDIO"));
                medida.setDescricaoRemedio(rs.getString("DS_MEDIDA"));
                medidas.add(medida);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return medidas;
    }

    public static boolean delete(Long id) {
        String sql = "delete from T_MDV_MEDIDAS where ID_VACINA = ?";
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

    public static Medidas update(Medidas medidas) {
        String sql = "UPDATE T_MDV_MEDIDAS SET NM_VACINA = ?, DS_MEDIDA = ?, DS_REMEDIO = ?, NM_REMEDIO = ?, ID_DOENCA=? WHERE ID_VACINA = ?";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, medidas.getNomeVacina());
            ps.setString(2, medidas.getDescricaoMedida());
            ps.setString(3, medidas.getDescricaoRemedio());
            ps.setString(4, medidas.getNomeRemedio());
            ps.setLong(5, medidas.getIdDoenca());
            ps.setLong(6, medidas.getIdVacina());

            if (ps.executeUpdate() > 0) {
                return medidas;
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
