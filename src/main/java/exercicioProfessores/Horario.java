package exercicioProfessores;

public class Horario {

    private String nomeDoProfessor;
    private String horarioDeAtendimento;
    private int sala;
    private int periodo;
    private int predio[] = new int[5];

    public Horario(String nomeDoProfessor, String horarioDeAtendimento, int sala, int periodo, int predio){
        this.nomeDoProfessor = nomeDoProfessor;
        this.horarioDeAtendimento = horarioDeAtendimento;
        this.sala = sala;
        this.periodo = periodo;
        if(this.sala <= 5){this.predio[0] = 1;}
        else if (this.sala > 5 && this.sala <= 10) {this.predio[0] = 2;}
        else if (this.sala > 10 && this.sala <= 15) {this.predio[0] = 3;}
        else if (this.sala > 15 && this.sala <= 20) {this.predio[0] = 4;}
        else if (this.sala > 20 && this.sala <= 25) {this.predio[0] = 6;}

    }

    public String getNomeDoProfessor() {
        return nomeDoProfessor;
    }

    public void setNomeDoProfessor(String nomeDoProfessor) {
        this.nomeDoProfessor = nomeDoProfessor;
    }

    public String getHorarioDeAtendimento() {
        return horarioDeAtendimento;
    }

    public void setHorarioDeAtendimento(String horarioDeAtendimento) {this.horarioDeAtendimento = horarioDeAtendimento;}

    public int getSala() {return sala;}

    public void setSala(int sala) {this.sala = sala;}

    public int getPeriodo() {return periodo;}

    public void setPeriodo(int periodo) {this.periodo = periodo;}

    public int getPredio() {
        return predio[0];
    }

    public void setPredio(int predio) {this.periodo = predio;}
}
