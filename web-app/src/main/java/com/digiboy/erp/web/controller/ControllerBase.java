package com.digiboy.erp.web.controller;

import com.digiboy.erp.api.GeneralService;
import com.digiboy.erp.dto.DTOBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class ControllerBase<T extends DTOBase> {

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

    abstract String index();
}