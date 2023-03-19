package Modelos;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;


public class Mostrar_Historial {

    public Modelo Comparar(String MiUs) {
        Modelo m = new Modelo();
        ResultSet rs = null;
        BD.BDConex bd = new BD.BDConex();

        rs = bd.consultar("SELECT id FROM usuario WHERE Nombre='" + MiUs + "';");

        try {
            if (rs.first()) {

                rs.beforeFirst();
                rs.next();
                m.setId_usuario(rs.getString("id"));
                ResultSet res;
                
                String id_t = m.getId_usuario();

                res = bd.consultar("SELECT id FROM paciente WHERE id_usuario ='" + id_t + "';");

                try {
                    if (res.first()) {

                        res.beforeFirst();
                        res.next();
                        m.setId_paciente(res.getString("id"));
                        
                    } else {
                        m = null;
                    }
                System.out.println(res.getString("id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                bd.desconectar();
                return m;

            } else {
                m = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        bd.desconectar();
        return m;

    }
}
/*String sql = "SELECT id FROM usuario WHERE Nombre='" + MiUs + "';";
         Statement st;

         String[] Ht = new String[4];

         try {
         st = cn.createStatement();
         ResultSet result = st.executeQuery(sql);
         while (result.next()) {
         //Obtener el Tipo de Usuario
         Ht[0] = result.getString(1);
         String id_t = Ht[0];
         System.out.println(id_t);

         //Obtener el id del usuario
         String cons = "SELECT id FROM paciente WHERE id_usuario ='" + id_t + "';";
         Statement cons_st;

         String[] cons_ht = new String[4];

         try {
         cons_st = cn.createStatement();
         ResultSet res = cons_st.executeQuery(cons);
         while (res.next()) {
         cons_ht[0] = res.getString(1);
         String id_paciente = cons_ht[0];
         System.out.println(id_paciente);
         }

         } catch (SQLException ex) {
         Logger.getLogger(Mostrar_Historial.class
         .getName()).log(Level.SEVERE, null, ex);
         }

         }

         } catch (SQLException ex) {
         Logger.getLogger(Mostrar_Historial.class
         .getName()).log(Level.SEVERE, null, ex);
         }
         return m;*/