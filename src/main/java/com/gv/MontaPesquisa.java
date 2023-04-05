package com.gv;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/** Monta Pesquisa
 * @author @vicente322 @gabicolares
 */

public class MontaPesquisa {
      
      private String logradouro;
      private String cidade;
      private String estado;
      private String cep;

      public static void validaCep(String cep) {
            if (cep.length() != 8) throw new IllegalArgumentException(
            "CEP no formato errado. Deve conter 8 numeros, sem outros caracteres");
      }

      public MontaPesquisa(){

      }

      public String getLogradouro() {
            return logradouro;
      }

      public void setLogradouro(String logradouro) {
            this.logradouro = logradouro;
      }

      public String getCidade() {
            return cidade;
      }

      public void setCidade(String cidade) {
            this.cidade = cidade;
      }

      public String getEstado() {
            return estado;
      }

      public void setEstado(String estado) {
            this.estado = estado;
      }

      public String getCep() {
            return cep;
      }

      public void setCep(String cep) {
            this.cep = cep;
      }

      public String consultaCEP() throws UnsupportedEncodingException{
            String formato = StandardCharsets.UTF_8.toString();
            StringBuffer qwery = new StringBuffer();
            MontaPesquisa.validaCep(cep);
            qwery.append("/");
            qwery.append(URLEncoder.encode(cep, formato));
            return qwery.toString();
      }

      public String consultaPorLogradouro() throws UnsupportedEncodingException {
            String formato = StandardCharsets.UTF_8.toString();
            StringBuffer qwery = new StringBuffer();
            if (estado != null && estado.length() > 0) {
                  qwery.append("/" + URLEncoder.encode(estado, formato));
            }
            if (cidade != null && cidade.length() > 0) {
                  cidade = URLEncoder.encode(cidade, formato);
                  cidade = cidade.replaceAll("\\+", "%20");
                  qwery.append("/" + cidade);
            }
            if (logradouro != null && logradouro.length() > 0) {
                  logradouro = URLEncoder.encode(logradouro, formato);
                  logradouro = logradouro.replaceAll("\\+", "%20");
                  qwery.append("/" + logradouro);
            }
            return qwery.toString();
      }
}
