package com.jiho.test.service;

import com.jiho.test.domain.posts.PostRepository;
import com.jiho.test.web.dto.PostsSaveRequestDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }
}
