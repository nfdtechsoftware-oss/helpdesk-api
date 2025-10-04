package com.nfdtech.helpdesk_api.domain.enums;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Perfil {

    ADMIN(0, "ROLE_ADMIN"),
    CLIENTE(1, "ROLE_CLIENTE"),
    TECNICO(2, "ROLE_TECNICO");

    private final int codigo;
    private final String descricao;

    private static final Map<Integer, Perfil> LOOKUP =
            Stream.of(values()).collect(Collectors.toUnmodifiableMap(Perfil::getCodigo, p -> p));

    Perfil(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer cod) {
        return cod == null ? null :
                Optional.ofNullable(LOOKUP.get(cod))
                        .orElseThrow(() -> new IllegalArgumentException("Perfil inválido: " + cod));
    }

}
