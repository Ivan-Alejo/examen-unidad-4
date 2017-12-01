public class ArbolBinario {

    private NodoArbol raiz;

    public ArbolBinario(){

        raiz=null;
    }

    public NodoArbol obtenerRaiz(){

        return raiz;
    }

    public NodoArbol buscar(int d,NodoArbol r){
      if(raiz==null) {
          return null;
      }else if(r.dato==d){
        return r;
      }else if(r.dato<d){
          return buscar(d, r.hijoDerecho);
      }else {
          return buscar(d, r.hijoIzquierdo);
      }


    }

    public int obtenerFE(NodoArbol x) {
        if (x == null) {
            return -1;
        } else {
            return x.fe;

        }

    }

    public NodoArbol rotacionIzquierda(NodoArbol c){
        NodoArbol auxiliar=c.hijoIzquierdo;
        c.hijoIzquierdo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe= c.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }

    public NodoArbol rotacionDerecha(NodoArbol c){
        NodoArbol auxiliar=c.hijoDerecho;
        c.hijoDerecho=auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe= c.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }

    public NodoArbol rotacionDobleIzquierda(NodoArbol c){
        NodoArbol temporal;
        c.hijoIzquierdo=rotacionDerecha(c.hijoIzquierdo);
        temporal=rotacionIzquierda(c);
        return temporal;

    }

    public NodoArbol rotacionDobleDerecha(NodoArbol c){
        NodoArbol temporal;
        c.hijoDerecho=rotacionDobleIzquierda(c.hijoDerecho);
        temporal=rotacionDerecha(c);
        return temporal;

    }
    public NodoArbol insertarAVL(NodoArbol nuevo, NodoArbol subAr){
        NodoArbol nuevopadre=subAr;
        if (nuevo.dato<subAr.dato){
            if(subAr.hijoIzquierdo==null){
                subAr.hijoIzquierdo=nuevo;
            }else{
                subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
                if((obtenerFE(subAr.hijoIzquierdo)- obtenerFE(subAr.hijoDerecho)==2)){
                    if(nuevo.dato<subAr.hijoIzquierdo.dato){
                        nuevopadre=rotacionIzquierda(subAr);
                    }else {
                        nuevopadre=rotacionDobleIzquierda(subAr);
                    }
                }

            }
        } else if(nuevo.dato>subAr.dato){
            if (subAr.hijoDerecho==null){
                subAr.hijoDerecho=nuevo;
            }else {
                subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
                if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2)){
                    if(nuevo.dato>subAr.hijoDerecho.dato){
                        nuevopadre=rotacionDerecha(subAr);
                    }else {
                        nuevopadre=rotacionDobleDerecha(subAr);
                    }
                }
            }
        } else {
            System.out.println("Nodo dublicado");
        }
        if ((subAr.hijoIzquierdo==null)&&(subAr.hijoDerecho!=null)){
            subAr.fe=subAr.hijoDerecho.fe+1;
        }else if((subAr.hijoDerecho ==null)&& (subAr.hijoIzquierdo!=null)){
            subAr.fe=subAr.hijoIzquierdo.fe+1;
        }else {
            subAr.fe=Math.max(obtenerFE(subAr.hijoIzquierdo),obtenerFE(subAr.hijoDerecho))+1;
        }
        return nuevopadre;
    }

    public void insertar(int d){
        NodoArbol nuevo= new NodoArbol(d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo,raiz);
        }
    }
//contar lo numeros de nodos de un arbol con recursividad
    public String contar(){
int cant =contar(this.raiz);
return "el arbol tiene "+ cant+" nodos ";
    }

    private int contar(NodoArbol n){
        if (n== null) return 0;
        int c1 =contar(n.hijoIzquierdo);
        int c2=contar(n.hijoDerecho);
        int c3=c1+c2+1;

        return c3;
    }

    //calcular la altura de un arbol con recursividad

    public String calcularAltura(){
        int alt=calcularAltura(this.raiz);
        return "la altura es : " + alt;
    }
    private int calcularAltura(NodoArbol n){
        if(n==null) return 0;
        int h1 = calcularAltura(n.hijoIzquierdo);
        int h2 = calcularAltura(n.hijoDerecho);
        if(h1>h2)return h1+1;
        return h2 +1;
    }

   public void inOrden(NodoArbol r) {
       if (r != null) {

           inOrden(r.hijoIzquierdo);
           System.out.print(r.dato + ", ");
           inOrden(r.hijoDerecho);

       }


   }


}
