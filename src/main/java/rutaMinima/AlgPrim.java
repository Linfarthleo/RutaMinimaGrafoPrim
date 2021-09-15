package rutaMinima;
import java.util.*;
import java.util.Scanner;
/**
 *
 * @author Emilio Montalvo,Fernando Asitimbaya,Karla Vivas
 */
/*
Prim (N)
{Este algoritmo encuentra el árbol abarcador de costo mínimo de una gráfica G de N vértices,
U, V y L son estructuras de datos —arreglos o listas— que permiten guardar los nombres de
105 vértices y las aristas seleccionadas}

1. Mientras (V = U) Repetir
        Elegir una arista (u, v) ∈ A(G) tal que su costo sea mínimo, siendo u E U y y ∈ (V-U)
        Agregar la arista (u, v) a L
        Agregar el nodo v a U
2. {Fin del ciclo del paso 1}
*/
public class AlgPrim {//permite crear un arbol de  expansion minima con menores costos
    public int esVisitado[] = new int[15]; //Arreglo que almacena los nodos visitado
    public int costo[][];//Matriz que guarda costos minimo
    public int minimo_costo;//valor de un minimo costo

    public void calc(int n)//permite calcular los costos minimos
    {
        int flag[] = new int[n+1];//Guarda el numero de vertices visitados
        int i,j,min=999,num_edges=1,a=1,b=1,minpos_i=1,minpos_j=1;//valor min hace referencia la infinito
        //num_eddges es donde inicia
        //a origen de los veritices
        //b destino de los vertices
        //minpos minima posicion en i y j

        while(num_edges < n)//mientras el primer nodo sea menor al total de vertices recorrido
        {//recorre

            for(i=1,min=999;i<=n;i++)//no debe sobrepasas 999 ni los vetices
                for(j=1;j<=n;j++)
                    if(this.costo[i][j]<min)
                        if(this.esVisitado[i]!=0)//si este nodo visitado es diferente a 0(no hay ciclo)
                        {
                            min=this.costo[i][j];//minimo toma el valor del costo
                            a=minpos_i=i;//toma minima poscion de i
                            b=minpos_j=j;//toma minima poscion de j
                        }
            if(this.esVisitado[minpos_i]==0 || this.esVisitado[minpos_j]==0)//no exite enlace
            {
                System.out.println("Visitamos nodo \t"+num_edges+"\t desde vértice \t"+a+"\t a vértice \t"+b+"-minicosto:"+min+" \n");
                this.minimo_costo=this.minimo_costo+min;//toam valor de minimo costo
                num_edges=num_edges+1;//pasa al siguiente nodo
                this.esVisitado[b]=1;//marca el nodo como visitado
            }
            this.costo[a][b]=this.costo[b][a]=999;//infinito


        }

    }

    public AlgPrim(int[] esVisitado, int n) {
        costo = new int[n][n];
        this.esVisitado = esVisitado;
    }

    public static void main(String args[])
    {
        //permite crear arbol expandido
        int nodes,i,j;
        //ingresa el valor de nodos por teclafo
        Scanner in = new Scanner(System.in);
        System.out.println("Ingresar en número de nodos \n");
        nodes = in.nextInt();
        AlgPrim p = new AlgPrim ();//crea objeto de la clase prim
        //Ingresar los Pesos o Costos a la Matriz de Adyacencia etiquetada
        System.out.println("Ingresar los Pesos o Costos a la Matriz de Adyacencia etiquetada : \n");
        for(i=1;i<=nodes;i++)
            for(j=1;j<=nodes;j++)
            {
                p.costo[i][j]=in.nextInt();
                if(p.costo[i][j]==0)
                    p.costo[i][j]=999;//si no hay camino se coloca infinito
            }

        p.esVisitado[1]=1; // Inicialización para que parta desde el vertice de origen
        p.calc(nodes);//calculo de nodos
    }

}
