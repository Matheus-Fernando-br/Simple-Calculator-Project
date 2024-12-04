public class Calculadora implements Operacoes {
    private double num1;
    private double num2;
    private String operador;

    public Calculadora(double num1, double num2, String operador) {
        this.num1 = num1;
        this.num2 = num2;
        this.operador = operador;
    }

    public double somar() {
        return num1 + num2;
    }

    public double subtrair() {
        return num1 - num2;
    }

    public double multiplicar() {
        return num1 * num2;
    }
    
    public double dividir() {
        return num1 / num2;
    }

    public double quadrado() {
        return Math.pow(num1, 2);
    }

    public double raiz() {
        return Math.sqrt(num1);
    }

    public double porcentagem() {
        return num1 / 100;
    }
}
