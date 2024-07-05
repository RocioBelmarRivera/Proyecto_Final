package GestorOperaciones;
import Conector.CConector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import utilitarios.CUtilitarios;

public class CQManager {
     private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private final CConector conector = new CConector();
    private ArrayList<String[]> resultados;

    //***************** METODOS **************
    public ArrayList<String[]> buscar_objetos(String consulta) throws SQLException {
        //1. Abrir la conexion 
        conn = conector.conectar();
        //2. Ejecutar la query(consulta)
        try {
            resultados = new ArrayList<>();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            if (rs == null) {
                CUtilitarios.msg_adver("Elementos no encontrados", "Buscar objeto");
            } else {
                while (rs.next()) {
                    resultados.add(new String[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                    });
                }
            }
        } catch (SQLException ex) {
            String cadena = "SQLException: " + ex.getMessage() + "\n"
                    + "SQLState: " + ex.getSQLState() + "\n"
                    + "VendorError: " + ex.getErrorCode();
            CUtilitarios.msg_error(cadena, "conexion");
        } finally {
            //CERRAR RESULTADOS
            try {
                rs.close();
            } catch (SQLException e) {
            }
            //cerrar statement
            try {
                stmt.close();
            } catch (SQLException e) {
            }
            //cerrar conexion
            conector.cerrar_conexion(conn);
        }
        return resultados;
    }

    public boolean inserta_objeto(String consulta) throws SQLException {
        //1. abrir la conexion
        conn = conector.conectar();
        //2.- ejecutar la query
        try {
            PreparedStatement pstmt = conn.prepareStatement(consulta);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            CUtilitarios.msg_error("ERROR: \n" + e.getMessage(), "inserta objeto");
        } finally {
            //3. Cerrar la conexion
            conector.cerrar_conexion(conn);
        }
        return false;
    }

    public boolean elimina_objeto(String consulta) throws SQLException {
        //1.- abrir conexion
        conn = conector.conectar();
        //2.- Ejecutar la Query
        try {
            PreparedStatement pstmt = conn.prepareStatement(consulta);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            CUtilitarios.msg_error("ERROR: " + e.getMessage(), "Elimina objeto");
        } finally {
            //3.- cerrar la conexion
            conector.cerrar_conexion(conn);
        }
        return false;

    }

    public boolean actualiza_objeto(String consulta) throws SQLException {
        conn = conector.conectar();
        try {
            PreparedStatement pstmt = conn.prepareStatement(consulta);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            CUtilitarios.msg_error("Error: " + e.getMessage(), "actualiza objeto");
        } finally {
            conector.cerrar_conexion(conn);
        }
        return false;
    }

    public void imprime_resultados(ArrayList<String[]> resultados) {
        for (int i=0 ;i<resultados.size();i++) {
            System.out.println(i + " "+ Arrays.toString(resultados.get(i)));
        }
        System.out.println("...................");
    }
    
}
