package flowingsoft.com.ejercicio1.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flowingsoft.com.ejercicio1.models.HoraModelo;
import flowingsoft.com.ejercicio1.request.Request;
import flowingsoft.com.ejercicio1.service.HoraServicio;

@RestController
@RequestMapping("/hora")
public class HoraControlador {

    @Autowired
    HoraServicio horaServicio;

    @RequestMapping()
    public List<HoraModelo> obtenerHora() {
        return horaServicio.lista();
    }

    @PostMapping()
    public HoraModelo nuevo(@RequestBody Request request) {

        String[] dato1 = request.getDato1().split(":");
        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR, new Integer(dato1[0]).intValue());
        now.set(Calendar.MINUTE, new Integer(dato1[1]).intValue());
        now.set(Calendar.SECOND, new Integer(dato1[2]).intValue());

        TimeZone.setDefault(TimeZone.getTimeZone("utc" + request.getDato2()));

        Date date = now.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String fechaHora = sdf.format(date);
        HoraModelo horaModelo = new HoraModelo();
        horaModelo.setTime(fechaHora);
        horaModelo.setTimezone("utc");
        horaServicio.guardarHora(horaModelo);
        return horaModelo;
    }

}
