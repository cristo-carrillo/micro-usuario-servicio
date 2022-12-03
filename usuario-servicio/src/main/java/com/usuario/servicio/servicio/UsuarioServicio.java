package com.usuario.servicio.servicio;

import com.usuario.servicio.entidades.Usuario;
import com.usuario.servicio.feignClientes.CarroFeignCliente;
import com.usuario.servicio.feignClientes.MotoFeignCliente;
import com.usuario.servicio.modelos.Carro;
import com.usuario.servicio.modelos.Moto;
import com.usuario.servicio.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UsuarioServicio {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CarroFeignCliente carroFeignCliente;

    @Autowired
    private MotoFeignCliente motoFeignCliente;

    public List<Carro> getCarros(int usuarioId){
        return restTemplate.getForObject("http://localhost:8002/carro/usuario/" + usuarioId, List.class);
    }

    public List<Moto> getMotos(int usuarioId){
        return restTemplate.getForObject("http://localhost:8003/moto/usuario/" + usuarioId, List.class);
    }

    public Carro saveCarro(int usuarioId,Carro carro){
        carro.setUsuarioId(usuarioId);
        return carroFeignCliente.save(carro);
    }

    public Moto saveMoto(int usuarioId,Moto moto){
        moto.setUsuarioId(usuarioId);
       return motoFeignCliente.save(moto);
    }

    public Map<String, Object> getUsuarioAndVehiculos(int usuarioId){
        Map<String,Object> resultado = new HashMap<>();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (usuario == null){
            resultado.put("mensaje","El usuario no existe");
            return resultado;
        }

        resultado.put("Usuario",usuario);
        List<Carro> carros = carroFeignCliente.getCarros(usuarioId);
        if(carros == null){
            resultado.put("Carros","El usuario no tiene carros");
        }else {
            resultado.put("Carros", carros);
        }

        List<Moto> motos = motoFeignCliente.getMotos(usuarioId);
        if (motos == null){
            resultado.put("Motos","El usuario no tiene motos");
        }else {
            resultado.put("Motos", motos);
        }
        return resultado;
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public   Usuario getUsuarioById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
