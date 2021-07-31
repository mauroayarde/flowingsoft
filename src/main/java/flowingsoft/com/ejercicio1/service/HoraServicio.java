package flowingsoft.com.ejercicio1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flowingsoft.com.ejercicio1.models.HoraModelo;
import flowingsoft.com.ejercicio1.repository.HoraRepositorio;

@Service
public class HoraServicio {

    @Autowired
    HoraRepositorio horaRepositorio;

    public HoraModelo guardarHora(HoraModelo nuevoRegistro) {
        return horaRepositorio.save(nuevoRegistro);
    }

    public List<HoraModelo> lista() {
        return (List<HoraModelo>) horaRepositorio.findAll();
    }
}
