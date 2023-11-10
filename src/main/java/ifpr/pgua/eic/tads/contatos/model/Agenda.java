package ifpr.pgua.eic.tads.contatos.model;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> lista;


    public Agenda(){
        lista = new ArrayList<>();
    }

    public ArrayList<Contato> getLista(){
        return lista;
    }

    public String cadastrar(String nome, String telefone, String email) {
        
        if(nome.isBlank() || nome.isEmpty()){
            return "Nome inválido!";
        }

        if(telefone.isBlank() || telefone.isEmpty()){
            return "Telefone inválido!";
        }

        if(email.isBlank() || email.isEmpty()){
            return "E-mail inválido!";
        }
        
        if(buscar(nome)==null){

            Contato contato = new Contato(nome, telefone, email);

            lista.add(contato);

            return "Cadastrado!";
        }else{
            return "Erro! Dados já cadastrados!";
        }

    }

    public Contato buscar(String nome) {
        
        for(Contato c:lista){
            if(c.getNome().equals(nome)){
                return c;
            }
        }
        return null;
    }

    public Contato buscarNomeMaisComprido() {
        
        Contato maiorNome = lista.get(0);

        for(int i=1;i<lista.size();i++){
            if(lista.get(i).getNome().length() > maiorNome.getNome().length()){
                maiorNome = lista.get(i);
            }
        }
        return maiorNome;
    }

    public String listar(){
        String texto="Contatos Cadastrados:";

        for(Contato c:lista){
            texto+=c.toString()+"<br/>";
        }

        return texto;
    }
}
