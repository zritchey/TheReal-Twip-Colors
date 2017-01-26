package com.company;


import java.io.File;

import java.io.IOException;
import java.util.Scanner;

public class Main {
        public static String [][] colors;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(new File("info"));
        int lines=0;
        while (sc.hasNextLine()){
            lines++;
            sc.nextLine();
        }
        sc.close();


         colors=new String[lines][];
        sc=new Scanner(new File ("info"));
        for (int i=0;i<lines;i++){
            String s=sc.nextLine();
            colors[i]=s.split(",");
        }
        sc.close();
        Scanner kbin=new Scanner(System.in);
        System.out.println("This program will help identify a color.\n");
        System.out.println("There are three options. Choose one to Enter into the program.");
        System.out.println("\n1: Color Name \n2: Hexidecimal \n3: RGB Triplet\n");
        System.out.print("Enter the option number you want: ");
        int choice=kbin.nextInt();
        boolean exist=false;
        String name="";
        String hex="";
        String rgb="";
        while(choice >3||choice <1){
            System.out.println("That's not an option. Try again");
            choice=kbin.nextInt();
        }
        System.out.print("Enter the information: ");
        String input=kbin.nextLine().replaceAll(" ","").replaceAll("\t","").replaceAll("\\)","").replaceAll("\\(","");
        while(input.length()<1){
            input=kbin.nextLine().replaceAll(" ","").replaceAll("\t","").replaceAll("\\)","").replaceAll("\\(","");
        }
        if (choice==1){
            name=input;
            hex=namer(name,choice);
            rgb=  toRGB(hex,choice);
        }
        if (choice==2){
            hex=input;
            name=namer(hex,choice);
            rgb= toRGB(hex,choice);
        }
        if(choice ==3){
            rgb=input;
            while (rgb.split(",").length!=3){
                System.out.println("I think you messed up the commas in the RGD triple. Try again");
                rgb=kbin.nextLine();
            }
            rgb.replaceAll(" ","").replaceAll("\t","").replaceAll("\\)","").replaceAll("\\(","");
            hex=toRGB(rgb, choice);
            name=namer(hex,2);
            rgb="("+rgb+")";
        }
        if (name.equals("False")||hex.equals("False")) {
            System.out.println("Your information was invalid.");
        }
        else{
            System.out.println("Name: "+name+"\nHexidecimal: "+hex+"\nRGB Triple: "+rgb+"\n");
        }
    }
    public static String namer(String s,int k){
        String n="False";
        for (int i=0; i<colors.length;i++){
            if (s.equalsIgnoreCase(colors[i][k-1]))
            n=colors[i][(k)%2];
        }
        return n;
    }
    public static String toRGB(String h, int k ) {
        String s="";
        if (k < 3) {
             s += "(";
            for (int i = 0; i < 6; i += 2) {
                s += Integer.parseInt(h.substring(i, i + 2),16 );
                if (i<4)
                    s+=",";
            }
            s += ")";
        }
        else{
            String []a=h.split(",");
           for (int i=0;i<a.length;i++){
               String part=Integer.toHexString(Integer.parseInt(a[i]));
               if(part.length()<2)
                   part="0"+part;
               s+=part;
           }
        }
        return s;
    }
}