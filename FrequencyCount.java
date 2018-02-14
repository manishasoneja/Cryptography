import java.util.*;
public class FrequencyCount{
    public static void main(String[] args){
        System.out.println("enter string");
        Scanner src = new Scanner(System.in);
        String str = src.next();
        System.out.println("String "+str);
        //int count[] = new count[26];
        int i;
        Map<Character,Integer> hm = new HashMap<Character,Integer>(Math.min(str.length(),26));
        for(i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(!hm.containsKey(ch)){
                hm.put(ch,1);
            }
            else{
                hm.put(ch,hm.get(ch)+1);
            }
        }
        System.out.println(hm);
        Map<Character,Double> hp = new HashMap<Character,Double>(Math.min(str.length(),26));
        Set s = hm.entrySet();
        Iterator it = s.iterator();
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            char c = (char)me.getKey();
            int x = (int)me.getValue();
            double d = (double) x/str.length();
            hp.put(c,d);
        }
        System.out.println(hp);
        }
    }

