package question03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("----- SOMA DE NÚMEROS PARES -----");
        System.out.print("\nInforme o primeiro número: ");
        int numero1 = input.nextInt();
        System.out.print("Informe o segundo número: ");
        int numero2 = input.nextInt();

        MinhaThread minhaSoma = new MinhaThread(numero1, numero2);
        minhaSoma.run();

    }

}
