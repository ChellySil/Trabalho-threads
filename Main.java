public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();
        List<Thread> threads = new ArrayList<>();

      
        try (BufferedReader br = new BufferedReader(new FileReader("operacoes.txt"))) {
            String linha;
            br.readLine(); 
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                String tipoOperacao = partes[0].trim();
                double valor = Double.parseDouble(partes[1].trim());

                Operacao operacao = new Operacao(conta, tipoOperacao, valor);
                Thread thread = new Thread(operacao);
                threads.add(thread);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Exibe o saldo final
        System.out.printf("Saldo final: R$%.2f%n", conta.getSaldo());
    }
}
