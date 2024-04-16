package com.sardh;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.*;

public class TestJUL {

    // 这玩意会直接在C盘生成路径
    public static void main(String[] args) {
        Path logDirectory = Paths.get("/logs");
        if (Files.notExists(logDirectory)) {
            try {
                Files.createDirectories(logDirectory);
                System.out.println("Log directory created successfully.");
            } catch (IOException e) {
                System.err.println("Failed to create log directory: " + e.getMessage());
            }
        } else {
            System.out.println("Log directory already exists.");
        }
    }

    @Test
    public void testQuick() throws Exception{
        // 1. 获取日志记录器对象
        Logger logger = Logger.getLogger("com.sardh.TestJUL");

        // 2. 日志记录输出
        logger.info("Hello jul");

        // 3. 通用方法进行日志记录
        logger.log(Level.INFO, "info msg");

        // 通过占位符方式输出变量值
        String name = "sardh";
        Integer age = 19;
        logger.log(Level.INFO, "用户信息: {0}, {1}",new Object[]{name, age});
    }

    // 日志级别
    @Test
    public void testLogLevel()throws Exception{
        // 1. 获取日志记录器对象
        Logger logger = Logger.getLogger("com.sardh.TestJUL");
        // 2. 日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");// JUL默认的日志级别是info
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    // 自定义日志级别
    @Test
    public void testLogConfig()throws Exception{
        // 1. 获取日志记录器对象
        Logger logger = Logger.getLogger("com.sardh.TestJUL");

        // 关闭系统默认配置
        logger.setUseParentHandlers(false);

        // 自定义配置日志级别
        // 创建ConsoleHandler
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);

        // 配置日志的级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        // 场景FileHandler 文件输出
        FileHandler fileHandler = new FileHandler("src/main/logs/jul.log");

        // 进行关联
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);

        // 2. 日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");// JUL默认的日志级别是info
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    // Logger对象父子关系
    @Test
    public void testLogParent()throws Exception{
        Logger logger1 = Logger.getLogger("com.sardh");
        Logger logger2 = Logger.getLogger("com");

        boolean b = logger1.getParent() == logger2;
        System.out.println(b);

        // 所有日志记录器的顶级父元素: java.util.logging.LogManager$RootLogger, name:""
        System.out.println("logger2 parent:" + logger2.getParent() + "\nname:" + logger2.getParent().getName());

        // 关闭默认配置
        logger2.setUseParentHandlers(false);

        // 自定义配置日志级别
        // 创建ConsoleHandler
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger2.addHandler(consoleHandler);

        // 配置日志的级别
        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);


        logger1.severe("severe");
        logger1.warning("warning");
        logger1.info("info");// JUL默认的日志级别是info
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");

    }

}
