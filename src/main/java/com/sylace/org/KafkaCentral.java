package com.sylace.org;

import com.sylace.org.kafka.client.HelloConsumer;
import com.sylace.org.kafka.client.HelloProducer;
import com.sylace.org.kafka.client.AlphaProducer;
import com.sylace.org.kafka.client.AlphaConsumer;


import java.util.Scanner;


public class KafkaCentral {

    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[96m";


    public static void main(String[] args) throws Exception {
        System.out.println(CYAN+"-------------------------------------");
        System.out.println("\033[3m   WELCOME TO KAFKA CENTRAL V1.0 \033[0m");
        System.out.println(CYAN+"-------------------------------------");
        System.out.println(GREEN+"\nOptions:");
        System.out.println("0: Run Producer");
        System.out.println("1: Run Consumer");
        System.out.println("2: Run Alpha Prod");
        System.out.println("3: Run Stream");
        System.out.println("q: Quit");

        String choice="";
        long stamp=99;
        boolean exit = false;
        do {
            System.out.print("\nCommand : ");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();

            switch (choice) {
                case "0":
                    System.out.println("0: Running Producer");
                    if (stamp==0) stamp = new java.util.Date().getTime();
                    HelloProducer.run("MAVEN-" + stamp);
                    break;
                case "1":
                    System.out.println("1: Running Consumer");
                    if (stamp==0) stamp = new java.util.Date().getTime();
                    HelloConsumer.run("MAVEN-" + stamp);
                    break;
                case "2":
                    System.out.println("2: Running Alpha Prodcuer");
                    if (stamp==0) stamp = new java.util.Date().getTime();
                    AlphaProducer.run("ALPHA-" + stamp);
                    break;
                case "3":
                    System.out.println("2: Running Alpha Consumer");
                    if (stamp==0) stamp = new java.util.Date().getTime();
                    AlphaConsumer.run("ALPHA-" + stamp);
                    break;
                case "c":
                    System.out.println("Enter the first number");
                    int input1 = scan.nextInt();
                    System.out.println("Enter the second number");
                    break;
                case "q":
                    exit = true;
                    System.out.println("Good Bye!");
                    break;
                default :
                    break;
            }
        } while(!exit);

    }
}
