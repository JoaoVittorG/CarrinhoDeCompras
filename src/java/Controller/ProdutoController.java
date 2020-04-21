package Controller;

import Domain.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;
import service.ProdutoService;


@ManagedBean(name="produtoMB")
@SessionScoped
public class ProdutoController {
    private Integer id = 1;
    private Produto produto = new Produto();
    private List<Produto> produtos;
    private ProdutoService produtoService = new ProdutoService();
    
    public ProdutoController(){
        produto.setId(id);
        listar();
    }
    
    public void listar(){
        produtos = produtoService.listar();
    }
    
    public Integer retornaID(){
        return id;
    }
    
    public String novo(){
        produto = new Produto();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscarDados(Produto produto){
        this.produto = produto;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        produtoService.alterar(produto);
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }
    public String excluir(Produto produto){
        produtoService.excluir(produto);
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }
    public String salvar(){
       produto.setId(id);
       id++;
       produtoService.inserir(produto);
       this.listar();      
       return "list.xhtml?faces-redirect=true";
    }                
    
    
    public Produto getProduto(){
        return produto;
    }
        

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }      
}
