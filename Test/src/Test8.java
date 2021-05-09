import java.util.Random;

public class Test8 {

    //用你熟悉的语言实现生成随机字符串的函数gen_random_str()。参数输入为预期的字符串长度，是否需要特殊字符。 特殊字符参考：_+-&=!@#$%^*
    //
    //样例：gen_random_str(length=10, need_special_character=True)
    //输出结果：
    //gen_random_str(12, True), 执行参考结果：#g76UD#mbs73
    //gen_random_str(8, False), 执行参考结果：DOutICKL

    public static void main(String[] args) {
        String string = gen_random_str(12, true);
        System.out.println(string);
    }

    public static String gen_random_str(int length,Boolean needSpecialCharacter){
        String[] character = {"0","1","2","3","4","5","6","7","8","9","a","b","c"};
        String[] specialCharacter = {"-","+","&","=","!","@","#","$","%","^","*"};
        StringBuilder ans = new StringBuilder("");
        Random random = new Random();
        if (needSpecialCharacter) {
            for (int i = 0; i < length; i++) {
                int flag = Math.abs(random.nextInt()) % 2;
                if (flag == 0){
                    //加入字母或数字
                    ans.append(character[Math.abs(random.nextInt()) % character.length]);
                }else {
                    //加入特殊字符
                    ans.append(specialCharacter[Math.abs(random.nextInt()) % specialCharacter.length]);
                }
            }
        }else {
            int characterNum = Math.abs(random.nextInt()) % length;
            for (int i = 0; i < characterNum; i++) {
                int characterIndex = Math.abs(random.nextInt()) % character.length;
                ans.append(character[characterIndex]);
            }
        }

        return ans.toString();
    }
}
