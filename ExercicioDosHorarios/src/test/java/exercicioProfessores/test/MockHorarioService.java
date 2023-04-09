package exercicioProfessores.test;

import exercicioProfessores.HorarioService;

import java.util.ArrayList;

public class MockHorarioService implements HorarioService {


    @Override
    public String busca(int id) {

        if (id == 10){
            return HorarioConst.CHRIS;
        }else if (id == 20){
            return HorarioConst.MARCELO;
        }else if(id == 30){
            return HorarioConst.YVO;
        }else{
            return HorarioConst.INEXISTENTE;
        }
    }

    @Override
    public boolean horarioExistente(int id) {
        //Aceitando somente IDs 10, 20 e 30
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);

        for (int i=0; i < list.size(); i++){
            if (list.get(i).equals(id) || list.get(i).equals(id)){
                return true;
            }else{
                return false;
            }
        }

        return false;
    }
}
