package br.com.asamistudiohair.main;

import br.com.asamistudiohair.dao.AppointmentDAO;
import br.com.asamistudiohair.dao.UsersDAO;
import br.com.asamistudiohair.model.Appointment;
import br.com.asamistudiohair.model.Users;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args){
    deleteByEmail();

    }

    public static void create(){
        AppointmentDAO appDAO = new AppointmentDAO();

        Appointment app = new Appointment();
        app.setClient(3);
        app.setEmployee(4);
        app.setDatetime(LocalDateTime.now());
        app.setPrice(4.10);
        app.setDescription("Corte de cabelo");

        appDAO.createAppointment(app);
    }

    public static void readAll(){
        AppointmentDAO appDAO = new AppointmentDAO();
        for(Appointment a : appDAO.readAppointments()){
            System.out.println("Date: " + a.getDatetime());
            System.out.println("Price: " + a.getPrice());
            System.out.println("Description: " + a.getDescription());
        }
    }

    public static void update(){
        AppointmentDAO appDAO = new AppointmentDAO();
        Appointment app = new Appointment();
        app.setDatetime(LocalDateTime.now());
        app.setDescription("Fazer barba");
        app.setId(1);
        app.setClient(3);
        app.setEmployee(4);
        app.setPrice(5.14);


        appDAO.updateAppointment(app);
    }

    public static void deleteByEmail(){
        AppointmentDAO appDAO = new AppointmentDAO();

        appDAO.deleteAppointmentById(1);
    }
}
