package com.example.dam2m8_exemplellistadetall.PSQL;


import com.example.dam2m8_exemplellistadetall.Model.Esdeveniment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgressConnection {

    private Esdeveniment esdeveniment;

    public PostgressConnection(Esdeveniment esdeveniment) {
        this.esdeveniment = esdeveniment;
    }

    public final Thread sqlThread = new Thread() {
        public void run() {
            Connection conn = null;


            try {
                Class.forName("org.postgresql.Driver");

                conn = DriverManager.getConnection(
                        "jdbc:postgresql://192.168.0.22:5432/esdeveniments",
                        "maggy",
                        "hamilton"
                );

                Statement st = conn.createStatement();


                st.executeUpdate("INSERT INTO eventdetail values('" + esdeveniment.getTitle() + "', '02/28/2020', '" + esdeveniment.getLloc() + "', '" + esdeveniment.getOrganitzador() + "', '" + esdeveniment.getSala() + "', '" + esdeveniment.getPreu() + "', '" + esdeveniment.getAforament() + "', '" + esdeveniment.getDescripcio() + "');");


            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
