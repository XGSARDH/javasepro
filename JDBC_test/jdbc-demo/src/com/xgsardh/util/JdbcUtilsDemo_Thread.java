package src.com.xgsardh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtilsDemo_Thread {
    public static void main(String[] args)throws Exception {
        Thread thread0 = new Thread(new MyRunnable1());
        Thread thread1 = new Thread(new MyRunnable2());

        thread0.start();
        System.out.println(Thread.currentThread().getName() + " is sleeping 5000");
        Thread.sleep(5000);
        thread1.start();

    }

}

class MyRunnable1 implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is ready ");

            Connection connection = JdbcUtils.getConnection();

            //3. 定义sql语句
            String sql1 = "update account set money = 3000 where id = 2";

            //4. 获取执行sql的对象 Startment
            Statement stmt = connection.createStatement();


            try {
                //开启手动事务(关闭自动事务)
                connection.setAutoCommit(false);

                //5. 执行sql
                //受影响的行数
                int count1 = stmt.executeUpdate(sql1);
                //6. 处理结果
                System.out.println(Thread.currentThread().getName() + " count: " + count1);

                System.out.println(Thread.currentThread().getName() + " is sleeping 100000");

                Thread.sleep(100000);
                //提交事务
                connection.commit();

                System.out.println(Thread.currentThread().getName() + " is Ok");

            } catch (SQLException e) {
                //回滚事务
                connection.rollback();
                throw new RuntimeException(e);
            }


            //7. 释放资源
            //先释放后面打开的,后释放先打开的+
            stmt.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class MyRunnable2 implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is ready ");

            Connection connection = JdbcUtils.getConnection();

            //3. 定义sql语句
            String sql1 = "update account set money = 4000 where id = 2";

            //4. 获取执行sql的对象 Startment
            Statement stmt = connection.createStatement();


            try {
                //开启手动事务(关闭自动事务)
                connection.setAutoCommit(false);

                //5. 执行sql
                //受影响的行数
                int count1 = stmt.executeUpdate(sql1);
                //6. 处理结果
                System.out.println(Thread.currentThread().getName() + " count: " + count1);

                //提交事务
                connection.commit();

            } catch (SQLException e) {
                //回滚事务
                connection.rollback();
                throw new RuntimeException(e);
            }


            //7. 释放资源
            //先释放后面打开的,后释放先打开的+
            stmt.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}