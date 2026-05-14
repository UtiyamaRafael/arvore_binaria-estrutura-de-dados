public class ArvoreBinaria {

    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        if (estaVazia()) {
            this.raiz = novoNo;
        } else {
            No aux = this.raiz;
            while (true) {
                if (conteudo < aux.getConteudo()) {
                    if (aux.getNoL() != null) {
                        aux = aux.getNoL();
                    } else {
                        aux.setNoL(novoNo);
                        return;
                    }
                } else if (conteudo > aux.getConteudo()) {
                    if (aux.getNoR() != null) {
                        aux = aux.getNoR();
                    } else {
                        aux.setNoR(novoNo);
                        return;
                    }
                } else {
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
        
        if (no == null) {
            return;
        }

        posOrdem(no.getNoL());
        posOrdem(no.getNoR());

        System.out.println(no.getConteudo());
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
    }

    public void remover(Integer conteudo) {
        if (estaVazia()) {
            return;
        } else {
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
                case "noNaoEncontrado":
                    System.out.println("Nó nao encontrado");
                    break;
            }
        }
    }

    public String remocaoTipo(Integer conteudo) {

        while (true) {
            No aux = this.raiz;
            
            if (conteudo < aux.getConteudo()) {
                if (aux.getConteudo().equals(conteudo)) {
                    if (aux.getNoL() != null && aux.getNoR() != null) {
                        return "doisFilhos";
                    } else if (aux.getNoL() != null && aux.getNoR() == null) {
                        return "umFilhoL";
                    } else if (aux.getNoR() != null && aux.getNoL() == null) {
                        return "umFilhoR";
                    } else {
                        return "folha";
                    }
                } else {
                    aux = aux.getNoL();
                }
            } else if (conteudo > aux.getConteudo()) {
                if (aux.getConteudo().equals(conteudo)) {
                    if (aux.getNoL() != null && aux.getNoR() != null) {
                        return "doisFilhos";
                    } else if (aux.getNoL() != null && aux.getNoR() == null) {
                        return "umFilhoL";
                    } else if (aux.getNoR() != null && aux.getNoL() == null) {
                        return "umFilhoR";
                    } else {
                        return "folha";
                    }
                } else {
                    aux = aux.getNoR();
                }
            } else {
                return "nóNaoEncontrado";
            }
        }
    }

    public void removerFolha(Integer conteudo) {
        No aux = this.raiz;

        while (true) {
            if (conteudo < aux.getConteudo()) {
                if (aux.getNoL().equals(conteudo)) {
                    aux.setNoL(null);
                    return;
                } else {
                    aux = aux.getNoL();
                }
            } else if (conteudo > aux.getConteudo()) {
                if (aux.getNoR().equals(conteudo)) {
                    aux.setNoR(null);
                    return;
                } else {
                    aux = aux.getNoR();
                }
            }
        }
    }

    public void remover1filhoL(Integer conteudo) {

    }

    public void remover1filhoR(Integer conteudo) {

    }

    public void remover2filho(Integer conteudo) {

    }
}
