package org.example.examen.controller;

import org.example.examen.models.Item;
import org.example.examen.repository.ItemRepository;
import org.example.examen.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/id/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable String id) {
        Optional<Item> item = itemService.findById(id);
        return item.isPresent() ? ResponseEntity.ok(item.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/categoria/{categoria}")
    public List<Item> buscarPorCategoria(@PathVariable String categoria) {
        return itemRepository.findByCategoryContainingIgnoreCase(categoria);
    }

    @PostMapping("/new")
    public Item crear(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @DeleteMapping("/delete/{id}")
    public void borrar(@PathVariable String id) {
        itemRepository.deleteById(id);
    }

    @GetMapping("/count")
    public String contarItems() {
        return itemService.countItems();
    }

    @GetMapping("/count/{rate}")
    public String contarItemsPuntuados(@PathVariable double rate) {
        return itemService.countItemsPuntuados(rate);
    }
}

