package br.com.asamistudiohair.dao;

import br.com.asamistudiohair.factory.ConnectionFactory;
import br.com.asamistudiohair.model.Appointment;
import br.com.asamistudiohair.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public void createAppointment(Appointment appointment){
        String sql = "INSERT INTO appointment(client, employee, datetime, price, description) VALUES(?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, appointment.getClient());
            pstm.setInt(2, appointment.getEmployee());
            pstm.setTimestamp(3, Timestamp.valueOf(appointment.getDatetime()));
            pstm.setDouble(4, appointment.getPrice());
            pstm.setString(5, appointment.getDescription());

            pstm.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Appointment> readAppointments(){
        String sql = "SELECT * FROM appointment";
        List<Appointment> apps = new ArrayList<Appointment>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rst = pstm.executeQuery();
            while (rst.next()){
                Appointment app = new Appointment();
                app.setId(rst.getInt("id"));
                app.setClient(rst.getInt("client"));
                app.setEmployee(rst.getInt("employee"));
                app.setDatetime(rst.getTimestamp("datetime").toLocalDateTime());
                app.setPrice(rst.getDouble("price"));
                app.setDescription(rst.getString("description"));
                apps.add(app);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return apps;
    }

    public List<Appointment> readAppointmentsByEmployee(Users user){
        String sql = "SELECT * FROM appointment WHERE employee = ?";
        List<Appointment> apps = new ArrayList<Appointment>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, user.getId());
            rst = pstm.executeQuery();
            while (rst.next()){
                Appointment app = new Appointment();
                app.setId(rst.getInt("id"));
                app.setEmployee(rst.getInt("employee"));
                app.setDatetime(rst.getTimestamp("datetime").toLocalDateTime());
                app.setPrice(rst.getDouble("price"));
                app.setDescription(rst.getString("description"));
                apps.add(app);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return apps;
    }

    public List<Appointment> readAppointmentsByClient(Users user){
        String sql = "SELECT * FROM appointment WHERE client = ?";
        List<Appointment> apps = new ArrayList<Appointment>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, user.getId());
            rst = pstm.executeQuery();
            while (rst.next()){
                Appointment app = new Appointment();
                app.setId(rst.getInt("id"));
                app.setClient(rst.getInt("client"));
                app.setDatetime(rst.getTimestamp("datetime").toLocalDateTime());
                app.setPrice(rst.getDouble("price"));
                app.setDescription(rst.getString("description"));
                apps.add(app);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return apps;
    }

    public List<Appointment> readAppointmentsByDatetime(LocalDateTime datetime){
        String sql = "SELECT * FROM appointment WHERE datetime = ?";
        List<Appointment> apps = new ArrayList<Appointment>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setTimestamp(1, Timestamp.valueOf(datetime));
            rst = pstm.executeQuery();
            while (rst.next()){
                Appointment app = new Appointment();
                app.setId(rst.getInt("id"));
                app.setEmployee(rst.getInt("employee"));
                app.setClient(rst.getInt("client"));
                app.setPrice(rst.getDouble("price"));
                app.setDescription(rst.getString("description"));
                apps.add(app);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return apps;
    }

    public void updateAppointment(Appointment appointment){
        String sql = "UPDATE appointment SET client = ?, employee = ?, datetime = ?, price = ?, description = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, appointment.getClient());
            pstm.setInt(2, appointment.getEmployee());
            pstm.setTimestamp(3, Timestamp.valueOf(appointment.getDatetime()));
            pstm.setDouble(4, appointment.getPrice());
            pstm.setString(5, appointment.getDescription());
            pstm.setInt(6, appointment.getId());

            pstm.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(conn != null){
                    conn.close();
                }
                if(pstm != null){
                    pstm.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void deleteAppointmentById(int id){
        String sql = "DELETE FROM appointment WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
