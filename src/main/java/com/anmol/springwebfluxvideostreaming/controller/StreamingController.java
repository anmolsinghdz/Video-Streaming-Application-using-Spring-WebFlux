package com.anmol.springwebfluxvideostreaming.controller;

import com.anmol.springwebfluxvideostreaming.service.StreamingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("video")
@RequiredArgsConstructor
@Slf4j
public class StreamingController {

    private final StreamingService streamingService;

    @GetMapping(value = "/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range) {
        log.info(range);
        return streamingService.getVideo(title);
    }

    @GetMapping(value = "/test")
    public Mono<String> index() {
        log.info("Testing ...");
        return Mono.just("Coba-coba " + LocalDateTime.now());
    }
}
