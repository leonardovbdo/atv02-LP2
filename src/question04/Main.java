package question04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        final int TOTAL_THREADS = 3;

        MinhaThread[] threads = new MinhaThread[TOTAL_THREADS];
        System.out.println("### SOMA DOS NÚMEROS PARES DENTRO DO INTERVALO ###");

        for(int i = 0; i < TOTAL_THREADS; i++) {
            System.out.println("\nArray #"+(i+1));
            System.out.print("Informe o primeiro número: ");
            int numero1 = input.nextInt();
            System.out.print("Informe o segundo número: ");
            int numero2 = input.nextInt();

            MinhaThread minhaSoma = new MinhaThread(numero1, numero2);
            threads[i] = minhaSoma;
            threads[i].run();
        }

        input.nextLine();

        System.out.println("\n### PAINEL ###");
        boolean parar = false;
        do {
            System.out.println("\n### SELECIONE QUAL FUNÇÃO VOCÊ DESEJA REALIZAR ###");
            System.out.println("\n[A] - Exibir a soma dos números pares do intervalo a partir das somas do subintervalos");
            System.out.println("[B] - Verificar se há threads ativas");

            char escolha = input.nextLine().charAt(0);

            switch(escolha) {
                //Exibir a soma dos números pares do intervalo a partir das somas do subintervalos
                case 'A', 'a':
                    System.out.println("Qual thread você deseja exibir?");
                    int opcao = input.nextInt();
                    System.out.println(threads[opcao]);
                    input.nextLine();
                    break;

                case 'B', 'b':
                    //A thread está viva?
                    boolean umaViva = false;
                    for(int i = 0; i < TOTAL_THREADS; i++) {
                        if(threads[i].isAlive()) {
                            umaViva = true;
                            break;
                        }
                    }

                    if(!umaViva) {
                        parar = true;
                        System.out.println("\nTODAS AS THREADS REALIZARAM SEUS RESPECTIVOS CALCULOS!");
                    } else {
                        throw new Exception("AINDA TEM UMA THREAD VIVA");
                    }
                    break;
                case 'C', 'c':

            }
        }while (!parar);

        input.close();
    }
}