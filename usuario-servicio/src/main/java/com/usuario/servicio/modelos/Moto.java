package com.usuario.servicio.modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Moto {

    private @Getter @Setter String marca;
    private @Getter @Setter String modelo;
    private @Getter @Setter int usuarioId;
}
