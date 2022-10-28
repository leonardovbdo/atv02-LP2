package question04;

import java.util.Arrays;
import java.util.Scanner;

public class MinhaThread extends Thread{

    Scanner input = new Scanner(System.in);

    private int intervalo1, intervalo2, intervalo3,
            numero1, numero2, soma;

    public int getSoma() {
        return soma;
    }

    public void imprimir() {

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
        if(this.numero1 > this.numero2) {
            System.out.println("Intervalo inválido");
        } else {
            for(int i = this.numero1; i <= this.numero2; i++) {
                if(i%2==0) {
                    if((i <=(int)((this.numero2 - this.numero1)*(double)1/3))) {
                        intervalo1 += i;
                    }else if((i <=(int)((this.numero2 - this.numero1)*(double)2/3))) {
                        intervalo2 += i;
                    } else if((i <=((this.numero2 - this.numero1)))) {
                        intervalo3 += i;
                    }

                }
            }
        }
    }

    public String toString() {
        return "\nA soma dos números pares dentro de cada uma das três subdivisões será: [" + intervalo1 + ", " + intervalo2 +
                ", " + intervalo3 + "]";
    }

}