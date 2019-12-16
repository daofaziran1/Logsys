package cn.zut.edu.logcol.logcollecttion.dao;

import java.sql.*;
import java.util.LinkedList;

public class MysqlUtil {
    private  String url = "node03";
    private  String port = "3306";
    private  String user = "root";
    private  String password = "123456";
    private  Connection conn;
    public MysqlUtil() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://" + url + ":" + port + "/Logsys?useUnicode=true&characterEncoding=utf-8&useSSL=false", user,
                    password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  boolean insert(String sim, String tol) {
        String sql = "insert into province values(?,?)";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, sim);
            pst.setString(2, tol);
            return pst.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public  void insert(String table,String IP, String loc) {
        String sql = "insert into "+table+" values(?,?)";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, IP);
            pst.setString(2, loc);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  int delete(String sim) {
        String sql = "delete from Logsys.province  where sim=?";
        PreparedStatement pst;

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, sim);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public  String catchSim(String name){
        String sql="select sim from Logsys.province where tol=?";
        String result="WG";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,name);
            ResultSet rs =stmt.executeQuery();
            if(rs.next())
                result=rs.getString("sim");
        }catch (SQLException e){
            System.out.println("查询有误");
        }
        return result;
    }
    public  String catchLoc(String IP){
        String sql="select loc from iploc where ip=?";
        String result=null;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,IP);
            ResultSet rs =stmt.executeQuery();
            if(!rs.next())return result;
            result=rs.getString("loc");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询有误");
        }
        return result;
    }
    public LinkedList<String> getIPS(){
        LinkedList<String> list=new LinkedList<String>();
        try{
            String sql="select * from iptable";
            Statement stmt=conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                list.add(rs.getString("ip"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public void deleteIP(String ip){
        try{
            String sql="delete from iptable where ip=?";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, ip);
            int x=stmt.executeUpdate();
            if(x==0)System.out.println("删除失败");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String sim="NA";
        new MysqlUtil(). delete(sim);
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }
    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }/**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
}
