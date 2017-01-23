package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(new File("info"));
        while(sc.hasNextLine())
            System.out.println(sc.nextLine()+","+sc.nextLine());
    }
}
