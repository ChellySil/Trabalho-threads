import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ContaBancaria {
    private double saldo;

    public ContaBancaria() {
        this.saldo = 0.0;
    }
    public synchronized void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println(Thread.currentThread().getName() + " depositou: R$" + valor);
            System.out.printf("Saldo atual: R$%.2f%n", saldo);
        } else {
            System.out.println("Valor de depósito deve ser positivo.");
        }
    }

    
    public synchronized void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println(Thread.currentThread().getName() + " sacou: R$" + valor);
            System.out.printf("Saldo atual: R$%.2f%n", saldo);
        } else {
            System.out.println("Saque não permitido. Verifique o valor.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
