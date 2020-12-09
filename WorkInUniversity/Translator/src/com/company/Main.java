package com.company;


import java.util.*;
import static com.company.Methoods.*;

public class Main {
    public static void main(String[] args) {

        //input language ***************************
        boolean flagExitProgram = true;
        boolean flagExitFunctional = true;
        while(flagExitProgram) {
            Menu.language();
            Scanner sc = new Scanner(System.in);
            String language = sc.nextLine();
            if(!test(language,"[1|2]")){
                System.err.println("input 1 or 2");
                continue;
            }
       if(!flagExitFunctional){
           flagExitFunctional = true;
       }
            while (flagExitFunctional) {
                Menu.functional();
                sc = new Scanner(System.in);
                String functional = sc.nextLine();
                if(!test(functional,"[1-5]")){
                    System.err.println("input number betweet 1-5 pls");
                    continue;
                }

                //choose functional ******************

                switch (functional) {
                    case "1":
                        if (language.equals("1")) {
                            Methoods.synonyms("Text/EnRu.txt");
                        } else {
                            Methoods.synonyms("Text/RuEn.txt");
                        }
                        break;
                    case "2":
                        if (language.equals("1")){
                            Methoods.letterCombination("Text/EnRu.txt");
                        }else{
                            Methoods.letterCombination("Text/RuEn.txt");
                        }
                        break;
                    case "3":
                        if(language.equals("1")){
                            Methoods.translate("Text/EnRu.txt");
                        }else{
                            Methoods.translate("Text/RuEn.txt");
                        }
                        break;
                    case "4":
                        flagExitFunctional = false;
                        break;
                    case "5":
                        flagExitProgram = false;
                        flagExitFunctional = false;
                        sc.close();
                        break;

                }
            }
        }
    }
}
