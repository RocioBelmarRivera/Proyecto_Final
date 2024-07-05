package Conector;
import java.sql.*;
import utilitarios.CUtilitarios;
public class CConector {
    //********************* Atributos **************
    private  Connection conn;
    private final String DB="flecha_amarilla";
    private final String USER="root";
    private final String PSW="";
    private final String URL="jdbc:mysql://localhost:3306/"+DB;
    //************* Metodos **********
    public Connection conectar(){
        conn=null;
        try {
            conn=DriverManager.getConnection(URL,USER,PSW);
            if (conn==null) {
                CUtilitarios.msg_error("ERROR: CONEXION NO ESTABLECIDA", "Conexion");
            }
        } catch (SQLException ex) {
            String cadena = "SQLException: " + ex.getMessage() + "\n"
                    + "SQLState: "+ ex.getSQLState()+ "\n"
                    + "VendorError: "+ex.getErrorCode();
            CUtilitarios.msg_error(cadena,"conexion");
        }
        return conn;
    }
    
    public void cerrar_conexion(Connection conn) throws SQLException{
        conn.close();
    }
    
}
