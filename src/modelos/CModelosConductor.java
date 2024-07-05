
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
        consulta = "SELECT * FROM conductor WHERE 1";
        return mngr.buscar_objetos(consulta);
    }

    public ArrayList<String[]> busca_objeto_id_model(int valor) throws SQLException {
        consulta = "SELECT * FROM conductor WHERE conductor.id_conductor = " + valor;
        return mngr.buscar_objetos(consulta);
    }

    public boolean inserta_objeto_model(String nombre, String apellidop, String apellidom) throws SQLException {
        consulta = "INSERT INTO `conductor`(`id_conductor`, `nombre`, `apellido_p`, `apellido_m`)"
                + "VALUES (null,'" + nombre + "','" + apellidop + "','" + apellidom + "');";
        return mngr.inserta_objeto(consulta);
    }

    public boolean elimina_objeto_model(int id) throws SQLException {
        consulta = "DELETE  FROM conductor WHERE conductor.id_conductor = " + id;
        return mngr.elimina_objeto(consulta);
    }

    public boolean actualiza_objeto_model(int id, String nombre,String apellidop,String apellidom) throws SQLException {
        consulta = "UPDATE conductor SET nombre='"+nombre+"', " +
                " apellido_p = '"+ apellidop+"', "+
                " apellido_m = '"+apellidom+"' " +
                "WHERE conductor.id_conductor= "+id;
        return mngr.actualiza_objeto(consulta);
    }

}
