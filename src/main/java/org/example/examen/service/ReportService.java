package org.example.examen.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.examen.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class for generating reports.
 */
@Service
public class ReportService {

    @Autowired
    private ItemService itemService;

    /**
     * Generates a PDF report of items.
     *
     * @return a byte array containing the PDF content
     * @throws JRException if there is an error generating the report
     * @throws IOException if there is an error reading the template file
     */
    public byte[] generateItemsPdf() throws JRException, IOException {
        List<Item> items = itemService.obtenerTodos();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items);

        InputStream inputStream = new ClassPathResource("templates/listadojuegos.jrxml").getInputStream();
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Your Company");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}