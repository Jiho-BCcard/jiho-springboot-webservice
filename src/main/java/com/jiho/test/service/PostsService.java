package com.jiho.test.service;

import com.jiho.test.domain.posts.PostRepository;
import com.jiho.test.domain.posts.Posts;
import com.jiho.test.web.dto.PostResponseDto;
import com.jiho.test.web.dto.PostsSaveRequestDto;
import com.jiho.test.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto updateDto) {

        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(updateDto.getTitle(), updateDto.getContent());

        return id;
    }

    public PostResponseDto findById (Long id){
        Posts entity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostResponseDto(entity);
    }
}
