import java.util.*;

public class xiechengTest {
    static List<Integer> list = new LinkedList<>();
    static List<List<Integer>> ansList = new LinkedList<>();
    static int procee(int[] scores, int[] cards) {
        //思路1: 将cards中的序列重新排序,穷举法
        LinkedList<Integer> cardsList = new LinkedList<Integer>();
        for (Integer card : cards){
            cardsList.add(card);
        }

        for (int i = 0; i < cardsList.size(); i++) {
            int first = cards[i];
            findList(cardsList,first);
        }

        int ans = sumScores(scores, ansList);
        return ans;
    }

    private static int sumScores(int[] scores, List<List<Integer>> ansList) {
        int maxSum = 0;
        for (List<Integer> list : ansList){
            int index = 0;
            int sum = scores[index];
            for (Integer next : list){
                index += next;
                sum += scores[index];
            }
            if (sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    static void findList(List<Integer> cardsList, Integer first){
        cardsList.remove(first);
        list.add(first);
        if (cardsList.size() == 0){
            ansList.add(new LinkedList<>(list));
        }
        for (int i = 0; i < cardsList.size(); i++) {
            findList(cardsList,cardsList.get(i));
        }
        cardsList.add(first);
        list.remove(first);
        return;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _scores_size = 0;
        _scores_size = Integer.parseInt(in.nextLine().trim());
        int[] _scores = new int[_scores_size];
        int _scores_item;
        for(int _scores_i = 0; _scores_i < _scores_size; _scores_i++) {
            _scores_item = Integer.parseInt(in.nextLine().trim());
            _scores[_scores_i] = _scores_item;
        }

        int _cards_size = 0;
        _cards_size = Integer.parseInt(in.nextLine().trim());
        int[] _cards = new int[_cards_size];
        int _cards_item;
        for(int _cards_i = 0; _cards_i < _cards_size; _cards_i++) {
            _cards_item = Integer.parseInt(in.nextLine().trim());
            _cards[_cards_i] = _cards_item;
        }

        res = procee(_scores, _cards);
        System.out.println(String.valueOf(res));

    }
}
