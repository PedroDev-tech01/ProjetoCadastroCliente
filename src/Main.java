import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Crud dao = new Crud(); // usando Crud
        int opcao;

        do {
            System.out.println("\n===== MENU CLIENTES =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Remover Cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1 -> { // CREATE
                    System.out.print("Nome: ");
                    String nome = input.nextLine();
                    System.out.print("CPF: ");
                    String cpf = input.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = input.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = input.nextLine();

                    Clientes c = new Clientes(nome, cpf, endereco, telefone);
                    dao.adicionar(c);
                }

                case 2 -> dao.listar(); // READ

                case 3 -> { // UPDATE
                    dao.listar();
                    System.out.print("Digite o número do cliente que deseja atualizar: ");
                    int indice = input.nextInt() - 1;
                    input.nextLine();

                    if (indice >= 0 && indice < dao.tamanho()) {
                        System.out.print("Novo nome: ");
                        String nome = input.nextLine();
                        System.out.print("Novo CPF: ");
                        String cpf = input.nextLine();
                        System.out.print("Novo endereço: ");
                        String endereco = input.nextLine();
                        System.out.print("Novo telefone: ");
                        String telefone = input.nextLine();

                        Clientes c = new Clientes(nome, cpf, endereco, telefone);
                        dao.atualizar(c);
                    } else {
                        System.out.println("Índice inválido!");
                    }
                }

                case 4 -> { // DELETE
                    dao.listar();
                    System.out.print("Digite o número do cliente que deseja remover: ");
                    int indice = input.nextInt() - 1;

                    if (indice >= 0 && indice < dao.tamanho()) {
                        dao.remover(indice);
                    } else {
                        System.out.println("Índice inválido!");
                    }
                }

                case 0 -> System.out.println("Saindo...");

                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        input.close();
    }
}
