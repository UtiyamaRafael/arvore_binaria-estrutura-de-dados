public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(1);
        arvoreBinaria.inserir(7);

        arvoreBinaria.percurso();
        
        System.out.println("----------------------------");

        arvoreBinaria.remover(7);
        
        arvoreBinaria.percurso();

    }
}