package com.usuario.servicio.feignClientes;

import com.usuario.servicio.modelos.Carro;
import com.usuario.servicio.modelos.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "carro-servicio",url = "http://localhost:8002")
@RequestMapping("/carro")
public interface CarroFeignCliente {

    @PostMapping()
    public Carro save(@RequestBody Carro carro);

    @GetMapping("/usuario/{usuarioId}")
    public List<Carro> getCarros(@PathVariable("usuarioId") int usuarioId);

}
