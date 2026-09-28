package br.edu.aesa.app;

import br.edu.aesa.model.Veiculo;
import br.edu.aesa.service.VeiculoService;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final VeiculoService service = new VeiculoService();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1 -> cadastrarVeiculo();
                case 2 -> listarVeiculos();
                case 3 -> buscarVeiculo();
                case 4 -> atualizarVeiculo();
                case 5 -> removerVeiculo();
                case 0 -> System.out.println("\nPrograma encerrado. Até mais!");
                default -> System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n======================================");
        System.out.println("       GERENCIADOR DE VEÍCULOS");
        System.out.println("======================================");
        System.out.println("[1] Cadastrar veículo");
        System.out.println("[2] Listar veículos");
        System.out.println("[3] Buscar veículo por ID");
        System.out.println("[4] Atualizar veículo");
        System.out.println("[5] Remover veículo");
        System.out.println("[0] Sair");
        System.out.println("======================================");
    }

    private static void cadastrarVeiculo() {
        System.out.println("\n--- CADASTRO DE VEÍCULO ---");
        int id = lerInteiro("Digite o ID: ");
        String marca = lerTexto("Digite a marca: ");
        String modelo = lerTexto("Digite o modelo: ");
        int ano = lerInteiro("Digite o ano: ");
        String placa = lerTexto("Digite a placa: ");
        Veiculo veiculo = new Veiculo(id, marca, modelo, ano, placa);
        if (service.cadastrar(veiculo)) {
            System.out.println("\nVeículo cadastrado com sucesso!");
        } else {
            System.out.println("\nErro: não foi possível cadastrar o veículo. Verifique o ID.");
        }
    }

    private static void listarVeiculos() {
        System.out.println("\n--- LISTA DE VEÍCULOS ---");
        List<Veiculo> veiculos = service.listarTodos();
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }

    private static void buscarVeiculo() {
        System.out.println("\n--- BUSCAR VEÍCULO ---");
        int id = lerInteiro("Digite o ID do veículo: ");
        Veiculo veiculo = service.buscarPorId(id);
        if (veiculo != null) {
            System.out.println("\nVeículo encontrado:");
            System.out.println(veiculo);
        } else {
            System.out.println("\nNenhum veículo encontrado com o ID informado.");
        }
    }

    private static void atualizarVeiculo() {
        System.out.println("\n--- ATUALIZAR VEÍCULO ---");
        int id = lerInteiro("Digite o ID do veículo que deseja atualizar: ");
        Veiculo existente = service.buscarPorId(id);
        if (existente == null) {
            System.out.println("\nNenhum veículo encontrado com esse ID.");
            return;
        }
        System.out.println("\nVeículo atual:");
        System.out.println(existente);
        String marca = lerTexto("Nova marca: ");
        String modelo = lerTexto("Novo modelo: ");
        int ano = lerInteiro("Novo ano: ");
        String placa = lerTexto("Nova placa: ");
        Veiculo novosDados = new Veiculo(id, marca, modelo, ano, placa);
        if (service.atualizar(id, novosDados)) {
            System.out.println("\nVeículo atualizado com sucesso!");
        } else {
            System.out.println("\nErro ao atualizar o veículo.");
        }
    }

    private static void removerVeiculo() {
        System.out.println("\n--- REMOVER VEÍCULO ---");
        int id = lerInteiro("Digite o ID do veículo que deseja remover: ");
        if (service.remover(id)) {
            System.out.println("\nVeículo removido com sucesso!");
        } else {
            System.out.println("\nNenhum veículo encontrado com o ID informado.");
        }
    }

    private static String lerTexto(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String valor = scanner.nextLine().trim();
            if (!valor.isEmpty()) return valor;
            System.out.println("Digite uma informação válida.");
        }
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}
