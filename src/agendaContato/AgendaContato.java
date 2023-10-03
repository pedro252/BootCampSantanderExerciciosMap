package agendaContato;

import java.util.HashMap;
import java.util.Map;

public class AgendaContato {

    private Map<String, Integer> agendaContatoMap;

    public AgendaContato() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if(!agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContato(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome (String nome){
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()){
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContato agendaContato = new AgendaContato();

        agendaContato.adicionarContato("Camilla", 123324);
        agendaContato.adicionarContato("Pedro", 342123);
        agendaContato.adicionarContato("Lucas", 123412);
        agendaContato.adicionarContato("Maria Clara", 5764576);

        agendaContato.exibirContato();

        agendaContato.removerContato("Pedro");
        agendaContato.exibirContato();

        System.out.println(agendaContato.pesquisarPorNome("Lucas"));
    }
}
