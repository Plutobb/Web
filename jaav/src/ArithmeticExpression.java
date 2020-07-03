import java.io.*;
import java.util.*;

public class ArithmeticExpression {
    private int x;
    private int y;
    private char operator;
    private String fuHao;

    public ArithmeticExpression(char operator,int x,int y) throws Exception {
        Set<Character> set = new HashSet<>();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');
        if (set.contains(operator)){
            this.operator = operator;
        }else {
           throw new Exception("运算符错误");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getOperator() {
        return operator;
    }

    private double getResult() throws Exception {
        switch (operator){
            case '+' : this.fuHao = "+"; return x + y;
            case '-' : this.fuHao = "-"; return x - y;
            case '*' : this.fuHao = "*"; return x * y;
            case '/' :
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
        if (!file.exists()) {
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdir();
            }
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\file\\out.txt"),"GBK");
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                int x = random.nextInt(500);
                int y = random.nextInt(500) + 1;
                int operator_num = random.nextInt(4) + 1;
                char operator = '+';
                switch (operator_num){
                    case 1 : operator = '+';break;
                    case 2 : operator = '-';break;
                    case 3 : operator = '*';break;
                    case 4 : operator = '/';break;
                }
                ArithmeticExpression arithmeticExpression = new ArithmeticExpression(operator, x, y);
                double ans = arithmeticExpression.getResult();
                String str = x + " "+ arithmeticExpression.fuHao+" "+ y + " = " + ans + "\n";
                osw.write(str);
                osw.flush();
            }
        }else {
            FileInputStream in = new FileInputStream(file);
            byte[] bytes = new byte[2048];
            int len = in.read(bytes);
            String str = new String(bytes,0,len);
            System.out.println(str);
        }
    }
}
