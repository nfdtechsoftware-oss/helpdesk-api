package com.nfdtech.helpdesk_api.domain.enums;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Status {

    ABERTO (0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    private final int codigo;
    private final String descricao;

    private static final Map<Integer, Status> LOOKUP =
            Stream.of(values()).collect(Collectors.toUnmodifiableMap(Status::getCodigo, s -> s));

    Status(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod) {
        return cod == null ? null :
                Optional.ofNullable(LOOKUP.get(cod))
                        .orElseThrow(() -> new IllegalArgumentException("Status inválido: " + cod));
    }
    
}
