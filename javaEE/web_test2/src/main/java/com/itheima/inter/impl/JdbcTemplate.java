package com.itheima.inter.impl;


import java.sql.*;
import java.util.*;

/**
 * @Package: com.itheima.inter.impl
 * @Author: PengSS
 * @Date: 2018/10/26 10:05
 */


public class JdbcTemplate {
    private DBType dataBaseType = DBType.ORACLE;
    private String userName = "";
    private String password = "";
    private String driver = "";
    private String connectionUrl = "";

    /**
     * 获取数据库用户名称
     *
     * @return
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置数据库用户名称
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取数据库用户密码
     *
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置数据库用户密码
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取数据库驱动程序
     *
     * @return
     */
    private String getDriver() {
        if (this.dataBaseType == DBType.ORACLE) {
            this.driver = "oracle.jdbc.driver.OracleDriver";
        } else if (this.dataBaseType == DBType.MYSQL) {
            this.driver = "com.mysql.jdbc.Driver";
        }
        return driver;
    }

    /**
     * 获取数据库连接URL
     *
     * @return
     */
    public String getConnectionUrl() {
        return this.connectionUrl;
    }

    /**
     * 设置数据库连接URL
     *
     * @param url
     */
    public void setConnectionUrl(String url) {
        this.connectionUrl = url;
    }

    /**
     * 默认构造函数。
     *
     * @param dataBaseType
     */
    public JdbcTemplate() {
    }

    /**
     * 构造函数，并确定数据库类型。
     *
     * @param dataBaseType
     */
    public JdbcTemplate(DBType dataBaseType) {
        this.dataBaseType = dataBaseType;
    }

    /**
     * 数据库连接对象
     */
    private Connection conn = null;

