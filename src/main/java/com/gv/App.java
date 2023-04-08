package com.gv;

import java.util.Scanner;

public class App {

      public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String cep;

            ConsultaCep cc = new ConsultaCep();

            System.out.println("***CONSULTA DE CEP***");
            System.out.println("Insira o CEP desejado ou aperte enter para pesquisar por rua");
            System.out.println("CEP: ");
            cep = sc.nextLine();
            
            if (cep.length() != 0){
                  MontaPesquisa pesquisa = new MontaPesquisa();
                  pesquisa.setCep(cep);
                  ConsultaCep consulta = pesquisa.consultaCEP();
            }
      }
      


}
