import javax.swing.*;


public class AppCalculadora {
    private static String operador = "";
    private static double num1 = 0;
    private static double num2 = 0;

    public static void main(String[] args) {
        // Criando e definindo o frame
        JFrame tela = new JFrame("Calculadora");
        tela.setSize(400, 500);
        tela.setResizable(false); // Impede o redimensionamento
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fechar a janela finaliza o programa
        tela.setLocationRelativeTo(null); // Centraliza a janela
        tela.setLayout(null); // Desabilita o gerenciador de layout

        // Criação do visor
        JTextField visor = new JTextField();
        visor.setBounds(30, 30, 340, 50); // x, y, largura, altura
        visor.setEditable(false); // O visor não deve ser editável
        tela.add(visor);

        // Criação dos botões
        int buttonLargura = 80;
        int buttonAltura = 40;

        // Linha 1 
        JButton buttonQuadrado = new JButton("x²");
        buttonQuadrado.setBounds(30, 90, buttonLargura, buttonAltura);
        tela.add(buttonQuadrado);
        buttonQuadrado.addActionListener(e -> {
            Calculadora calc = new Calculadora(Double.parseDouble(visor.getText()), 0, "");
            visor.setText(String.valueOf(calc.quadrado())); 
        });

        JButton buttonRaiz = new JButton("√x");
        buttonRaiz.setBounds(120, 90, buttonLargura, buttonAltura);
        tela.add(buttonRaiz);
        buttonRaiz.addActionListener(e -> {
            Calculadora calc = new Calculadora(Double.parseDouble(visor.getText()), 0, "");
            visor.setText(String.valueOf(calc.raiz())); 
        });

        JButton buttonPorcentagem = new JButton("%");
        buttonPorcentagem.setBounds(210, 90, buttonLargura, buttonAltura);
        tela.add(buttonPorcentagem);
        buttonPorcentagem.addActionListener(e -> {
            Calculadora calc = new Calculadora(Double.parseDouble(visor.getText()), 0, "");
            visor.setText(String.valueOf(calc.porcentagem())); 
        });

        JButton buttonLimpar = new JButton("C");
        buttonLimpar.setBounds(300, 90, buttonLargura, buttonAltura);
        tela.add(buttonLimpar);
        buttonLimpar.addActionListener(e -> {
            visor.setText("");
            operador = "";
            num1 = 0;
            num2 = 0;
        });

        // Linha 2
        JButton button7 = new JButton("7");
        button7.setBounds(30, 150, buttonLargura, buttonAltura);
        tela.add(button7);
        button7.addActionListener(e -> visor.setText(visor.getText() + "7"));

        JButton button8 = new JButton("8");
        button8.setBounds(120, 150, buttonLargura, buttonAltura);
        tela.add(button8);
        button8.addActionListener(e -> visor.setText(visor.getText() + "8"));

        JButton button9 = new JButton("9");
        button9.setBounds(210, 150, buttonLargura, buttonAltura);
        tela.add(button9);
        button9.addActionListener(e -> visor.setText(visor.getText() + "9"));

        JButton buttonMais = new JButton("+");
        buttonMais.setBounds(300, 150, buttonLargura, buttonAltura);
        tela.add(buttonMais);
        buttonMais.addActionListener(e -> {
            num1 = Double.parseDouble(visor.getText());
            operador = "+";
            visor.setText(visor.getText() + " + ");
        });

        // Linha 3
        JButton button4 = new JButton("4");
        button4.setBounds(30, 210, buttonLargura, buttonAltura);
        tela.add(button4);
        button4.addActionListener(e -> visor.setText(visor.getText() + "4"));

        JButton button5 = new JButton("5");
        button5.setBounds(120, 210, buttonLargura, buttonAltura);
        tela.add(button5);
        button5.addActionListener(e -> visor.setText(visor.getText() + "5"));

        JButton button6 = new JButton("6");
        button6.setBounds(210, 210, buttonLargura, buttonAltura);
        tela.add(button6);
        button6.addActionListener(e -> visor.setText(visor.getText() + "6"));

        JButton buttonMenos = new JButton("-");
        buttonMenos.setBounds(300, 210, buttonLargura, buttonAltura);
        tela.add(buttonMenos);
        buttonMenos.addActionListener(e -> {
            num1 = Double.parseDouble(visor.getText());
            operador = "-";
            visor.setText(visor.getText() + " - ");
        });

        // Linha 4
        JButton button1 = new JButton("1");
        button1.setBounds(30, 270, buttonLargura, buttonAltura);
        tela.add(button1);
        button1.addActionListener(e -> visor.setText(visor.getText() + "1"));

        JButton button2 = new JButton("2");
        button2.setBounds(120, 270, buttonLargura, buttonAltura);
        tela.add(button2);
        button2.addActionListener(e -> visor.setText(visor.getText() + "2"));

        JButton button3 = new JButton("3");
        button3.setBounds(210, 270, buttonLargura, buttonAltura);
        tela.add(button3);
        button3.addActionListener(e -> visor.setText(visor.getText() + "3"));

        JButton buttonVezes = new JButton("x");
        buttonVezes.setBounds(300, 270, buttonLargura, buttonAltura);
        tela.add(buttonVezes);
        buttonVezes.addActionListener(e -> {
            num1 = Double.parseDouble(visor.getText());
            operador = "x";
            visor.setText(visor.getText() + " x ");
        });

        // Linha 5
        JButton button0 = new JButton("0");
        button0.setBounds(120, 330, buttonLargura, buttonAltura);
        tela.add(button0);
        button0.addActionListener(e -> visor.setText(visor.getText() + "0"));

        JButton buttonVirgula = new JButton(",");
        buttonVirgula.setBounds(30, 330, buttonLargura, buttonAltura);
        tela.add(buttonVirgula);
        buttonVirgula.addActionListener(e -> visor.setText(visor.getText() + ","));

        JButton buttonIgual = new JButton("=");
        buttonIgual.setBounds(210, 330, buttonLargura, buttonAltura);
        tela.add(buttonIgual);
        buttonIgual.addActionListener(e -> {
            String[] partes = visor.getText().split(" ");
            if (partes.length == 3) {
                num2 = Double.parseDouble(partes[2]);
                Calculadora calc = new Calculadora(num1, num2, operador);
                double resultado = 0;

                switch (operador) {
                    case "+":
                        resultado = calc.somar();
                        break;
                    case "-":
                        resultado = calc.subtrair();
                        break;
                    case "x":
                        resultado = calc.multiplicar();
                        break;
                    case "/":
                        resultado = calc.dividir();
                        break;
                }

                visor.setText(String.valueOf(resultado)); // Exibe apenas o resultado
                num1 = resultado; // Mantém o resultado para novas operações
                operador = ""; // Reseta o operador
            }
        });

        // Linha 6 (operação de divisão)
        JButton buttonDivide = new JButton("/");
        buttonDivide.setBounds(300, 330, buttonLargura, buttonAltura);
        tela.add(buttonDivide);
        buttonDivide.addActionListener(e -> {
            num1 = Double.parseDouble(visor.getText());
            operador = "/";
            visor.setText(visor.getText() + " / ");
        });

        // Exibe a tela
        tela.setVisible(true);
    }
}
