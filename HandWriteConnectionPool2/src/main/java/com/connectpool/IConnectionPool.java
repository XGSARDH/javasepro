package com.connectpool;

import java.sql.Connection;

/**
 * @BelongsProject: DataSourcePool
 * @BelongsPackage: com.bruceliu.pool
 * @CreateTime: 2020-10-28 14:22
 * @Description: TODO
 */
public interface IConnectionPool {

    // 获取连接(重复利用机制)
    public  Connection createConn();

    // 释放连接(可回收机制)
    public  void release(Connection conn);
}
