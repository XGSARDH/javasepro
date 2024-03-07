package Sardh.hello;

import org.w3c.dom.ls.LSOutput;

public class VariableType {
    int instanceVar;//成员变量
    static int staticVar;//静态变量

    //设置成员变量
    public void setInstanceVar(int instanceVar) {
        this.instanceVar = instanceVar;
    }

    //设置静态变量
    public static void setStaticVar(int staticVar) {
        VariableType.staticVar = staticVar;
    }

    //打印个变量实例
    public void soutis(int paramVar) {
        //局部变量
        int localVar = 10;

        //使用变量
        instanceVar = localVar;
        staticVar = paramVar;

        System.out.println("成员变量:" + instanceVar);
        System.out.println("静态变量:" + staticVar);
        System.out.println("参数变量:" + paramVar);
        System.out.println("局部变量:" + localVar);
    }

    public static void main(String[] args) {
        int a = 1,b = 2,c = 3;
        int d = 3,e = 4,f = 5;
        byte z = 22;
        String s = "asdf";
        double pi = 3.1415926;
        char x = 'x';

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(z);
        System.out.println(s);
        System.out.println(pi);
        System.out.println(x);

        VariableType Var = new VariableType();
        Var.soutis(20);
    }


}
