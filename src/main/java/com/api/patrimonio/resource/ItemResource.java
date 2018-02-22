package com.api.patrimonio.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.patrimonio.model.Item;
import com.api.patrimonio.repository.ItemRepository;

@RestController
@RequestMapping("/itens")
@CrossOrigin("${origem-permitida}")
public class ItemResource {

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping(produces = "application/json")
	private List<Item> listar() {
		return itemRepository.findAll();
	}

	@PostMapping()
	private Item adicionar(@RequestBody @Valid Item item) {
		return itemRepository.save(item);
	}

}
