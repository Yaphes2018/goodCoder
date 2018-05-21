/*
-Q3：给定一个文件和一个字符串，请判断文件是否包含该字符串。如包含，请打印出包含该字符串的行号及该行的全部内容。
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Java13_15_Q3 {
/*
思路：
1、使用缓冲流(BufferedReader)读取文件，定义初始行号为0。
2、遍历文件每一行并判断，包含则将行号和行内容存入hashMap中，行号作为key，行内容作为value.最后遍历hashMap即可
 */
    public static void findStringInFile(String fileName, String subStr) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        Map<Integer, String> res = new HashMap<>();
        int lineNum = 0; //记录行号
        String line;
        while((line = br.readLine())!= null){
            lineNum++;
            /*
                第一种：contains
                if(line.contains(subStr)){res.put(lineNum,line); ...}
             */
            /*
                第二种：indexOf
             */
            if(line.indexOf(subStr) != -1){
                res.put(lineNum, line);
            }
        }
        //遍历HashMap，key为行号，value为字符串
        if(res.isEmpty()){
            System.out.println("文件【"+fileName+"】中没有【"+subStr+"】子串");
        } else {
            Iterator<Entry<Integer, String>> it = res.entrySet().iterator();
            while(it.hasNext()){
                Entry<Integer, String> entry = it.next();
                Integer key = entry.getKey();
                String value = entry.getValue();
                System.out.println("第【"+key+"】行:\t"+value);
            }
        }
        br.close();
    }

    public static void main(String[] args) throws Exception{
        findStringInFile("/Users/baidu/workingForBDWM/qaGoodcoder/java/JavaCode/src/test.txt", "abc");
    }
}
