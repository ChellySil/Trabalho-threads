class Operacao implements Runnable {
    private ContaBancaria conta;
    private String tipoOperacao;
    private double valor;

    public Operacao(ContaBancaria conta, String tipoOperacao, double valor) {
        this.conta = conta;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }

    @Override
    public void run() {
        try {
    
            Thread.sleep((long) (Math.random() * 1000));
            if ("depositar".equalsIgnoreCase(tipoOperacao)) {
                conta.depositar(valor);
            } else if ("sacar".equalsIgnoreCase(tipoOperacao)) {
                conta.sacar(valor);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
