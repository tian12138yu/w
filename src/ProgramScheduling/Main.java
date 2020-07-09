package ProgramScheduling;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while(true){
            System.out.println("**********欢迎使用程序调度算法***********");
            System.out.println("**********请输入要使用的算法************");
            System.out.println("**********1.FCFS**********");
            System.out.println("**********2.RR**********");
            System.out.println("**********3.SJF**********");
            System.out.println("**********4.HRRN**********");
            System.out.println("**********0.退出**********");
            Scanner sc = new Scanner(System.in);
            int num=sc.nextInt();
            if(num==1){
                new FCFS();
            }
            if(num==2){
                new RR();
            }
            if(num==3){
                new SJF();
            }
            if(num==4){
                new HRRN();
            }
            if(num==0){
                System.exit(0);
            }
        }


    }
}
