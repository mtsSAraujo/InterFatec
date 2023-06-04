import java.util.Scanner;

public class crausio {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int linha = sc.nextInt();
        int coluna = sc.nextInt();

        int steps = sc.nextInt();

        int[][] casa = criaMatriz(linha, coluna);

        int linhaInicial = sc.nextInt() - 1;
        int colunaInicial = sc.nextInt() - 1;

        casa[linhaInicial][colunaInicial] = 1;

        String[] comandos = sc.next().split("");

        int currentLinha = linhaInicial;
        int currentColuna = colunaInicial;
        int bateu = 0;

        for(String dir : comandos){
            if(steps>0) {
                if(dir.equals("C") || dir.equals("B")){
                    currentLinha = checkPosition(currentLinha, currentColuna, dir);
                }else currentColuna = checkPosition(currentLinha, currentColuna, dir);
                if (currentLinha > linha || currentLinha < 0) {
                    bateu++;
                    if(currentLinha < 0){
                        currentLinha =0;
                    }else currentLinha = linha -1;
                } else if (currentColuna > coluna || currentColuna < 0) {
                    bateu++;
                    if (currentColuna < 0){
                        currentColuna = 0;
                    }else currentColuna = coluna - 1;
                }
            }
            steps --;
        }

        System.out.print((currentLinha+1)+ " "+ (currentColuna+1) + " " + bateu);

    }

    public static int[][] criaMatriz(int linha, int coluna){
        int[][] matriz = new int[linha][coluna];
        for (int i = 0; i < linha ; i++) {
            for (int j = 0; j < coluna; j++) {
                matriz[i][j] = 0;
            }

        }
        return matriz;
    }

    public static int checkPosition(int currentLinha, int currentColuna, String direction){
        switch (direction) {
            case "C":
                return currentLinha - 1;
            case "B":
                return currentLinha + 1;
            case "D":
                return currentColuna + 1;
            default:
                return currentColuna - 1;
        }
    }

}
