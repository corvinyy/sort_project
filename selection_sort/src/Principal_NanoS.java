import javax.swing.JOptionPane;
import java.util.Arrays;

public class Principal_NanoS {

    public static void main(String[] args) {
        mostraOpcoes();
    }

    public static int[] lista = {
        432, 809, 213, 725, 37, 960, 578, 63, 921, 145, 689, 281, 506, 955, 194, 374, 820, 62,
        890, 485, 786, 911, 394, 178, 627, 902, 420, 579, 733, 96, 311, 654, 250, 771, 9, 624,
        712, 135, 505, 884, 445, 688, 77, 912, 721, 390, 538, 893, 470, 679, 1, 869, 302, 946,
        561, 144, 790, 422, 769, 57, 899, 308, 687, 469, 237, 630, 961, 36, 578, 799, 180, 628,
        886, 298, 835, 62, 974, 214, 518, 746, 132, 899, 243, 511, 798, 235, 681, 61, 918, 375,
        692, 993, 183, 553, 846, 24, 954, 286, 647, 129
    };

    ////////////////////////////////////////////////////////////////////////////

    public static int[] selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    ////////////////////////////////////////////////////////////////////////////

    public static void mostrarPiorCaso() {
        int[] listaCopia = lista.clone();    
        Arrays.sort(listaCopia);               
        int[] listaDcrsc = new int[listaCopia.length];
    
        for (int i = 0; i < listaCopia.length; i++) {                          
            listaDcrsc[i] = listaCopia[listaCopia.length - 1 - i];
        }
    
        StringBuilder listaDcrsc_2 = new StringBuilder();
        for (int i = 0; i < listaDcrsc.length; i++) {
            listaDcrsc_2.append(listaDcrsc[i]).append(" ");
             
            if ((i + 1) % 20 == 0) {              
                listaDcrsc_2.append("\n");
            }
        }
    
        long tempoI = System.nanoTime();  
        int[] listaOrd = selectionSort(listaDcrsc);  
        long tempoF = System.nanoTime();
    
        StringBuilder listaOrd_2 = new StringBuilder();
        for (int i = 0; i < listaOrd.length; i++) {
            listaOrd_2.append(listaOrd[i]).append(" ");
            
            if ((i + 1) % 20 == 0) {          
                listaOrd_2.append("\n");
            }
        }
    
        JOptionPane.showMessageDialog(null, "Lista decrescente (pior caso):\n" + listaDcrsc_2 +
                "\n\nLista ordenada (com selection sort):\n" + listaOrd_2 +
                "\n\nTempo de execução: " + (tempoF - tempoI) + " ns");
    }
    
    ////////////////////////////////////////////////////////////////////////////

    public static void mostrarMedioCaso() {
        StringBuilder original = new StringBuilder();
        for (int i = 0; i < lista.length; i++) {
            original.append(lista[i]).append(" ");
            
            if ((i + 1) % 20 == 0) {        
                original.append("\n");
            }
        }
    
        long tempoI = System.nanoTime();   
        int[] listaOrd = selectionSort(lista.clone()); 
        long tempoF = System.nanoTime();
    
        StringBuilder ordenada = new StringBuilder();
        for (int i = 0; i < listaOrd.length; i++) {
            ordenada.append(listaOrd[i]).append(" ");
            
            if ((i + 1) % 20 == 0) {    
                ordenada.append("\n");
            }
        }
    
        JOptionPane.showMessageDialog(null, "Lista original (médio caso):\n" + original +
                "\n\nLista ordenada (com selection sort):\n" + ordenada +
                "\n\nTempo de execução: " + (tempoF - tempoI) + " ns");
    }

    ////////////////////////////////////////////////////////////////////////////

    public static void mostrarMelhorCaso() { 
        int[] listaCopia = lista.clone();  
        Arrays.sort(listaCopia); 
    
        StringBuilder listaCrsc = new StringBuilder();
        for (int i = 0; i < listaCopia.length; i++) {
            listaCrsc.append(listaCopia[i]).append(" ");
            
            if ((i + 1) % 20 == 0) {  
                listaCrsc.append("\n");
            }
        }
    
        long tempoI = System.nanoTime();     
        int[] listaOrd = selectionSort(listaCopia);
        long tempoF = System.nanoTime();
    
        StringBuilder listaOrd_2 = new StringBuilder();
        for (int i = 0; i < listaOrd.length; i++) {
            listaOrd_2.append(listaOrd[i]).append(" ");
            
            if ((i + 1) % 20 == 0) {  
                listaOrd_2.append("\n");
            }
        }
    
        JOptionPane.showMessageDialog(null, "Lista crescente (melhor caso):\n" + listaCrsc +
                "\n\nLista ordenada (com selection sort):\n" + listaOrd_2 +
                "\n\nTempo de execução: " + (tempoF - tempoI) + " ns");
    }

    ////////////////////////////////////////////////////////////////////////////

    public static void mostraOpcoes() {
        String opcao = JOptionPane.showInputDialog("Digite um número para ordenar a lista: \n" +
                "1 - Pior caso\n" +
                "2 - Médio caso \n" +
                "3 - Melhor caso \n" +
                "4 - Sair");

        if (opcao.equals("1")) {
            mostrarPiorCaso();
            mostraOpcoes();

        } else if (opcao.equals("2")) {
            mostrarMedioCaso();
            mostraOpcoes();

        } else if (opcao.equals("3")) {
            mostrarMelhorCaso();
            mostraOpcoes();

        } else if (opcao.equals("4")) {
            JOptionPane.showMessageDialog(null, "Saindo...");
            
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida!");
            mostraOpcoes();
        }
    }
}
