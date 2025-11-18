import java.util.Scanner;

public class Clientes {
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Clientes(String nome, String cpf, String endereco, String telefone) {
        setNome(nome);
        this.cpf = cpf;
        setEndereco(endereco);
        setTelefone(telefone);
    }

    public Clientes(int id , String nome, String cpf, String endereco, String telefone, String s) {
        this.id = id;
        setNome(nome);
        this.cpf = cpf;
        setEndereco(endereco);
        setTelefone(telefone);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Scanner input = new Scanner(System.in);

        while (true) {
            if (nome == null || nome.trim().isEmpty()) {
                System.out.println("Nome não pode ser vazio!");
            } else if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                System.out.println("Nome não pode conter números ou caracteres especiais!");
            } else if (nome.length() >= 10) {
                System.out.println("Nome não pode ter mais de 50 caracteres!");
            } else {

                this.nome = nome;
                break;
            }
                System.out.print("Digite o nome novamente: ");
                nome = input.nextLine();

        }
    }
    public String getCpf() {
        return cpf;

    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        Scanner input = new Scanner(System.in);

        while (true) {
            if (endereco == null || endereco.trim().isEmpty()) {
                System.out.println("Nome não pode ser vazio!");
            } else if (endereco.length()  >15 ) {
                System.out.println("endereco não pode ter mais de 15 caracteres!");
            } else {
                this.endereco = endereco;
                break;
            }
            System.out.print("Digite o nome novamente: ");
            endereco = input.nextLine();
    }
}
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        Scanner input = new Scanner(System.in);

        while (true) {
            if (telefone == null || telefone.trim().isEmpty()) {
                System.out.println("telefone não pode ser vazio!");
            } else if (telefone.length() < 10) {
                System.out.println("Telefone nao Pode ter Menos caracteres que o Padrao ");
            } else {

                this.telefone = telefone;
                break;
            }
            System.out.print("Digite o nome novamente: ");
            telefone = input.nextLine();

        }
    }
}
