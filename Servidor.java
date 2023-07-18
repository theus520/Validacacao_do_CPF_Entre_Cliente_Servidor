
package javapararedes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;

/**
 *
 * @author matheus.leite
 */
public class Servidor {

	 private static ServerSocket server;
	    private static DataInputStream entrada;
	    private static DataOutputStream saida;

	    public static void main(String[] args) {

	        try {
	            server = new ServerSocket(50000); 
	            System.out.println("Aguardando conexão");
	            Socket socket = server.accept(); 
	            System.out.println("Conexão realizada");

            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());

            String cpf = entrada.readUTF();
            
            boolean cpfValido = isValidCPF(cpf);
            
            String cpfFprmatado = MostarCPF(cpf);
            
            if(cpfValido) {
            	saida.writeUTF("CPF Válido " + cpfFprmatado);
            }else {
            	saida.writeUTF("CPF Inválido ");
            }
            
            server.close();
            socket.close();
            entrada.close();
            saida.close();
            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a execução" + e.getMessage());
            e.getStackTrace();
       }
    }

    public static boolean isValidCPF(String cpf) {
        // considera-se erro cpf formando por uma sequencia de números iguais
        if (cpf.equals("00000000000")
                || cpf.equals("11111111111")
                || cpf.equals("22222222222")
                || cpf.equals("33333333333")
                || cpf.equals("44444444444")
                || cpf.equals("55555555555")
                || cpf.equals("66666666666")
                || cpf.equals("77777777777")
                || cpf.equals("88888888888")
                || cpf.equals("99999999999")
                || (cpf.length() != 11)) {
            return false;
        }

        char digito10, digito11;
        int soma, indice, resto, numero, peso;

        try {
            // cálculo do 1º dígito verificador
            soma = 0;
            peso = 10;
            for (indice = 0; indice < 9; indice++) {
                numero = (int) (cpf.charAt(indice) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            if (resto == 10 || resto == 11) {
                digito10 = '0';
            } else {
                digito10 = (char) (resto + 48);
            }

            // cálculo do 2º dígito verificador
            soma = 0;
            peso = 11;

            for (indice = 0; indice < 10; indice++) {
                numero = (int) (cpf.charAt(indice) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            if (resto == 10 || resto == 11) {
                digito11 = '0';
            } else {
                digito11 = (char) (resto + 48);
            }

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            return (digito10 == cpf.charAt(9) && digito11 == cpf.charAt(10));
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    public static String MostarCPF(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }
}