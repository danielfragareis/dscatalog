package com.devsuperior.dscatalog.services;
//import org.springframework.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;


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
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category>  list = repository.findAll();
		return list.stream().map(x-> new CategoryDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
		
		return new CategoryDTO(entity);
	}
}
