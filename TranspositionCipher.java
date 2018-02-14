import java.io.*;
import java.util.*;
public class TranspositionCipher{
    public static void main(String[] args) throws IOException{
        System.out.println("Enter the message");
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String message = br.readLine();
        message = message.replaceAll(" ","");
        message = message.replaceAll(",","");
        message = message.replaceAll("\\.","");
        System.out.println("Message is:"+message);
        String plain_text = message.toUpperCase();
        System.out.println("Plain text:"+plain_text);
        int length = plain_text.length();
        //System.out.println(length);
        System.out.println("Enter key");
        Scanner src = new Scanner(System.in);
        String key = src.nextLine();
        int k = key.length();
        //System.out.println(k);
        float size = (float)length/k;
        //System.out.println(size);
        int m = (int)Math.ceil(size);
        //System.out.println(m);
        char matrix[][] = new char[m][k];
        int t=0;
        int i,j;
        for(i=0;i<m;i++){
            for(j=0;j<k;j++){
                try{
                matrix[i][j] = plain_text.charAt(t);
                }
                catch(Exception e){
                    matrix[i][j]='$';
                }
                t++;
            }
        }
        System.out.println("Matrix: ");
        for(i=0;i<m;i++){
            for(j=0;j<k;j++){
                System.out.print(matrix[i][j]+" ");
               
            }
            System.out.println();
        }
            char keys[] = key.toCharArray();
            Arrays.sort(keys);
            for(i=0;i<keys.length;i++){
            System.out.print(keys[i]);
            }
            System.out.println();
            String index_key = "";
            for(i=0;i<keys.length;i++){
                index_key=index_key+key.indexOf(keys[i]);
            }
            System.out.println("key in order:"+index_key);
            System.out.println("Cipher is");
            //k=0;
            int a=0;
            int index;
            while(a<index_key.length()){
                i=Character.getNumericValue(index_key.charAt(a));
                //System.out.println(i);
                for(j=0;j<m;j++){
                    System.out.print(matrix[j][i]);
                }
                a++;
            }
            System.out.println();
            
    }
        //System.out.println(7/3);
}

