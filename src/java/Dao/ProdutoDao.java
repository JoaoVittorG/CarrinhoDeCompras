package Dao;

import Domain.Produto;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDao {
    
    private ArrayList<Produto> produtos = new ArrayList<>();
    
    public List<Produto> listar(){
        return produtos;
    }
    
    public Produto consultar(Integer id){
        for (Produto p: produtos){
            if(id == p.getId()){
                return p;
            }
        }
        return null;
    }
    
    
    public boolean inserir(Produto produto){
        produtos.add(produto);
        
        return true;
    }
    
    public boolean alterar(Produto produto){
        for (Produto p: produtos){
            if(p == produto){
                p = produto;
                return true;
            }
        }
        return false;
    }
    
    public boolean excluir(Produto produto){
        for (Produto p: produtos){
            if(p == produto){
                produtos.remove(p);
                return true;
            }
        }
        return false;
    }
}
