package com.jhamobi.trackiya.server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jhamobi.trackiya.server.tomcat.TrackiyaConstants;




/**
 * 
 * @author majha
 * 
 */
public class TrackiyaDBConnectionManager {

    static private TrackiyaDBConnectionManager instance; // The single instance
    static private int clients;

//    private List<Driver> drivers = new ArrayList<Driver>();
    private ConcurrentHashMap<String, DBConnectionPool> pools = new ConcurrentHashMap<String, DBConnectionPool>();

    // *****************************************************************
    // Returns the single instance.
    // *****************************************************************
    static synchronized TrackiyaDBConnectionManager getInstance() {
        if (instance == null) {
            instance = new TrackiyaDBConnectionManager();
        }
        clients++;
        return instance;
    }

    // *****************************************************************
    // Private constructor (singleton).
    // *****************************************************************
    private TrackiyaDBConnectionManager() {
    }

    // *****************************************************************
    // Returns a connection to the named pool.
    //
    // @param name Pool name.
    // @param con Connection.
    // *****************************************************************
    public void freeConnection(String name, Connection con) throws SQLException {
    	if(!con.isClosed()){
    		TrackiyaConstants.LOGGER.info("Closing DB connection");
    		con.close();
    		TrackiyaConstants.LOGGER.info("DB connection");
    	}
//        DBConnectionPool pool =  pools.get(name);
//        if (pool != null) {
//            pool.freeConnection(con);
//        }
    }

    // *****************************************************************
    // Returns an open connection. If no one is available, and the max
    // number of connections has not been reached, a new connection is
    // created.
    //
    // @param name Pool name.
    // @return Connection The connection or null.
    // *****************************************************************
    public Connection getConnection(String name) throws Exception {
    	TrackiyaConstants.LOGGER.info("Getting DB Connection");
    	Context initContext =new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/trackiya");
		Connection conn = ds.getConnection();
		TrackiyaConstants.LOGGER.info("Got DB Connection");
//		if (conn == null) {
//			DBConnectionPool pool = pools.get(name);
//			if (pool != null) {
//				return pool.getConnection();
//			}
//		}
        return conn;
    }

    // *****************************************************************
    // Closes all open connections and deregisters all drivers.
    // *****************************************************************
    public synchronized void release() throws RuntimeException {
        // Wait until called by the last client
        if (--clients != 0) {
            return;
        }

        Enumeration<DBConnectionPool> allPools = pools.elements();
        while (allPools.hasMoreElements()) {
            DBConnectionPool pool =  allPools.nextElement();
            pool.release();
        }
        pools.clear();
    }
    
    // *****************************************************************
    // Closes all open connections and deregisters all drivers.
    // *****************************************************************
    public synchronized void release(String poolName) throws RuntimeException {
        // Wait until called by the last client
        if (--clients != 0) {
            return;
        }
        DBConnectionPool dbConnectionPool = pools.get(poolName);
        if(dbConnectionPool != null){
        	dbConnectionPool.release();
        }
    }

    // *****************************************************************
    // Creates instances of DBConnectionPool.
    //
    // @param poolName Pool name.
    // @param url JDBC URL for the database.
    // @param user Database user.
    // @param password Database password.
    // @param maxconn Maximum number of connections.
    // *****************************************************************
    public synchronized void createPool(String poolName, String url, String user, String password, int maxconn, int retry) {
    	DBConnectionPool dbConnectionPool = pools.get(poolName);
    	if(dbConnectionPool == null){
    		DBConnectionPool pool = 
                new DBConnectionPool(poolName, url, user, password, maxconn, retry);
    		pools.put(poolName, pool);
    	} 
    }
    
    
    
    

    // *****************************************************************
    // Creates instances of DBConnectionPool.
    //
    // @param poolName Pool name.
    // @param url JDBC URL for the database.
    // @param user Database user.
    // @param password Database password.
    // @param maxconn Maximum number of connections.
    // *****************************************************************
    public boolean exist(String poolName) {
        return pools.containsKey(poolName);
    }



    // *****************************************************************
    // This inner class represents a connection pool. It creates new
    // connections on demand, up to a max number if specified.
    // It also makes sure a connection is still open before it is
    // returned to a client.
    // *****************************************************************
    public class DBConnectionPool {
        private int checkedOut;
        private int maxConn;
        private int connRetry = 1;               // no retry
        private int connRetryInterval = 2; // in seconds

        protected String name;
        private String password;
        private String URL;
        private String user;
		private List<Connection> freeConnections;

