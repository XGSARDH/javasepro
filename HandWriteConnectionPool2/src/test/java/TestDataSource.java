

import com.connectpool.ConnectionPoolManager;

import java.sql.Connection;

/**
 * @BelongsProject: DataSourcePool
 * @BelongsPackage: com.bruceliu.test
 * @CreateTime: 2020-10-27 23:38
 * @Description: TODO
 */
public class TestDataSource {

    public static void main(String[] args) {
        ThreadConnection threadConnection = new ThreadConnection();
        for (int i = 1; i <=8; i++) {
            Thread thread = new Thread(threadConnection, "线程:" + i);
            thread.start();
        }
    }

}

class ThreadConnection implements Runnable {

    public void run() {
        Connection connection = ConnectionPoolManager.getConnection();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        ConnectionPoolManager.releaseConnection(connection);
    }

}
