package exercicioProfessores.test;

import exercicioProfessores.BuscaHorario;
import exercicioProfessores.Horario;
import exercicioProfessores.HorarioService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteBuscaHorario {

    HorarioService service;
    BuscaHorario buscaHorario;

    @Before
    public void setup(){
        //Criando o contexo do meu teste com o Mock (serviço mock)
        service = new MockHorarioService();
        buscaHorario = new BuscaHorario(service);
    }


}
