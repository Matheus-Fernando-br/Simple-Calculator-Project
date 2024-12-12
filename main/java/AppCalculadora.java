import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

public class AppCalculadora {
    private static String operador = "";
    private static double num1 = 0;
    private static double num2 = 0;

    public static void main(String[] args) {
        // Criando e definindo o frame
        JFrame tela = new JFrame("Calculadora");
        tela.setSize(500, 600);
        tela.setResizable(false); // Impede o redimensionamento
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fechar a janela finaliza o programa
        tela.setLocationRelativeTo(null); // Centraliza a janela
        tela.setLayout(new BorderLayout());

        //Painel para botões
        JPanel painel = new JPanel(new GridLayout(5,2));
        painel.setLayout(new GridLayout(5,4));

        // Criação do visor
        JTextField visor = new JTextField();
        visor.setEditable(false); // O visor não deve ser editável
        visor.setPreferredSize(new Dimension(400, 100)); // Define o tamanho preferido
        // Aumentando o tamanho da fonte do visor
        visor.setFont(new Font("Courier", Font.BOLD , 24)); // Define a fonte e o tamanho);
          
        tela.add(visor, BorderLayout.NORTH);
        tela.add(painel, BorderLayout.CENTER);

       

        // Linha 1 
        JButton buttonQuadrado = new JButton("x²");
        painel.add(buttonQuadrado);
        buttonQuadrado.addActionListener(e -> {
            Calculadora calc = new Calculadora(Double.parseDouble(visor.getText()), 0, "");
            visor.setText(String.valueOf(calc.quadrado())); 
        });

        JButton buttonRaiz = new JButton("√x");
        
        painel.add(buttonRaiz);
        buttonRaiz.addActionListener(e -> {
            Calculadora calc = new Calculadora(Double.parseDouble(visor.getText()), 0, "");
            visor.setText(String.valueOf(calc.raiz())); 
        });

        JButton buttonPorcentagem = new JButton("%");
        painel.add(buttonPorcentagem);
        buttonPorcentagem.addActionListener(e -> {
            Calculadora calc = new Calculadora(Double.parseDouble(visor.getText()), 0, "");
            visor.setText(String.valueOf(calc.porcentagem())); 
        });

        JButton buttonLimpar = new JButton("C");
       
        painel.add(buttonLimpar);
        buttonLimpar.addActionListener(e -> {
            visor.setText("");
            operador = "";
            num1 = 0;
            num2 = 0;
        });

        // Linha 2
        JButton button7 = new JButton("7");
        painel.add(button7);
        button7.addActionListener(e -> visor.setText(visor.getText() + "7"));

        JButton button8 = new JButton("8");

        painel.add(button8);
        button8.addActionListener(e -> visor.setText(visor.getText() + "8"));

        JButton button9 = new JButton("9");

        painel.add(button9);
        button9.addActionListener(e -> visor.setText(visor.getText() + "9"));

        JButton buttonMais = new JButton("+");
        
        painel.add(buttonMais);
        buttonMais.addActionListener(e -> {
            num1 = Double.parseDouble(visor.getText());
            operador = "+";
            visor.setText(visor.getText() + " + ");
        });

        // Linha 3
        JButton button4 = new JButton("4");
        painel.add(button4);
        button4.addActionListener(e -> visor.setText(visor.getText() + "4"));

        JButton button5 = new JButton("5");

        painel.add(button5);
        button5.addActionListener(e -> visor.setText(visor.getText() + "5"));

        JButton button6 = new JButton("6");

        painel.add(button6);
        button6.addActionListener(e -> visor.setText(visor.getText() + "6"));

        JButton buttonMenos = new JButton("-");
        
        painel.add(buttonMenos);
        buttonMenos.addActionListener(e -> {
            num1 = Double.parseDouble(visor.getText());
            operador = "-";
            visor.setText(visor.getText() + " - ");
        });

        // Linha 4
        JButton button1 = new JButton("1");
        painel.add(button1);
        button1.addActionListener(e -> visor.setText(visor.getText() + "1"));

        JButton button2 = new JButton("2");

        painel.add(button2);
        button2.addActionListener(e -> visor.setText(visor.getText() + "2"));

        JButton button3 = new JButton("3");

        painel.add(button3);
        button3.addActionListener(e -> visor.setText(visor.getText() + "3"));

        JButton buttonVezes = new JButton("x");
        
        painel.add(buttonVezes);
        buttonVezes.addActionListener(e -> {
            num1 = Double.parseDouble(visor.getText());
            operador = "x";
            visor.setText(visor.getText() + " x ");
        });

        // Linha 5
        JButton button0 = new JButton("0");

        painel.add(button0);
        button0.addActionListener(e -> visor.setText(visor.getText() + "0"));

        JButton buttonVirgula = new JButton(",");
        
        painel.add(buttonVirgula);
        buttonVirgula.addActionListener(e -> visor.setText(visor.getText() + ","));

        JButton buttonIgual = new JButton("=");
        
        painel.add(buttonIgual);
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
        
        painel.add(buttonDivide);
        buttonDivide.addActionListener(e -> {
            num1 = Double.parseDouble(visor.getText());
            operador = "/";
            visor.setText(visor.getText() + " / ");
        });

        // Exibe a tela
        tela.setVisible(true);
    }
}
