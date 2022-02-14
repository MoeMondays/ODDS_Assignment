
import java.util.Scanner;

public class RemainInOut {
    void initFunction(int n){
        String a = functionA(n);
        String b = functionB(a);
        String c = functionC(b);
        String d = functionD(c);
        String e = functionE(d);
        int f = functionF(e);
        
        System.out.println("A: "+a);
        System.out.println("B: "+b);
        System.out.println("C: "+c);
        System.out.println("D: "+d);
        System.out.println("E: "+e);
        System.out.println("F: "+f);
    }
    
    String functionA(int n){
        String result = "";
        String num = Integer.toString(n);
        
        for(int i=0; i<num.length(); i++){
            int j = Character.getNumericValue(num.charAt(i));
            if(j%2 == 0)
                result += "Even"+num.charAt(i);
            else
                result += "Odd"+num.charAt(i);
        }
        
        return result;
    }
    
    String functionB(String s){
        String result = "";
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'O'){
                String swap = s.substring(i, i+3);
                result += (new StringBuffer(swap).reverse().toString().toUpperCase())+s.charAt(i+3);
                i += 3;
            }
            else{
                String swap = s.substring(i, i+4);
                result += (new StringBuffer(swap).reverse().toString().toUpperCase())+s.charAt(i+4);
                i += 4;
            }
        }
        
        return result;
    }
    
    String functionC(String s){
        String result = "";
        
        for(int i=0; i<s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i)))
                result += Integer.toString((int)s.charAt(i));
            else
                result += s.charAt(i);
        }
        
        return result;
    }
    
    String functionD(String s){
        String result = "";
        
        for(int i=0; i<s.length(); i++){
            boolean odd = false;
            
            if(i+2 < s.length()){
                if((char)Integer.parseInt(s.substring(i, i+2)) == 'D'){
                    for(int j=i; j<i+6; j+=2)
                        result += (char)Integer.parseInt(s.substring(j, j+2));
                    odd = true;
                }
                
                if((char)Integer.parseInt(s.substring(i, i+2)) == 'N'){
                    for(int j=i; j<i+8; j+=2)
                        result += (char)Integer.parseInt(s.substring(j, j+2));
                }
                
                if(odd)
                    i += 6;
                else
                    i += 8;
                result += s.charAt(i);
            }
        }
        
        return result;
    }
    
    String functionE(String s){
        String result = "";
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'D'){
                result += s.charAt(i+2);
                String swap = s.substring(i, i+2);
                result += (new StringBuffer(swap).reverse().toString().toLowerCase())+s.charAt(i+3);
                i += 3;
            }
            else{
                result += s.charAt(i+3);
                String swap = s.substring(i, i+3);
                result += (new StringBuffer(swap).reverse().toString().toLowerCase())+s.charAt(i+4);
                i += 4;
            }
        }
        
        return result;
    }
    
    int functionF(String s){
        String num = "";
        int result;
        
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i)))
                num += s.charAt(i);
        }
        
        result = Integer.parseInt(num);
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RemainInOut r = new RemainInOut();
        
        while(true){
            System.out.println("Enter a number (negative number to exit)");
            int n = input.nextInt();
            if(n < 0){
                System.out.println("Exit");
                break;
            }
            r.initFunction(n);
        }
    }
}
