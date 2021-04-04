package StringClass;

import java.util.Scanner;

public class ZiJieXiuFuZiFuChuan {
    /*
    我叫王大锤，是一家出版社的编辑。我负责校对投稿来的英文稿件，这份工作非常烦人，因为每天都要去修正无数的拼写错误。但是，优秀的人总能在平凡的工作中发现真理。我发现一个发现拼写错误的捷径：

    1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
    2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
    3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC

    我特喵是个天才！我在蓝翔学过挖掘机和程序设计，按照这个原理写了一个自动校对器，工作效率从此起飞。用不了多久，我就会出任CEO，当上董事长，迎娶白富美，走上人生巅峰，想想都有点小激动呢！
    ……
    万万没想到，我被开除了，临走时老板对我说： “做人做事要兢兢业业、勤勤恳恳、本本分分，人要是行，干一行行一行。一行行行行行；要是不行，干一行不行一行，一行不行行行不行。” 我现在整个人红红火火恍恍惚惚的……

    请听题：请实现大锤的自动校对程序
     */
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        for (String string : strs) {
            System.out.println(isThree(string, 0));
        }
    }

    public static String isThree(String string,int left){
        StringBuilder str = new StringBuilder(string);
        int right = left+1;
        while (right < str.length()){
            if (str.charAt(right) == str.charAt(left)){
                if (right - left == 2 && right <str.length()){
                    str.deleteCharAt(right);//删除第三个重复的字符
                    right = left+1;//删除后将right指针重置到left位置继续判断
                }else {
                    right++;
                }
            }else {
                left = right;
            }
        }
        //删除掉所有三个重复字符后删除AABB型;
        return noAABB(str, 0);
    }

    private static String noAABB(StringBuilder str, int left) {
        int index = left;
        int flag = 0;//标志是第几组重复的 例如:flag = 1 代表现在AABB走到了B位置 为0则在A位置
        while (left+1 < str.length()){
            if (str.charAt(left) == str.charAt(left+1)){
                if (flag == 0){
                    flag = 1;
                    left += 2;
                }else {
                    str.deleteCharAt(left+1);
                    flag = 0;
                    left = index;
                }
            }else {
                if (flag == 0){
                    index++;
                    left = index;
                }else {
                    flag = 0;
                    index = left+1;
                    left = index;
                }
            }
        }
        return str.toString();
    }
}
