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


public class AlgPrim {
    public int esVisitado[];
    public int costo[][];
    public int minimo_costo;

    public AlgPrim(int n) {
        costo = new int[n+1][n+1];
        esVisitado =new int[n+1];
    }

    public String calc(int n,ArrayList<String> paises,ArrayList<String> ciudades)
    {
        int flag[] = new int[n+1];
        int i,j,min=999,num_edges=1,a=1,b=1,minpos_i=1,minpos_j=1;
        String r="";

        while(num_edges < n)
        {

            for(i=1,min=999999;i<=n;i++)
                for(j=1;j<=n;j++)
                    if(this.costo[i][j]<min)
                        if(this.esVisitado[i]!=0)
                        {
                            min=this.costo[i][j];
                            a=minpos_i=i;
                            b=minpos_j=j;
                        }
            if(this.esVisitado[minpos_i]==0 || this.esVisitado[minpos_j]==0)
            {


                r+=(/*"Visitamos nodo \t"+ciudades.get(num_edges-1)+"\t */"Conectar "+ciudades.get(a-1)+" con "+ciudades.get(b-1)+" (distancia:"+min+")\n");
                System.out.println(r);
                this.minimo_costo=this.minimo_costo+min;
                num_edges=num_edges+1;
                this.esVisitado[b]=1;
            }
            this.costo[a][b]=this.costo[b][a]=999999;


        }

        return r;

    }
/*
    public static void main(String args[])
    {

        int nodes,i,j;

        Scanner in = new Scanner(System.in);
        System.out.println("Ingresar en número de nodos \n");
        nodes = in.nextInt();
        AlgPrim p = new AlgPrim ();

        System.out.println("Ingresar los Pesos o Costos a la Matriz de Adyacencia etiquetada : \n");
        for(i=1;i<=nodes;i++)
            for(j=1;j<=nodes;j++)
            {
                p.costo[i][j]=in.nextInt();
                if(p.costo[i][j]==0)
                    p.costo[i][j]=999;
            }

        p.esVisitado[1]=1;
        p.calc(nodes);
    }*/

}
