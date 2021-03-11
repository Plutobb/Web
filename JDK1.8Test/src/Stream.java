import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    //Stream流是JDK8中加入的，主要是为了解决日常开发中编写复杂的代码。
    // 通过结合Lambda表达式可以完美的写出简洁高效的代码，Stream流分为三个阶段：开始–>中间–>结束。
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>(){{
            put("a",1);
            put("b",2);
            put("c",3);
            put("d",4);
            put("e",5);
        }};

        List<Integer> list = Arrays.asList(1,2,5,2,1,0,9,8,8);
        //filter 截取流中可以被2整除的数字;
        List<Integer> ans = list.stream().filter(integer -> integer%2==0).collect(Collectors.toList());
        System.out.println(ans);
        //distinct 去重操作
        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctList);
        //sort 默认是升序 可以接受lambda表达式
        List<Integer> sortList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortList);
        List<Integer> niSortList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(niSortList);
        //limit 获取流的前几个元素;
        List<Integer> limitList = list.stream().limit(3).collect(Collectors.toList());
        System.out.println(limitList);
        //skip 跳过流的前几个元素,如果留的长度小于n则返回一个空流;
        List<Integer> skipList = list.stream().skip(1).collect(Collectors.toList());
        System.out.println(skipList);


        System.out.println("-----------------------");
        List<Integer> peekList = list.stream().peek(integer -> System.out.println("from" + integer))
                .limit(3).collect(Collectors.toList());
        System.out.println(peekList);

        Optional<Integer> max = list.stream().reduce(Integer::max);
        System.out.println(max);
    }
}
