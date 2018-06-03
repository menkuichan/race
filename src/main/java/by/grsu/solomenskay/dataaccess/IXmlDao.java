package by.grsu.solomenskay.dataaccess;

import java.io.Serializable;
import java.util.List;

public interface IXmlDao<E> extends Serializable {

	E saveNew(E entity);

	E update(E entity);

	E get(Long id);

	List<E> getAll();

	void delete(Long id);

	void deleteAll();
}
