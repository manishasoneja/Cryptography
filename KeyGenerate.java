import java.util.*;
import java.io.*;
import java.util.Map.*;
class KeyGenerate{
    public static void main(String[] args) throws IOException{
        int i;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        List<Integer> arr = new ArrayList<>(26);
        for(i=0;i<26;i++){
            arr.add(i+1);
        }
        System.out.println("Input"+arr);
        int tmp;
        int ra;
        int replace;
        for(i=26;i>0;i--){
           ra = r.nextInt(i);
           tmp = arr.get(i-1);
           replace = arr.get(ra);
           arr.set(i-1,replace);
           arr.set(ra,tmp);

        }
        char[] keys = new char[26];
        System.out.println("Shuffled index"+arr);
        for(i=0;i<26;i++){
            keys[i]=alphabet.charAt(arr.get(i)-1);
        }
        for(i=0;i<26;i++){
            
        System.out.print(keys[i]);
        }
        System.out.println();
        String org_message = "";
        String line;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir); 
        while((line=br.readLine())!=null){
            org_message = org_message+line;
        }
        System.out.println("Message is:"+org_message);
        System.out.println("To Remove all Spaces:");
        String plain_text = org_message.replaceAll(" ","");
        //System.out.println("Text without space: "+plain_text);
        plain_text = plain_text.replaceAll(",","");
        //System.out.println("Text without space: "+plain_text);  
        plain_text = plain_text.replaceAll("\\.","");
        plain_text = plain_text.replaceAll("\\?","");
        plain_text = plain_text.replaceAll("\\:","");
        plain_text = plain_text.replaceAll("\\;","");
        plain_text = plain_text.replaceAll("'","");
        //System.out.println("Text without space: "+plain_text);
        plain_text = plain_text.toUpperCase();
        String cipher_text = "";
        System.out.println("Text without space: "+plain_text);
        for(i=0;i<plain_text.length();i++){
            char ch = plain_text.charAt(i);
            int index = alphabet.indexOf(ch);
            char rep = keys[index];
            cipher_text = cipher_text+rep;
        }
        System.out.println("Encrypted text:"+cipher_text);
	Map<Character,Integer> hm = new HashMap<Character,Integer>(Math.min(cipher_text.length(),26));
        for(i=0;i<cipher_text.length();i++){
            char ch = cipher_text.charAt(i);

            if(!hm.containsKey(ch)){
                hm.put(ch,1);
            }
            else{
                hm.put(ch,hm.get(ch)+1);
            }
        }
        System.out.println(hm);
        Map<Character,Double> hp = new HashMap<Character,Double>(Math.min(cipher_text.length(),26));
        Set s = hm.entrySet();
        Iterator it = s.iterator();
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            char c = (char)me.getKey();
            int x = (int)me.getValue();
            double d = (double) x/cipher_text.length();
            hp.put(c,d);
        }
        System.out.println(hp);
        Set<Entry<Character,Double>> set = hp.entrySet();
        List<Entry<Character,Double>> list = new ArrayList<Entry<Character,Double>>(set);
        Collections.sort(list,new Comparator<Map.Entry<Character,Double>>(){
            public int compare(Map.Entry<Character,Double> o1,Map.Entry<Character,Double> o2){
                return(o2.getValue()).compareTo(o1.getValue());
            }
        });
        for(Map.Entry<Character,Double> entry:list){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        String std_mapping ="ETAOINSHRDLCUMWFGYPBVKJXQZ";
        //Map<Integer,Character> mapping = new HashMap<Integer,Character>(26);
        List<Character> mapping = new ArrayList<Character>();
        int val=0;
        for(Map.Entry<Character,Double> entry:list){
            mapping.add(val,entry.getKey());
            val++;
        }
        System.out.println(mapping);
        String decrypted_msg="";
        for(i=0;i<cipher_text.length();i++){
            char c = cipher_text.charAt(i);
            int z = mapping.indexOf(c);
            char toberep = std_mapping.charAt(z);
            decrypted_msg = decrypted_msg+toberep;
        }
        System.out.println("Decrypted msg:"+decrypted_msg);    
        }
    }

