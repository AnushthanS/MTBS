import Login.UserLogin;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int userMode = 2, registerMode = 2;
        if(args.length > 1){
            try{
                userMode = Integer.parseInt(args[1]);
                registerMode = Integer.parseInt(args[2]);
            } catch (InputMismatchException e){
                System.out.println("Enter a valid argument type");
            }
        }
//        switch (userMode){
//            case 0 ->
//
//        }
    }
}