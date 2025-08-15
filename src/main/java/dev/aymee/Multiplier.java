package dev.aymee;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Multiplier {
    Scanner scanner;

    public Multiplier(InputStream in) {
        this.scanner = new Scanner(in);
       

    }
    public void Multiply(){
        boolean retry=true;
        while (retry) {
            
        
        System.out.println("Escribe el número:");
        try{
            int number=scanner.nextInt();
            retry=false;
            for(int i=1;i<=10;i++){
            System.out.println(number+" x "+ i +" = "+(number*i));
            }
        }
        catch(InputMismatchException e){
            System.out.println("Debe escribir un número, intente de nuevo");
            scanner.nextLine();
        }
    }}
}
