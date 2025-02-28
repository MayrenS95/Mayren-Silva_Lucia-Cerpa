package dao.impl;

import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DaoEnMemoria implements IDao<Odontologo> {
    public static final Logger logger = Logger.getLogger(DaoEnMemoria.class);
    private List<Odontologo> odontologos = new ArrayList<>();


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(odontologos.size()+1);
        odontologos.add(odontologo);
        logger.info("Odontologo guardado en memoria " +odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("listado de Odontologos guardado en memoria: ");
        for (int i = 0; i < odontologos.size(); i++) {
            Odontologo odontologo = odontologos.get(i);
            System.out.println(odontologo);
        }
        return odontologos;
    }
}
