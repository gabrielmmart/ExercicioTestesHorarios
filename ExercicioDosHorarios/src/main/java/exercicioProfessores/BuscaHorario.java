package exercicioProfessores;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaHorario {

    HorarioService horarioService;

    public BuscaHorario(HorarioService service){
        this.horarioService = service;
    }

    public Horario buscaHorario(int id){
        // id = 10 -> buscando um inimigo de ID 10
        //InimigoJson é uma string que retornou do serviço
        String inimigoJson = horarioService.busca(id);

        //jsonObject é um objeto JSON feito a partir da string de retonro
        JsonObject jsonObject = JsonParser.parseString(inimigoJson).getAsJsonObject();

        return new Horario(jsonObject.get("nomeDoProfessor").getAsString(),
                jsonObject.get("horarioDeAtendimento").getAsString(),
                jsonObject.get("sala").getAsInt(),
                jsonObject.get("periodo").getAsInt(),
                jsonObject.get("predio").getAsInt());
    }

    public boolean verificaArrayListExistente(int id){
        boolean horarioExistente = horarioService.horarioExistente(id);

        if (horarioExistente){
            return true;
        }else{
            return false;
        }
    }

}
