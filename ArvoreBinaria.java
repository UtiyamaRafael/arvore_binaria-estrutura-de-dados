public class ArvoreBinaria {

    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        if(estaVazia()) {
            this.raiz = novoNo;
        } else {
            No aux = this.raiz;
            while(true) {
                if(conteudo < aux.getConteudo()) {
                    if(aux.getNoL() != null) {
                        aux = aux.getNoL();
                    } else {
                        aux.setNoL(novoNo);
                        return;
                    }
                } else if (conteudo > aux.getConteudo()) {
                    if(aux.getNoR() != null) {
                        aux = aux.getNoR();
                    } else {
                        aux.setNoR(novoNo);
                        return;
                    }
                }else {
                    System.out.println("Nó repetido - " + conteudo);
                    return;
                }
            }

        }
    }

    private boolean estaVazia() {
        return this.raiz == null;
    }

    public void percurso() {
        this.posOrdem(this.raiz);
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getNoL());
        posOrdem(no.getNoR());
        System.out.println(no.getConteudo());
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
    }

    public void remover(Integer conteudo){

        if (estaVazia()) {
            return;
        }else {
            String tipoRemocao = remocaoTipo(conteudo);
            switch (tipoRemocao) {
                case "folha":
                    removerFolha(conteudo);
                    break;
                case "umFilhoL":
                    remover1filhoL(conteudo);
                    break;
                case "umFilhoR":
                    remover1filhoR(conteudo);
                    break;
                case "doisFilhos":
                    remover2filho(conteudo);
                    break;
            }
        }

    }

    public String remocaoTipo(Integer conteudo){
        return "a";
    }

    public void removerFolha(Integer conteudo){

    }

    public void remover1filhoL(Integer conteudo){

    }

    public void remover1filhoR(Integer conteudo){

    }

    public void remover2filho(Integer conteudo){

    }



}
