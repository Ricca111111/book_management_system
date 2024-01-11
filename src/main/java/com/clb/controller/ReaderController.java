package com.clb.controller;

import com.clb.domain.Result;
import com.clb.domain.entity.Reader;
import com.clb.service.ReaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reader")
@Slf4j
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping("/update")
    public Result updateReader(@RequestBody Reader reader) {
        log.info("reader:{}", reader);
        return readerService.updateReader(reader);
    }

}
