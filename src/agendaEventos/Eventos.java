package agendaEventos;

public class Eventos {

    private String nome;
    private String atracao;

    @Override
    public String toString() {
        return "Eventos{" +
                "nome='" + nome + '\'' +
                ", atracao='" + atracao + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getAtracao() {
        return atracao;
    }

    public Eventos(String nome, String atracao) {
        this.nome = nome;
        this.atracao = atracao;
    }
}
