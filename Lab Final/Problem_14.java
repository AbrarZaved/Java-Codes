import java.util.Scanner;

public class Problem_14 {
    public static void main(String[] args) {
        String a;
        Scanner in = new Scanner(System.in);
        a=in.nextLine();
        int b=a.length();
        int vow=0,con,space=0;
        for(int i=0;i<b;i++){
            if(a.charAt(i) =='A' ||a.charAt(i) =='E'||a.charAt(i) =='I'||a.charAt(i) =='O'|| a.charAt(i) =='U'||
            a.charAt(i) =='a'||a.charAt(i) =='e'||a.charAt(i) =='i'||a.charAt(i) =='o'||a.charAt(i) =='u'){
                vow++;
            }
            if(a.charAt(i) ==' ')
            space++;
        }
        con=b-(vow+space);
        System.out.println("Vowels: "+vow);
        System.out.println("Consonents: "+con);

    }
    
}
