/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Erweiterung;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;
import javax.sql.DataSource;

/**
 *
 * @author roman
 */
public class DatabaseManager {
    
    
    private static final String DATASOURCE = "jdbc/db";
    private static DatabaseManager connMgrInst = null;
    private DataSource ds = null;


    public static synchronized DatabaseManager getInst() {
        if (connMgrInst == null) {
            connMgrInst = new DatabaseManager();
        }
        return connMgrInst;
    }

    
    private DatabaseManager() {
        try {
            Context ctx;
            ctx = new javax.naming.InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/" + DATASOURCE);
        } catch (NamingException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.ALL, null, ex);
        }
    }

    public Connection getConn() {
        Connection retVal = null;
        try {
            retVal = ds.getConnection();   

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.ALL, null, ex);
        }

        return retVal;
    }
    
}
