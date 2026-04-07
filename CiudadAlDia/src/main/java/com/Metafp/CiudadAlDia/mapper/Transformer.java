package com.Metafp.CiudadAlDia.mapper;

import java.util.List;

public interface Transformer<E,D>{
    D toDto(E entity);
    E toEntity(D dto);
    List<D> toDtoList(List<E> user);
}
