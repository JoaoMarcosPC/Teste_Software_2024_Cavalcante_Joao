public class Inicial {
    private double saldo;
    private boolean ativo;

    public double getSaldo() {
        return saldo;
    }

    public void ativar() {
        this.ativo=true;
    }

    public void desativar() {
        this.ativo=false;
    }

    public void depositar(double valor) {
        if(this.ativo) {
            this.saldo = saldo + valor;
        } else {
            throw new RuntimeException("Conta inativa, deposito negado!");
        }
    }

    public void sacar(double valor) {
        if(this.ativo && (this.saldo >= valor)) {
            saldo -= valor;
        } else {
            throw new RuntimeException("Conta inativa ou saldo insuficiente, saque negado!");
        }
    }
}
