/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vektormain;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
/**
 *
 * @author superuser
 */
public class VektorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
         FileInputStream fstream = new FileInputStream("C:/file.txt");
         BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
         String strLine;

         while ((strLine = br.readLine()) != null){
          System.out.println(strLine);
           }
          }catch (IOException e){
        System.out.println("Ошибка"); 
    }
 }
        
        
    }
    
