import model.Cliente;
import repository.ClienteRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    static ClienteRepository repo = new ClienteRepository();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        repo.criarTabela();

        int opcao;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║   SISTEMA DE CADASTRO 1.0    ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1 - Cadastrar cliente        ║");
            System.out.println("║ 2 - Listar todos             ║");
            System.out.println("║ 3 - Buscar por ID            ║");
            System.out.println("║ 4 - Atualizar cliente        ║");
            System.out.println("║ 5 - Deletar cliente          ║");
            System.out.println("║ 0 - Sair                     ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> buscar();
                case 4 -> atualizar();
                case 5 -> deletar();
                case 0 -> System.out.println("Até mais! 👋");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void cadastrar() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        repo.cadastrar(new Cliente(nome, email, telefone));
    }

    static void listar() {
        List<Cliente> lista = repo.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\n--- CLIENTES ---");
            lista.forEach(System.out::println);
        }
    }

    static void buscar() {
        System.out.print("ID do cliente: ");
        int id = scanner.nextInt();
        Cliente c = repo.buscarPorId(id);
        System.out.println(c != null ? c : "Cliente não encontrado.");
    }

    static void atualizar() {
        System.out.print("ID do cliente a atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo email: ");
        String email = scanner.nextLine();
        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();
        Cliente c = new Cliente(nome, email, telefone);
        c.setId(id);
        repo.atualizar(c);
    }

    static void deletar() {
        System.out.print("ID do cliente a deletar: ");
        int id = scanner.nextInt();
        repo.deletar(id);
    }
}