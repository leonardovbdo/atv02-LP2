package question04;

import java.util.Scanner;

public class MinhaThread extends Thread{

    Scanner input = new Scanner(System.in);

    private int intervalo1, intervalo2, intervalo3,
            numero1, numero2, soma;

    public int getSoma() {
        return soma;
    }

    public void setSoma(int soma) {
        this.soma = soma;
    }

    public MinhaThread(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        soma = 0;
    }

    @Override
    public void run() {

       int somaFinal = getSoma();
        if(numero1 > numero2){
            System.out.println("Intervalo inválido");
        } else {
            for (int i = numero1; i <= numero2; i++) {
                if (i % 2 == 0) {
                    somaFinal += i;
                    setSoma(somaFinal);
                }
            }
        }

        System.out.println("A soma dos números pares entre o intervalo é:"+getSoma());

        System.out.println("\n### Selecione qual função você deseja realizar ###");
        System.out.println("\n[A] - Exibir a soma dos números pares do intervalo a partir das somas dos subintervalos");
        System.out.println("[B] - Encerrar o programa");

        String opção = input.nextLine();
        switch (opção) {
            case "A":
                if(numero1 > numero2) {
                    System.out.println("Intervalo inválido");
                } else {
                    System.out.println("\nA soma dos números pares dentro de cada uma das três subdivisões será: ");
                    for(int i = numero1; i <= numero2; i++) {
                        if(i%2==0) {
                            if((i <=(int)((numero2 - numero1)*(double)1/3))) {
                                intervalo1 += i;
                            }else if((i <=(int)((numero2 - numero1)*(double)2/3))) {
                                intervalo2 += i;
                            } else if((i <=((numero2 - numero1)))) {
                                intervalo3 += i;
                            }

                        }
                    }
                }
                System.out.println(intervalo1);
                System.out.println(intervalo2);
                System.out.println(intervalo3);
                System.out.println("\nSomando as somas de cada subdivisão, chegamos ao número total: "+(intervalo1+intervalo2+intervalo3));
                break;
        }
    }
}

