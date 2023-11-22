package br.com.medvirtua.java_global.model.repository;

import br.com.medvirtua.java_global.model.entity.Calendario;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalendarioRepository extends Repository{
    public static Calendario save(Calendario calendario){

        String sql= "insert into t_mdv_calendario(id_calendario,dt_marcada, nm_evento,tp_evento,id_usuario) " +
                "values(seq_id_calendario,?,?,?,?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setDate(1,Date.valueOf(calendario.getDataMarcada()));
            ps.setString(2, calendario.getNomeEvento());
            ps.setString(3, calendario.getTipoEvento());
            ps.setLong(4, calendario.getIdUsuario());

            if (ps.executeUpdate() >0){
                return calendario;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
}
