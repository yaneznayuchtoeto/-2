import java.util.Scanner;

class Players{
    String Var = "";
    void player_var(){
        Scanner input = new Scanner(System.in);
        System.out.println("enter the answer: ");
        String Var_no_up = input.nextLine();
        char[] chars = Var_no_up.toCharArray();
        String str = "";
        for (char c : chars) {
            c = Character.toUpperCase(c);
            str += c;
        }
        Var = str;
    }
}