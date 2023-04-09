package exercicioProfessores.test.mockito;

import exercicioProfessores.BuscaHorario;
import exercicioProfessores.Horario;
import exercicioProfessores.HorarioService;
import exercicioProfessores.test.HorarioConst;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TesteBuscaHorario {

    @Mock
    private HorarioService service;
    private BuscaHorario buscaHorario;

    @Before
    public void setup() {
        buscaHorario = new BuscaHorario(service);
    }

    @Test
    public void testeBuscaHorarioChris() {
        Mockito.when(service.busca(10)).thenReturn(HorarioConst.CHRIS);

        Horario chris = buscaHorario.buscaHorario(10);
        //Faz assertion
        assertEquals("Chris", chris.getNomeDoProfessor());
        assertEquals("14:30", chris.getHorarioDeAtendimento());
        assertEquals(4, chris.getSala());
        assertEquals(8, chris.getPeriodo());
        assertEquals(1, chris.getPredio());
    }

    @Test
    public void testeBuscaHorarioMarcelo() {
        Mockito.when(service.busca(20)).thenReturn(HorarioConst.MARCELO);

        Horario marcelo = buscaHorario.buscaHorario(20);
        //Faz assertion
        assertEquals("Marcelo", marcelo.getNomeDoProfessor());
        assertEquals("17:00", marcelo.getHorarioDeAtendimento());
        assertEquals(6, marcelo.getSala());
        assertEquals(2, marcelo.getPeriodo());
        assertEquals(2, marcelo.getPredio());
    }

    @Test
    public void testeBuscaHorarioYvo() {
        Mockito.when(service.busca(30)).thenReturn(HorarioConst.YVO);

        Horario yvo = buscaHorario.buscaHorario(30);
        //Faz assertion
        assertEquals("Yvo", yvo.getNomeDoProfessor());
        assertEquals("18:30", yvo.getHorarioDeAtendimento());
        assertEquals(12, yvo.getSala());
        assertEquals(5, yvo.getPeriodo());
        assertEquals(3, yvo.getPredio());
    }

    @Test
    public void testeBuscaHorarioInexistente() {
        Mockito.when(service.busca(5)).thenReturn(HorarioConst.INEXISTENTE);

        Horario inexistente = buscaHorario.buscaHorario(5);
        //Faz assertion
        assertEquals("Inexistente", inexistente.getNomeDoProfessor());
        assertEquals("Inexistente", inexistente.getHorarioDeAtendimento());
        assertEquals(0, inexistente.getSala());
        assertEquals(0, inexistente.getPeriodo());
        assertEquals(1, inexistente.getPredio());
    }

    @Test
    public void buscarNegativoRetornaInexistente() {
        Mockito.when(service.busca(-5)).thenReturn(HorarioConst.INEXISTENTE);

        Horario inexistente = buscaHorario.buscaHorario(-5);
        //Faz assertion
        assertEquals("Inexistente", inexistente.getNomeDoProfessor());
        assertEquals("Inexistente", inexistente.getHorarioDeAtendimento());
        assertEquals(0, inexistente.getSala());
        assertEquals(0, inexistente.getPeriodo());
        assertEquals(1, inexistente.getPredio());
    }

    @Test
    public void testeVerificaHorarioExistenteId10(){
        Mockito.when(service.horarioExistente(10)).thenReturn(true);

        boolean horarioValido = service.horarioExistente(10);

        assertTrue(horarioValido);
    }

    @Test
    public void testeVerificaHorarioExistenteId20() {
        Mockito.when(service.horarioExistente(20)).thenReturn(true);

        boolean horarioValido = service.horarioExistente(20);

        assertTrue(horarioValido);
    }

    @Test
    public void testeVerificaHorarioExistenteId30() {
        Mockito.when(service.horarioExistente(30)).thenReturn(true);

        boolean horarioValido = service.horarioExistente(30);

        assertTrue(horarioValido);
    }

    @Test
    public void testeVerificaHorarioInexistente() {
        Mockito.when(service.horarioExistente(5)).thenReturn(false);

        boolean horarioValido = service.horarioExistente(5);

        assertFalse(horarioValido);
    }

    @Test
    public void verificarHorarioComIDnegativo() {
        Mockito.when(service.horarioExistente(-5)).thenReturn(false);

        boolean horarioValido = service.horarioExistente(-5);

        assertFalse(horarioValido);
    }

    @Test
    public void testeBuscaHorarioPredioErradoChris() {
        Mockito.when(service.busca(10)).thenReturn(HorarioConst.CHRIS);

        Horario chris = buscaHorario.buscaHorario(10);
        //Faz assertion
        assertEquals("Chris", chris.getNomeDoProfessor());
        assertEquals("14:30", chris.getHorarioDeAtendimento());
        assertEquals(4, chris.getSala());
        assertEquals(8, chris.getPeriodo());
        assertNotEquals(5, chris.getPredio());
    }

    @Test
    public void testeBuscaHorarioAtendimentoErradoMarcelo() {
        Mockito.when(service.busca(20)).thenReturn(HorarioConst.MARCELO);

        Horario marcelo = buscaHorario.buscaHorario(20);
        //Faz assertion
        assertEquals("Marcelo", marcelo.getNomeDoProfessor());
        assertNotEquals("00:00", marcelo.getHorarioDeAtendimento());
        assertEquals(6, marcelo.getSala());
        assertEquals(2, marcelo.getPeriodo());
        assertEquals(2, marcelo.getPredio());
    }

    @Test
    public void testeBuscaHorarioSalaErradaYvo() {
        Mockito.when(service.busca(30)).thenReturn(HorarioConst.YVO);

        Horario yvo = buscaHorario.buscaHorario(30);
        //Faz assertion
        assertEquals("Yvo", yvo.getNomeDoProfessor());
        assertEquals("18:30", yvo.getHorarioDeAtendimento());
        assertNotEquals(20, yvo.getSala());
        assertEquals(5, yvo.getPeriodo());
        assertEquals(3, yvo.getPredio());
    }

    @Test
    public void testeBuscaHorarioNomeErradoChris() {
        Mockito.when(service.busca(10)).thenReturn(HorarioConst.CHRIS);

        Horario chris = buscaHorario.buscaHorario(10);
        //Faz assertion
        assertNotEquals("Phyll", chris.getNomeDoProfessor());
        assertEquals("14:30", chris.getHorarioDeAtendimento());
        assertEquals(4, chris.getSala());
        assertEquals(8, chris.getPeriodo());
        assertEquals(1, chris.getPredio());
    }

    @Test
    public void testeBuscaHorarioPeriodoErradoMarcelo() {
        Mockito.when(service.busca(20)).thenReturn(HorarioConst.MARCELO);

        Horario marcelo = buscaHorario.buscaHorario(20);
        //Faz assertion
        assertEquals("Marcelo", marcelo.getNomeDoProfessor());
        assertEquals("17:00", marcelo.getHorarioDeAtendimento());
        assertEquals(6, marcelo.getSala());
        assertNotEquals(1, marcelo.getPeriodo());
        assertEquals(2, marcelo.getPredio());
    }

    @Test
    public void testeBuscaHorarioAtendimentoErradoYvo() {
        Mockito.when(service.busca(30)).thenReturn(HorarioConst.YVO);

        Horario yvo = buscaHorario.buscaHorario(30);
        //Faz assertion
        assertEquals("Yvo", yvo.getNomeDoProfessor());
        assertNotEquals("23:30", yvo.getHorarioDeAtendimento());
        assertEquals(12, yvo.getSala());
        assertEquals(5, yvo.getPeriodo());
        assertEquals(3, yvo.getPredio());
    }

    @Test
    public void testeBuscaHorarioSalaErradaChris() {
        Mockito.when(service.busca(10)).thenReturn(HorarioConst.CHRIS);

        Horario chris = buscaHorario.buscaHorario(10);
        //Faz assertion
        assertEquals("Chris", chris.getNomeDoProfessor());
        assertEquals("14:30", chris.getHorarioDeAtendimento());
        assertNotEquals(2, chris.getSala());
        assertEquals(8, chris.getPeriodo());
        assertEquals(1, chris.getPredio());
    }

    @Test
    public void testeBuscaHorarioNomeErradoMarcelo() {
        Mockito.when(service.busca(20)).thenReturn(HorarioConst.MARCELO);

        Horario marcelo = buscaHorario.buscaHorario(20);
        //Faz assertion
        assertNotEquals("Marcelinho", marcelo.getNomeDoProfessor());
        assertEquals("17:00", marcelo.getHorarioDeAtendimento());
        assertEquals(6, marcelo.getSala());
        assertEquals(2, marcelo.getPeriodo());
        assertEquals(2, marcelo.getPredio());

    }

    @Test
    public void testeBuscaHorarioNomeErradoYvo() {
        Mockito.when(service.busca(30)).thenReturn(HorarioConst.YVO);

        Horario yvo = buscaHorario.buscaHorario(30);
        //Faz assertion
        assertNotEquals("Yvo Holanda", yvo.getNomeDoProfessor());
        assertEquals("18:30", yvo.getHorarioDeAtendimento());
        assertEquals(12, yvo.getSala());
        assertEquals(5, yvo.getPeriodo());
        assertEquals(3, yvo.getPredio());
    }

    @Test
    public void testeBuscaHorarioPredioErradoYvo() {
        Mockito.when(service.busca(30)).thenReturn(HorarioConst.YVO);

        Horario yvo = buscaHorario.buscaHorario(30);
        //Faz assertion
        assertEquals("Yvo", yvo.getNomeDoProfessor());
        assertEquals("18:30", yvo.getHorarioDeAtendimento());
        assertEquals(12, yvo.getSala());
        assertEquals(5, yvo.getPeriodo());
        assertNotEquals(4, yvo.getPredio());
    }

}