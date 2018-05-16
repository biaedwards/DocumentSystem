package DocumentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Commands use = new Commands();
        while(!input.equals("\n")){
            use.chooseCommand(input);
            System.out.println();
            input = in.nextLine();
        }
    }
}
