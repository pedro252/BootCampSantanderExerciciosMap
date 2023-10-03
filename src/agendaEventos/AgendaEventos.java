package agendaEventos;

import jdk.jfr.Event;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {

    Map<LocalDate, Eventos> eventosMap;

    public AgendaEventos(){
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Eventos eventos = new Eventos(nome, atracao);
        eventosMap.put(data, eventos);
    }

    public void exibirAgenda(){
        Map<LocalDate, Eventos> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento (){
        LocalDate dataAtual = LocalDate.now();
         LocalDate proximaData = null;
         Eventos proximaEvento = null;


        Map<LocalDate, Eventos> eventosTreeMaps = new TreeMap<>(eventosMap);
        for (Map.Entry<LocalDate, Eventos> entry : eventosMap.entrySet()){
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){

                proximaEvento = entry.getValue();
                proximaData = entry.getKey();

                System.out.println("Proxmo evento: " + proximaEvento +
                        "acontecera na data " +  proximaData);

                break;
            }
        }
    }

    public static void main(String[] args) {

    }
}
