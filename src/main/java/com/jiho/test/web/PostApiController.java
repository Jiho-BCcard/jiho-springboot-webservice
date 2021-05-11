package com.jiho.test.web;

import com.jiho.test.service.PostsService;
import com.jiho.test.web.dto.PostResponseDto;
import com.jiho.test.web.dto.PostsSaveRequestDto;
import com.jiho.test.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);
    }

    @PutMapping("api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostResponseDto findById (@PathVariable Long id){

        return postsService.findById(id);
    }

}