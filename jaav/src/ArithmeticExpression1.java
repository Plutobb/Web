import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ArithmeticExpression1 {
    private int x;
    private int y;
    private char operator;

    public ArithmeticExpression1(char operator,int x,int y) throws Exception {
        this.x = x;
        this.y = y;
        char[] yunSuanFu = {'+','-','*','/'};
        for (char c : yunSuanFu) {
            if (c == operator) {
                this.operator = operator;
                break;
            }
        }
        throw new Exception("运算符错误");
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
        if (operator == '+'){
            return x + y;
        }else if (operator == '-'){
            return x - y;
        }else if (operator == '*'){
            return x * y;
        }else if (operator == '/'){
            if (y == 0){
                throw new Exception("除数不能为0!");
            }else {
                return (double) x/y;
            }
        }else {
            throw new Exception("运算符异常!");
        }
    }
    public static void shuRu() throws Exception {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\file\\out.txt"),"GBK");
        Random random = new Random();
        Scanner sc =new Scanner(System.in);
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt();
            int y = random.nextInt() + 1;
            String operator = sc.next();
            ArithmeticExpression arithmeticExpression = new ArithmeticExpression(operator.charAt(0), x, y);
            double jieGuo = arithmeticExpression.getResult();
            String str = x + operator+ y + " = " + jieGuo + "\n";
            osw.write(str);
            osw.flush();
        }
    }
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\file\\out.txt");
        if (!file.exists()) {
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdir();
            }
            shuRu();
        }else {
            FileInputStream in = new FileInputStream(file);
            byte[] bytes = new byte[5000];
            int len = in.read(bytes);
            String str = new String(bytes,0,len);
            System.out.println(str);
        }
    }
}
