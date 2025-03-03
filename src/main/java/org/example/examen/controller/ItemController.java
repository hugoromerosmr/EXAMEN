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

    /**
     * Busca un item por su ID.
     *
     * @param id El ID del item a buscar.
     * @return ResponseEntity con el item encontrado o un estado 404 si no se encuentra.
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable String id) {
        Optional<Item> item = itemService.findById(id);
        return item.isPresent() ? ResponseEntity.ok(item.get()) : ResponseEntity.notFound().build();
    }

    /**
     * Busca items por su categoría.
     *
     * @param categoria La categoría de los items a buscar.
     * @return Lista de items que pertenecen a la categoría especificada.
     */
    @GetMapping("/categoria/{categoria}")
    public List<Item> buscarPorCategoria(@PathVariable String categoria) {
        return itemRepository.findByCategoryContainingIgnoreCase(categoria);
    }

    /**
     * Crea un nuevo item.
     *
     * @param item El item a crear.
     * @return El item creado.
     */
    @PostMapping("/new")
    public Item crear(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    /**
     * Borra un item por su ID.
     *
     * @param id El ID del item a borrar.
     */
    @DeleteMapping("/delete/{id}")
    public void borrar(@PathVariable String id) {
        itemRepository.deleteById(id);
    }

    /**
     * Cuenta el número total de items.
     *
     * @return El número total de items.
     */
    @GetMapping("/count")
    public String contarItems() {
        return itemService.countItems();
    }

    /**
     * Cuenta el número de items con una puntuación específica.
     *
     * @param rate La puntuación de los items a contar.
     * @return El número de items con la puntuación especificada.
     */
    @GetMapping("/count/{rate}")
    public String contarItemsPuntuados(@PathVariable double rate) {
        return itemService.countItemsPuntuados(rate);
    }
}