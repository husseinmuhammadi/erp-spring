package com.digiboy.erp.web.controller;

import com.digiboy.erp.api.GeneralService;
import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.dto.DTOBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class ControllerBase<T extends DTOBase> {

    protected final Logger logger;

    public ControllerBase(Logger logger) {
        this.logger = logger;
    }

    abstract GeneralService<T> service();

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<T> tPage = service().findAll(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("tPage", tPage);
        int totalPages = tPage.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return index();
    }

    @GetMapping("/entry")
    public String entry(Model model) {
        model.addAttribute("company", new CompanyDTO());
        return entry();
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("model") T dto) {
        try {
            dto = service().save(dto);
            logger.info(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dto));
            return "redirect:"+indexController();
        } catch (Exception e) {
            logger.error("Error during saving entity", e);
            return null;
        }
    }

    @ModelAttribute("model")
    public abstract DTOBase getModel();

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id,
                         @RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        service().remove(id);
        return "redirect:" + indexController() + "?size=" + pageSize + "&page=" + currentPage;
    }

    abstract String index();

    abstract String entry();

    abstract String indexController();
}
