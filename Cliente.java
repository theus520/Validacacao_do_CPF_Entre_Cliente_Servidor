package javapararedes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author matheus.leite
 */
public class Cliente {
    
    private static Socket socket;
    private static DataInputStream entrada;
    private static DataOutputStream saida;
    
    public static void main(String[] args) {
        
        try {
            
        socket = new Socket("127.0.0.1",13245);
        
        entrada = new DataInputStream(socket.getInputStream());
        saida = new DataOutputStream(socket.getOutputStream());
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do seu CPF");
        String cpf = scanner.nextLine();
        
        saida.writeUTF(cpf);
        
        String receberResultado = entrada.readUTF();
        System.out.println(receberResultado);
        
        saida.close();
        socket.close();
         } catch (Exception e) {
             System.out.println("Ocorreu um erro durante a execução" + e.getMessage());
             e.getStackTrace();
        }
    }
}
