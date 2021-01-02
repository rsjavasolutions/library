package rs.java.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import rs.java.library.model.BookEntity;
import rs.java.library.repository.BookRepository;
import rs.java.library.request.BookRequest;
import rs.java.library.response.BookResponse;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldGetBook() throws Exception {

        //when
        MvcResult mvcResult = mockMvc.perform(get("/api/books/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        //then
        BookResponse bookResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BookResponse.class);
        assertThat(bookResponse).isNotNull();
        assertThat(bookResponse.getAuthor()).isEqualTo("Best Cars");

        Optional<BookEntity> bookEntity = bookRepository.findById(1);
        assertThat(bookEntity).isPresent();
        assertThat(bookEntity.get().getTitle()).isEqualTo("Jeremy Clarkson");
    }

    @Test
    void shouldGetBooks() throws Exception {

        //when
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk());
//        //then
//        BookResponse bookResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BookResponse.class);
//        assertThat(bookResponse).isNotNull();
//        assertThat(bookResponse.getAuthor()).isEqualTo("Best Cars");
//
//        Optional<BookEntity> bookEntity = bookRepository.findById(1);
//        assertThat(bookEntity).isPresent();
//        assertThat(bookEntity.get().getTitle()).isEqualTo("Jeremy Clarkson");
    }

    @Test
    void shouldAdBook() throws Exception {


        //when
        mockMvc.perform(post("/api/books"))
                .andExpect(status().isOk());
//        //then
//        BookResponse bookResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BookResponse.class);
//        assertThat(bookResponse).isNotNull();
//        assertThat(bookResponse.getAuthor()).isEqualTo("Best Cars");
//
//        Optional<BookEntity> bookEntity = bookRepository.findById(1);
//        assertThat(bookEntity).isPresent();
//        assertThat(bookEntity.get().getTitle()).isEqualTo("Jeremy Clarkson");
    }
}