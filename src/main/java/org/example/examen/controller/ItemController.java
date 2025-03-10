package org.example.examen.controller;

import net.sf.jasperreports.engine.JRException;
import org.example.examen.models.Item;
import org.example.examen.service.ItemService;
import org.example.examen.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/items")
    public String getAllItems(Model model) {
        List<Item> items = itemService.obtenerTodos();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("/item/{id}")
    public String getItemDetails(@PathVariable String id, Model model) {
        Item item = itemService.findById(id).orElse(null);
        model.addAttribute("item", item);
        return "itemdetails";
    }

    @GetMapping("/items/pdf")
    public ResponseEntity<byte[]> generatePdf() {
        try {
            byte[] pdfContent = reportService.generateItemsPdf();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "items.pdf");
            return ResponseEntity.ok().headers(headers).body(pdfContent);
        } catch (JRException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}