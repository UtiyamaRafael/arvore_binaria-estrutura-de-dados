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

    // remover raiz
    public void remover(Integer conteudo) {
        if (estaVazia()) {
            return;
        } else {
            String tipoRemocao = remocaoTipo(conteudo);
            System.out.println("O tipo de remoção será: " + tipoRemocao);

            switch (tipoRemocao) {
                case "folha":
                    removerFolha(conteudo);
                    System.out.println("Numero: " + conteudo + " removido com sucesso");
                    break;
                case "umFilhoL":
                    remover1filhoL(conteudo);
                    System.out.println("Numero: " + conteudo + " removido com sucesso");
                    break;
                case "umFilhoR":
                    remover1filhoR(conteudo);
                    System.out.println("Numero: " + conteudo + " removido com sucesso");
                    break;
                case "doisFilhos":
                    remover2filho(conteudo);
                    System.out.println("Numero: " + conteudo + " removido com sucesso");
                    break;
                case "noNaoEncontrado":
                    System.out.println("No nao encontrado");
                    break;
            }
        }
    }

    public String remocaoTipo(Integer conteudo) {
        No aux = this.raiz;

        while (aux != null) {
            if (conteudo.equals(aux.getConteudo())) {
                // Encontrou o nó. verificar a estrutura
                if (aux.getNoL() != null && aux.getNoR() != null) {
                    return "doisFilhos";
                } else if (aux.getNoL() != null) {
                    return "umFilhoL";
                } else if (aux.getNoR() != null) {
                    return "umFilhoR";
                } else {
                    return "folha";
                }
            }
            if (conteudo < aux.getConteudo()) {
                aux = aux.getNoL();
            } else {
                aux = aux.getNoR();
            }
        }

        return "noNaoEncontrado";
    }

    public void removerFolha(Integer conteudo) {
        No aux = this.raiz;
        while (aux != null) {
            if (conteudo < aux.getConteudo()) {
                if (aux.getNoL() != null && aux.getNoL().getConteudo().equals(conteudo)) {
                    aux.setNoL(null);
                    return;
                }
                aux = aux.getNoL();
            } else if (conteudo > aux.getConteudo()) {
                    if (aux.getNoR() != null && aux.getNoR().getConteudo().equals(conteudo)) {
                        aux.setNoR(null);
                        return;
                    }
                    aux = aux.getNoR();
            }
        }
    }

    public void remover1filhoL(Integer conteudo) {
        No aux = this.raiz;
        while (aux != null) {
            if (conteudo < aux.getConteudo()) {
                if (aux.getNoL() != null && aux.getNoL().getConteudo().equals(conteudo)) {
                    aux.setNoL(aux.getNoL().getNoL());
                    return;
                }
                aux = aux.getNoL();
            } else if (conteudo > aux.getConteudo()) {
                if (aux.getNoR() != null && aux.getNoR().getConteudo().equals(conteudo)) {
                    aux.setNoR(aux.getNoR().getNoL());
                    return;
                }
                aux = aux.getNoR();
            }
        }
    }

    public void remover1filhoR(Integer conteudo) {
        No aux = this.raiz;
        while (aux != null) {
            if (conteudo < aux.getConteudo()) {
                if (aux.getNoL() != null && aux.getNoL().getConteudo().equals(conteudo)) {
                    aux.setNoL(aux.getNoL().getNoR());
                    return;
                }
                aux = aux.getNoL();
            } else if (conteudo > aux.getConteudo()) {
                if (aux.getNoR() != null && aux.getNoR().getConteudo().equals(conteudo)) {
                    aux.setNoR(aux.getNoR().getNoR());
                    return;
                }
                aux = aux.getNoR();
            }
        }
    }

    public void remover2filho(Integer conteudo) {
        No aux = this.raiz;
        if (conteudo.equals(this.raiz.getConteudo())) {
            No suc = sucessor(conteudo);
            Integer valorSuc = suc.getConteudo();
            if (remocaoTipo(valorSuc).equals("folha")) {
                removerFolha(valorSuc);
            } else {
                remover1filhoR(valorSuc);
            }
            this.raiz.setConteudo(valorSuc);
            return;
        }
        while (aux != null) {
            if (conteudo < aux.getConteudo()) {
                if (aux.getNoL() != null &&
                        aux.getNoL().getConteudo().equals(conteudo)) {
                    No removido = aux.getNoL();
                    No suc = sucessor(conteudo);
                    Integer valorSuc = suc.getConteudo();
                    if (remocaoTipo(valorSuc).equals("folha")) {
                        removerFolha(valorSuc);
                    } else {
                        remover1filhoR(valorSuc);
                    }
                    removido.setConteudo(valorSuc);
                    return;
                }
                aux = aux.getNoL();
            }
            else if (conteudo > aux.getConteudo()) {
                if (aux.getNoR() != null &&
                        aux.getNoR().getConteudo().equals(conteudo)) {
                    No removido = aux.getNoR();
                    No suc = sucessor(conteudo);
                    Integer valorSuc = suc.getConteudo();
                    if (remocaoTipo(valorSuc).equals("folha")) {
                        removerFolha(valorSuc);
                    } else {
                        remover1filhoR(valorSuc);
                    }
                    removido.setConteudo(valorSuc);
                    return;
                }
                aux = aux.getNoR();
            }
        }
    }

    private No sucessor(Integer conteudo) {
        No alvo = this.raiz;
        while (alvo != null) {
            if (conteudo < alvo.getConteudo()) {
                alvo = alvo.getNoL();
            } else if (conteudo > alvo.getConteudo()) {
                alvo = alvo.getNoR();
            } else {
                break; // encontrou
            }
        }

        No atual = alvo.getNoR();
        while (atual.getNoL() != null) {
            atual = atual.getNoL();
        }

        return atual;
    }
}
