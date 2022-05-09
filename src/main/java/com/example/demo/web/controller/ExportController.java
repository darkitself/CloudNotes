package com.example.demo.web.controller;

import com.example.demo.service.ExportService;
import com.example.demo.web.dto.response.export.ExportDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/export")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ExportController {

    ObjectMapper objectMapper;
    ExportService exportService;

    @GetMapping("")
    public String page() {
        return "export";
    }

    @SneakyThrows
    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> export() {
        byte[] file =objectMapper.writeValueAsBytes(exportService.export());
        ByteArrayResource resource = new ByteArrayResource(file);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=export.txt")
                .contentLength(file.length)
                .contentType(MediaType.TEXT_PLAIN)
                .body(resource);
    }

    @SneakyThrows
    @PostMapping("/restore")
    public ModelAndView post(@ModelAttribute MultipartFile file) {
        ExportDto dto = objectMapper.readValue(file.getInputStream(), ExportDto.class);
        exportService.restore(dto);
        return new ModelAndView("redirect:/api/export");
    }
}
