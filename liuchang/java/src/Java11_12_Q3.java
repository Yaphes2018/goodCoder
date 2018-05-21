import java.util.ArrayList;
import java.util.List;
/*
-Q3：输入一个字符串，打印出该字符串中字符的所有排列。如：输入字符串abc，则打印出字符a、b、c所能排列出的所有字符串abc、acb、bac、bca、cab和cba。
 */
public class Java11_12_Q3 {
    public static void main(String[] args) {
        String s="abcd";     //原字符串
        List<String> result = list(s, "");        //列出字符的组合，放入result
        System.out.println(result.size());
        System.out.println(result);
    }
    /**
     * @param base 以该字符串作为基础字符串，进行选择性组合。
     * @param buff 所求字符串的临时结果
     * @param result 存放所求结果
     */
    private static List<String> list(String base, String buff) {
        // TODO Auto-generated method stub
        List<String> result = new ArrayList<String>();  //存放结果信息。
        if (base.length() <= 0) {
            result.add(buff);
        }
        for (int i = 0; i < base.length(); i++){

            List<String> temp = list(new StringBuilder(base).deleteCharAt(i).toString(), buff + base.charAt(i));

            result.addAll(temp);
        }
        return result;
    }
}

