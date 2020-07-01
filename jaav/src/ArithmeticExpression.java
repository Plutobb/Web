import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class ArithmeticExpression {
    private int x;
    private int y;
    private int operator;
    private String fuHao;

    public ArithmeticExpression(int operator,int x,int y) throws Exception {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"+");
        map.put(2,"-");
        map.put(3,"*");
        map.put(4,"/");
        if (map.containsKey(operator)){
            this.operator = operator;
        }else {
           throw new Exception("运算符错误");
        }
        this.x = x;
        this.y = y;
    }

    private double getResult() throws Exception {
        switch (operator){
            case 1 : this.fuHao = "+"; return x + y;
            case 2 : this.fuHao = "-"; return x - y;
            case 3 : this.fuHao = "*"; return x * y;
            case 4 :
                if (y == 0){
                    throw new Exception("除数为0异常!");
                }else {
                    this.fuHao = "/";
                    return (double) x / y;
                }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("E:\\file\\out.txt");
        //没有目录就创建;
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }
        //文件不存在就创建;
        if (!file.exists()){
            file.createNewFile();
        }
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\file\\out.txt"),"GBK");
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(500);
            int y = random.nextInt(500)+1;
            int operator = random.nextInt(4)+1;
            ArithmeticExpression arithmeticExpression = new ArithmeticExpression(operator,x,y);
            double ans = arithmeticExpression.getResult();
            String str = x + ""+ arithmeticExpression.fuHao + y +" = " + ans + "\n";
            osw.write(str);
            osw.flush();
        }
    }
}
