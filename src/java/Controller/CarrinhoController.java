package Controller;

import Domain.Produto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="carrinhoMB")
@SessionScoped
public class CarrinhoController {
    private List<Produto> produtos;
    private Produto produto = new Produto();
    private float total = 0;
    
    public CarrinhoController(){
        adicionaP(produto);
    }
    
    public void adicionaP(Produto p){
        produtos.add(p);
    }
    
    public float retornaValor(){
       for(Produto p: produtos){
           total += p.getValor();
       
       } 
       return total;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
}
