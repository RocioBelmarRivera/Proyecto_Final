
package modelos;

import GestorOperaciones.CQManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class CModelosConductor {
    
    //****************** Atributos***********
    private final CQManager mngr = new CQManager();
    private String consulta;
    //****************** Metodos*************

    public ArrayList<String[]> busca_objetos_model() throws SQLException {
        consulta = "SELECT * FROM auto WHERE 1";
        return mngr.buscar_objetos(consulta);
    }

    public ArrayList<String[]> busca_objeto_id_model(int valor) throws SQLException {
        consulta = "SELECT * FROM auto WHERE auto.id = " + valor;
        return mngr.buscar_objetos(consulta);
    }

    public boolean inserta_objeto_model(String marca, String modelo, String color) throws SQLException {
        consulta = "INSERT INTO `auto`(`id`, `marca`, `modelo`, `color`)"
                + "VALUES (null,'" + marca + "','" + modelo + "','" + color + "');";
        return mngr.inserta_objeto(consulta);
    }

    public boolean elimina_objeto_model(int id) throws SQLException {
        consulta = "DELETE  FROM auto WHERE auto.id = " + id;
        return mngr.elimina_objeto(consulta);
    }

    public boolean actualiza_objeto_model(int id, String marca,String modelo,String color) throws SQLException {
        consulta = "UPDATE auto SET marca='"+marca+"', " +
                " modelo = '"+ modelo+"', "+
                " color = '"+color+"' " +
                "WHERE auto.id= "+id;
        return mngr.actualiza_objeto(consulta);
    }

}
