package com.jiho.test.posts;

import com.jiho.test.domain.posts.PostRepository;
import com.jiho.test.domain.posts.Posts;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After // JUnit 에서 단위테스트 종료후 수행되는 메소드
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트게시글";
        String content = "테스트 본문";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jiho@bccard.com")
                .build());

        //when
        List<Posts> postsList = postRepository.findAll();

//        for (Posts posts : postsList){
//            System.out.println(posts.toString());
//        }

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_Register(){
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postRepository.save(Posts.builder()
                .title("Title")
                .content("Content")
                .author("Park")
                .build());

        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate = "+posts.getCreatedDate() + "modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
