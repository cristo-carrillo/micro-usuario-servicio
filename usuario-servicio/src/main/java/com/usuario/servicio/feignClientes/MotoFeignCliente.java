package com.usuario.servicio.feignClientes;

import com.usuario.servicio.modelos.Carro;
import com.usuario.servicio.modelos.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "moto-servicio",url = "http://localhost:8003")
@RequestMapping("/moto")
public interface MotoFeignCliente {

    @PostMapping()
    public Moto save(@RequestBody Moto moto);

    @GetMapping("/usuario/{usuarioId}")
    public List<Moto> getMotos(@PathVariable("usuarioId") int usuarioId);
}
