
public class nodo {
    
    public String codigo;
    public int valor;
    public nodo esq, dir,pai;
    public int n;
    boolean cor;

    
    
    public nodo(String codigo,int valor,boolean cor){
        this.codigo                  =   codigo;
        this.valor                  =   valor; 
        this.cor                    =   cor; 
    }
    
    
}
