package com.connectpool;

import java.sql.Connection;

/**
 * @BelongsProject: DataSourcePool
 * @BelongsPackage: com.bruceliu.pool
 * @CreateTime: 2020-10-28 14:24
 * @Description: TODO
 */
public class ConnectionPoolManager {

    private static DataSourceConfig config = new DataSourceConfig();
    private static ConnectionPool connectionPool = new ConnectionPool(config);

    // 获取连接(重复利用机制)
    public static Connection getConnection() {
        return connectionPool.getConn().getConn();
    }

    // 释放连接(可回收机制)
    public static void releaseConnection(Connection connection) {
        connectionPool.release(connection);
    }
}

