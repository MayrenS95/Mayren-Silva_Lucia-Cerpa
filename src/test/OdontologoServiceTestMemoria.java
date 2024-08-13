package test;

import dao.impl.DaoEnMemoria;
import model.Odontologo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTestMemoria {

    private static OdontologoService odontologoService = new OdontologoService(new DaoEnMemoria());

    @Test
    @DisplayName("Testear que se agregue un odontologo de manera correcta: ")
    void caso1(){
        //DADO
        Odontologo odontologo = new Odontologo(1234,"Mayren","Silva");

        //CUANDO
        Odontologo odontologoDesdeBD = odontologoService.guardarOdontologo(odontologo);
        // entonces
        assertNotNull(odontologoDesdeBD);
    }


    @Test
    @DisplayName("Testear que se listen todos los odontologos: ")
    void caso2(){
        //DADO
        List<Odontologo> odontologos;
        Odontologo odontologo = new Odontologo(12357,"Mayren","Silva");
        odontologoService.guardarOdontologo(odontologo);
        Odontologo odontologo2 = new Odontologo(1234,"Maria","Basto");
        odontologoService.guardarOdontologo(odontologo2);
        //CUANDO
        odontologos = odontologoService.buscarTodos();
        // entonces
        assertNotNull(odontologos);
    }

}