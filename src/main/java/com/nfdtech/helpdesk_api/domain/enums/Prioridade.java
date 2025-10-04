package com.nfdtech.helpdesk_api.domain.enums;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prioridade {

    BAIXA (0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private final int codigo;
    private final String descricao;

    private static final Map<Integer, Prioridade> LOOKUP =
            Stream.of(values()).collect(Collectors.toUnmodifiableMap(Prioridade::getCodigo, p -> p));

    Prioridade(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer cod) {
        return cod == null ? null :
                Optional.ofNullable(LOOKUP.get(cod))
                        .orElseThrow(() -> new IllegalArgumentException("Prioridade inválido: " + cod));
    }
    
}
