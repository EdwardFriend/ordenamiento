import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int arreglo[]={5,2,6,1,3,56,43,89,49,21,17};
        //seleccion(arreglo);
        //System.out.println(Arrays.toString(arreglo));
        //Insercion(arreglo);
        //System.out.println(Arrays.toString(arreglo));
        quicksort(arreglo,0,arreglo.length-1);
        System.out.println(Arrays.toString(arreglo));
    }
    
    
    
//método java de ordenación por inserción
    public static void Insercion(int t[] )
    {
        int i, j;
        int actual;
     
        for (i = 1; i < t.length; i++) {
            actual = t[i];
            for (j = i; j > 0 && t[j - 1] > actual; j--) {
                t[j] = t[j - 1];
            }
            t[j] = actual;
        }
    }


    
//método java de ordenación por selección
    public static void seleccion(int A[]) {
        int i, j, menor, pos, tmp;
            for (i = 0; i < A.length - 1; i++) {      // tomamos como menor el primero
                menor = A[i];                       // de los elementos que quedan por ordenar                    
                pos = i;                            // y guardamos su posición
                for (j = i + 1; j < A.length; j++){ // buscamos en el resto
                    if (A[j] < menor) {           // del array algún elemento
                        menor = A[j];             // menor que el actual
                        pos = j;
                    }
                }
                if (pos != i){                      // si hay alguno menor se intercambia                         
                    tmp = A[i];
                    A[i] = A[pos];
                    A[pos] = tmp;
                }
        }
    }



//método java de ordenación por Quicksort
    public static void quicksort(int A[], int izq, int der) {

        int pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i < j){                          // mientras no se crucen las búsquedas                                   
            while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while(A[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado                      
                aux= A[i];                      // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }

        A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
        A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quicksort(A,j+1,der);          // ordenamos subarray derecho
    }
}