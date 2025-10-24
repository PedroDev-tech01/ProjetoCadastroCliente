import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nome = lerTextoMaiusculo(input, "Digite o seu nome: ");
        String cpf = lerTextoMaiusculo(input, "Digite o seu CPF: ");
        String email = lerTextoMaiusculo(input, "Digite o seu email: ");
        String telefone = lerTextoMaiusculo(input, "Digite o seu telefone: ");

        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        input.close();
        System.out.println("CADASTRO DE CLIENTE CONCLUIDO");
    }
    public static String lerTextoMaiusculo(Scanner scanner, String mensagem){
            System.out.print(mensagem);
            return scanner.nextLine().toUpperCase();
        }
    }
}