        // *****************************************************************
        // Creates new connection pool.
        //
        // @param name The pool name
        // @param URL The JDBC URL for the database
        // @param user The database user, or null
        // @param password The database user password, or null
        // @param maxConn The maximal number of connections, or 0 
        //                for no limit.
        // *****************************************************************
        public DBConnectionPool(String name, String URL, String user, String password, int maxConn, int retry) {
            if (retry != 0)
                connRetry = retry;
            this.name = name;
            this.URL = URL;
            this.user = user;
            this.password = password;
            this.maxConn = maxConn;
            freeConnections = new ArrayList<Connection>(maxConn);
        }

        // *****************************************************************
        // Checks in a connection to the pool. Notify other Threads that
        // may be waiting for a connection.
        //
        // @param con The connection to check in
        // *****************************************************************
        public synchronized void freeConnection(Connection con) {
            // Put the connection at the end of the Vector
            freeConnections.add(con);
            checkedOut--;
            notifyAll();
        }

        // *****************************************************************
        // Checks out a connection from the pool. If no free connection
        // is available, a new connection is created unless the max
        // number of connections has been reached. If a free connection
        // has been closed by the database, it's removed from the pool
        // and this method is called again recursively.
        // *****************************************************************
        public synchronized Connection getConnection() throws RuntimeException {

            Connection con = null;
            if (freeConnections.size() > 0) {
                // Pick the first Connection in the Vector
                // to get round-robin usage
               
                try {
                	 con = freeConnections.remove(0);
                    if (con.isClosed()) {
                        // Try again recursively
                        con = getConnection();
                    }
                } 
                catch (SQLException e) {
                    // Try again recursively
                    con = getConnection();
                }
            } 
            else if (maxConn == 0 || checkedOut < maxConn) {
                con = newConnection();
            }
            if (con != null) {
                checkedOut++;
            }
            return con;
        }

        // *****************************************************************
        // Checks out a connection from the pool. If no free connection
        // is available, a new connection is created unless the max
        // number of connections has been reached. If a free connection
        // has been closed by the database, it's removed from the pool
        // and this method is called again recursively.
        // <P>
        // If no connection is available and the max number has been
        // reached, this method waits the specified time for one to be
        // checked in.
        //
        // @param timeout The timeout value in milliseconds
        // *****************************************************************
        public synchronized Connection getConnection(long timeout) throws RuntimeException {

            long startTime = new Date().getTime();
            Connection con;
            while ((con = getConnection()) == null) {
                try {
                    wait(timeout);
                } 
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if ((new Date().getTime() - startTime) >= timeout) {
                    // Timeout has expired
                    return null;
                }
            }
            return con;
        }

        // *****************************************************************
        // Closes all available connections.
        // *****************************************************************
        public synchronized void release() throws RuntimeException {
        	
            Iterator<Connection> allConnections = freeConnections.iterator();
            while (allConnections.hasNext()) {
                Connection con =  allConnections.next();
                try {
                    con.close();
                } 
                catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            freeConnections.clear();
        }

        // *****************************************************************
        // Creates a new connection, using a userid and password
        // if specified.
        // *****************************************************************
        private Connection newConnection() throws RuntimeException {

            int counter = 1;
            Connection con = null;
            while (counter <= connRetry || connRetry == -1) {

                try {

                    if (counter > 1)
                        System.out.println("Retrying connection...");

                    if (counter > 1)
                        wait(connRetryInterval * 1000); // if this is a retry then wait

                    if (user == null) {
                        con = DriverManager.getConnection(URL);
                    } else {
                        con = DriverManager.getConnection(URL, user, password);
                    }
                    return con;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    if (counter++ > connRetry) {
                        //ExceptionOutput.outputStackTrace(new Exception("Max number of retry attempts encountered."), "DBConnectionManager:newConnection()");
                        throw new RuntimeException(e);
                    }
                } catch (Throwable t) {
                	t.printStackTrace();
                	throw new RuntimeException(t);
                }
            }
            return con;
        }
        

    }
//    public static void main(String[] args) {
////    	String poolName = "DB2";
////    	String url = "jdbc:db2://10.97.118.10:50000/SAMPLE";
////    	String user = "db2admin";
////    	String password = "admin";
//    	
////    	String poolName = "MYSQL";
////    	String url = "jdbc:mysql://10.97.118.10:3306/mysql";
////    	String user = "root";
////    	String password = "sa";
//
//    	String poolName = "SQLSERVER";
//    	String url = "jdbc:sqlserver://10.97.118.10:1433;databasename=master";
//    	String user = "sa";
//    	String password = "admin";
//    	
//    	int maxconn = 1;
//    	int retry = -1;
//    	DBConnectionManager dbcm = DBConnectionManager.getInstance();
//    	dbcm.createPool(poolName, url, user, password, maxconn, retry);
//    	try {
//    		Connection c = dbcm.getConnection(poolName);
//    		dbcm.freeConnection(poolName, c);
//    		dbcm.release();
//    		System.out.println("Done...");
//    	} catch (Throwable e) {
//    		e.printStackTrace();
//    	}
//    }

}