    /**
     * 获取数据库连接对象
     *
     * @return
     */
    public Connection getConnection() {
        try {
            if (this.conn == null || this.conn.isClosed()) {
                Class.forName(this.getDriver());
                this.conn = DriverManager.getConnection(getConnectionUrl(), getUserName(), getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.conn;
    }

    /**
     * SQL语句对象
     */
    private Statement stmt = null;

    /**
     * 执行增删改SQL语句
     *
     * @param strSql
     * @return
     */
    public boolean executeSql(String strSql) {
        if (strSql == null || strSql.isEmpty()) {
            return false;
        }
        try {
            //LogInfoUtil.printLog(strSql);
            this.stmt = this.getConnection().createStatement();
            this.stmt.execute(strSql);
            //execute返回值出现问题，即使SQL执行成功也会返回false的。
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 批量执行增删该SQL语句
     *
     * @param strSqlList
     */
    public void executeSql(List<String> strSqlList) {
        if (strSqlList == null || strSqlList.size() == 0) {
            return;
        }
        try {
            this.stmt = this.getConnection().createStatement();
            //每500作为一个插入批量操作
            int batchSize = 500;
            int count = 0;
            for (String strSql : strSqlList) {
                //LogInfoUtil.printLog(strSql);
                this.stmt.addBatch(strSql);
                if (++count % batchSize == 0) {
                    this.stmt.executeBatch();
                }
            }
            //插入剩余的数据
            this.stmt.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SQL检索语句结果集中的列名称及类型信息。
     *
     * @param strSql
     * @return
     */
    public TreeMap<String, Integer> getColumnTypeList(String strSql) {
        TreeMap<String, Integer> columnTypeList = new TreeMap<String, Integer>();
        try {
            // LogInfoUtil.printLog(strSql);
            this.stmt = this.getConnection().createStatement();
            ResultSet rs = this.stmt.executeQuery(strSql);
            //获取数据集的列信息
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnTypeList.put(columnName, rsmd.getColumnType(i));
            }
            rs.close();
            return columnTypeList;
        } catch (Exception e) {
            e.printStackTrace();
            return columnTypeList;
        }
    }

    /**
     * 获取SQL检索语句结果集中的列名称及类型信息。
     *
     * @param strSql
     * @return
     */
    public TreeMap<String, String> getColumnTypeNameList(String strSql) {
        TreeMap<String, String> columnTypeList = new TreeMap<String, String>();
        try {
            //LogInfoUtil.printLog(strSql);
            this.stmt = this.getConnection().createStatement();
            ResultSet rs = this.stmt.executeQuery(strSql);
            //获取数据集的列信息
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnTypeList.put(columnName, rsmd.getColumnTypeName(i));
            }
            rs.close();
            return columnTypeList;
        } catch (Exception e) {
            e.printStackTrace();
            return columnTypeList;
        }
    }

    /**
     * 执行SQL查询语句,将结果以List<Properties>形式组装返回.
     *
     * @param strSql
     * @return
     */
    public List<Properties> executeQuery(String strSql) {
        List<Properties> propertiesList = new ArrayList<Properties>();
        if (strSql == null || strSql.isEmpty()) {
            return propertiesList;
        }

        try {
            //LogInfoUtil.printLog(strSql);
            this.stmt = this.getConnection().createStatement();
            ResultSet rs = this.stmt.executeQuery(strSql);
            //获取数据集的列信息
            ResultSetMetaData rsmd = rs.getMetaData();
            HashMap<String, Integer> columnList = new HashMap<String, Integer>();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnList.put(columnName, rsmd.getColumnType(i));
            }

            while (rs.next()) {
                Properties properties = new Properties();
                for (String columnLabel : columnList.keySet()) {
                    int columnType = columnList.get(columnLabel);
                    Object columnValue = null;

                    switch (columnType) {
                        case Types.VARCHAR:
                            columnValue = rs.getString(columnLabel);
                            break;
                        case Types.NUMERIC:
                            columnValue = rs.getBigDecimal(columnLabel);
                            break;
                        case Types.DATE:
                            columnValue = rs.getDate(columnLabel).toString() + " " + rs.getTime(columnLabel).toString();
                            break;
                        case Types.NVARCHAR:
                            columnValue = rs.getNString(columnLabel);
                            break;
                        case Types.DECIMAL:
                            columnValue = rs.getBigDecimal(columnLabel);
                            break;
                        case Types.FLOAT:
                            columnValue = rs.getFloat(columnLabel);
                            break;
                        case Types.DOUBLE:
                            columnValue = rs.getDouble(columnLabel);
                            break;
                        case Types.BOOLEAN:
                            columnValue = rs.getBoolean(columnLabel);
                            break;
                        case Types.INTEGER:
                            columnValue = rs.getInt(columnLabel);
                            break;
                        case Types.BIGINT:
                            columnValue = rs.getLong(columnLabel);
                            break;
                        case Types.TIME:
                            columnValue = rs.getTime(columnLabel);
                            break;
                        case Types.BLOB:
                            columnValue = rs.getBlob(columnLabel);
                            break;
                        case Types.CLOB:
                            columnValue = rs.getClob(columnLabel);
                            break;
                        default:
                            columnValue = rs.getObject(columnLabel);
                            break;
                    }

                    if (columnValue == null) {
                        properties.put(columnLabel, "");
                    } else {
                        properties.put(columnLabel, columnValue);
                    }
                }
                propertiesList.add(properties);
            }
            rs.close();
            return propertiesList;
        } catch (Exception e) {
            e.printStackTrace();
            return propertiesList;
        }
    }

    public void update(String strSql, Object... arr) throws SQLException {
        this.stmt = this.getConnection().createStatement();
        for (Object o : arr) {
            strSql = strSql.replaceFirst("\\?", o.toString());
        }
      this.stmt.executeUpdate(strSql);
    }
    /**
     * 获取指定表中的记录总数
     *
     * @param tableName 指定表名称
     * @return 表中的记录总数
     */
    public int getTableRecordTotalCount(String tableName) {
        int totalCount = 0;
        String strSql = "select count(rowid) as RECORD_COUNT from " + tableName;
        try {
            // LogInfoUtil.printLog(strSql);
            this.stmt = this.getConnection().createStatement();
            ResultSet rs = this.stmt.executeQuery(strSql);
            while (rs.next()) {
                totalCount = rs.getInt("RECORD_COUNT");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalCount;
    }

    /**
     * 释放连接资源
     */
    public void close() {
        try {
            if (this.stmt != null) {
                this.stmt.close();
                this.stmt = null;
            }
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取指定的JDBC Properties文件，初始化数据连接信息。
     *
     * @param jdbcPropertiesFile
     */
    public void initJdbcTemplate(String jdbcPropertiesFile) {
        HashMap<String, String> pps = PropertiesUtil.readProperties(jdbcPropertiesFile);
        String url = pps.get("jdbc.url");
        String userName = pps.get("jdbc.username");
        String password = pps.get("jdbc.password");
        this.connectionUrl = url;
        this.userName = userName;
        this.password = password;
    }


}