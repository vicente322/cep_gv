package com.gv;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class App {

      public static void main(String[] args) throws UnsupportedEncodingException{
            Scanner sc = new Scanner(System.in);
            String cep;

            ConsultaCep cc = new ConsultaCep();

            System.out.println("***CONSULTA DE CEP***");
            System.out.println("Insira o CEP desejado ou aperte enter para pesquisar por rua");
            System.out.println("CEP: ");
            cep = sc.nextLine();
            
            if (!cep.isBlank()){
                  String consulta, resposta;
                  MontaPesquisa pesquisa = new MontaPesquisa();
                  pesquisa.setCep(cep);
                  consulta = pesquisa.consultaCEP();

                  resposta = cc.submeteConsultaCEP(consulta);

                  System.out.println(resposta);
            }
            else {
                  String estado, cidade, logradouro, consulta, resposta;

                  System.out.println("Insira o Estado: ");
                  estado = sc.nextLine();
                  System.out.println("Insira a Cidade: ");
                  cidade = sc.nextLine();
                  System.out.println("Insira o Logradouro: ");
                  logradouro = sc.nextLine();
                  MontaPesquisa pesquisa = new MontaPesquisa();
                  pesquisa.setEstado(estado);
                  pesquisa.setCidade(cidade);
                  pesquisa.setLogradouro(logradouro);
                  consulta = pesquisa.consultaPorLogradouro();

                  resposta = cc.submeteConsultaLogradouro(consulta);

                  System.out.println(resposta);
            }

            sc.close();

      }
      
}
