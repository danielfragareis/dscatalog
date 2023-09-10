package com.devsuperior.dscatalog.services;
//import org.springframework.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;


@Service	
//Podem ser usadas outras anotations a depender do objetivo, como: @Component e @Repository
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	/*
	 * Usada para realizar a injeção de dependência automática. Ela é usada para
	 * indicar que uma determinada variável precisa ser automaticamente conectada a
	 * um bean (objeto gerenciado pelo Spring) adequado durante a inicialização da
	 * aplicação.
	 */
	@org.springframework.transaction.annotation.Transactional(readOnly=true)
	
	public List<Category> findAll(){
		return repository.findAll();
	}
}
