package question03;
public class MinhaThread extends Thread{

    int soma;
    int numero1;
    int numero2;

    public void setSoma(int soma) {
        this.soma = soma;
    }
    public int getSoma(){
        return soma;
    }

    public int totalSoma() throws Exception{
        if(getState() == State.NEW) {
            return soma;
        } else {
            throw new Exception("Soma ainda em andamento...");
        }
    }

    public MinhaThread(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        soma = 0;
    }

    @Override
    public void run() {
        int somaFinal = getSoma();
        if(numero1 > numero2) {
            System.out.println("Intervalo inválido");
        } else {
            for(int i = numero1; i <= numero2; i++) {
                if(i%2 == 0) {
                    somaFinal += i;
                    setSoma(somaFinal);
                }
            }
        }
        try {
            System.out.println("A soma dos pares no intervalo dos dois números é: "+(totalSoma()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
