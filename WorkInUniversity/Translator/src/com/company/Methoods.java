package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Methoods {
    static void synonyms(String path){
        ArrayList<String> listFirstRealization = new ArrayList();
        HashMap<String, String> mapFirstRealization = new HashMap();

        System.out.print("input word ");

        Scanner sc = new Scanner(System.in);
        String inputWord = sc.nextLine();

        //functional************************
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String s;
                while ((s = br.readLine()) != null) {
                    for (String retval : s.trim().split(" ")) {
                        listFirstRealization.add(retval);
                    }
                    String v = "";
                    for (int i = 1; i < listFirstRealization.size(); i++) {
                        v += listFirstRealization.get(i);
                        v += " ";
                    }
                    mapFirstRealization.put(listFirstRealization.get(0), v);
                    listFirstRealization.clear();
                }
                if(mapFirstRealization.get(inputWord)!=null) {
                    System.out.println(inputWord + " = " + mapFirstRealization.get(inputWord));
                }else{
                    System.out.print("Not found");

                }
                br.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
    static void letterCombination(String path){
        ArrayList<String> listSecondFunctional = new ArrayList();
        HashMap<String, String> mapSecondRealization = new HashMap();
        System.out.print("input letters ");

        Scanner sc = new Scanner(System.in);
        String inputWord2 = sc.nextLine();

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String s, v = "";
                while ((s = br.readLine()) != null) {
                    for (String retval : s.trim().split(" +")) {
                        listSecondFunctional.add(retval);
                    }
                    v += listSecondFunctional.get(0) + " ";
                    mapSecondRealization.put(listSecondFunctional.get(0), listSecondFunctional.get(1));
                    listSecondFunctional.clear();
                }
                int i=0;
                for (String retval : v.trim().split(" +")) {
                    if (retval.startsWith(inputWord2)) {

                        System.out.print(retval + " " + mapSecondRealization.get(retval) + " \n");
                        i++;

                    }

                }
                if(i==0){
                    System.out.print("No find this letters ");
                }
                br.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }


    static void translate(String path){
        ArrayList<String> listThirdFunctional = new ArrayList();
        HashMap<String, String> mapThirdFunctional = new HashMap();

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String s;
                while ((s = br.readLine()) != null) {
                    for (String retval : s.trim().split(" +")) {
                        listThirdFunctional.add(retval);
                    }
                    mapThirdFunctional.put(listThirdFunctional.get(0),listThirdFunctional.get(1));
                    listThirdFunctional.clear();
                }
                //System.out.println(inputWordThirdFunctional + " = " + mapThirdFunctional.get(inputWordThirdFunctional));
                System.out.print("input sentence :");
                Scanner sc = new Scanner(System.in);
                System.out.println();
                if(sc.hasNextLine()){
                    s=sc.nextLine();
                    for(String retval:s.trim().split(" +")){
                        System.out.print(mapThirdFunctional.get(retval)+" ");
                    }
                }
                br.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }


    static boolean test(String testString,String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(testString);
        return m.matches();
    }

}

