package cl.praxis.practicapruebatd.services;

import java.util.List;

public interface ICrudService<T> {
    List<T> listar();
    T obtenerPorId(int id);
    T crear(T t);
    T actualizar(T t);
    void eliminar(int id);
}
