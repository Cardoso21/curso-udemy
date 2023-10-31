package br.com.udemy.cursoudemy.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destino){
        return mapper.map(origin,destino);
    }
    public static <O, D> List<D> parseListObject(List <O> origin, Class<D> destino){
        List<D> destinoObjetc = new ArrayList<>();
        for (O o:origin) {
            destinoObjetc.add(mapper.map(origin,destino));
        }
        return destinoObjetc;
    }
}
