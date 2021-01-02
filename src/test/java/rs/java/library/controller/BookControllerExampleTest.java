package rs.java.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import rs.java.library.model.BookEntity;
import rs.java.library.repository.BookRepository;
import rs.java.library.request.BookRequest;
import rs.java.library.response.BookResponse;
import rs.java.library.service.BookService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(BookController.class) - do testowania samego controllera czy url jest ok
//@WithMockUser
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerExampleTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    BookService bookService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookController bookController;

    @Test
    void shouldAddBook() throws Exception {
        //given
        BookRequest book = new BookRequest("123abc", "Pudzian", "some_title");

        //when
        mockMvc.perform(post("/api/books")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetBooks() throws Exception {
        //when
        MvcResult result = mockMvc.perform(get("/api/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //then
        BookResponse[] bookResponses = objectMapper.readValue(result.getResponse().getContentAsString(), BookResponse[].class);
        assertThat(bookResponses).isNotNull();
    }

    //test integracyjny, testuje wszystkie warstwy controller + sevice + mappery
    @Test
    @Transactional
    public void shouldGetSingleBook() throws Exception {
        //given
        BookRequest bookRequest = new BookRequest("test_isbn", "test_author", "test_title");
        Integer addedBookId = bookController.addBook(bookRequest);

        //when
        MvcResult result = mockMvc.perform(get("/api/books/" + addedBookId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //then
        BookResponse bookResponse = objectMapper.readValue(result.getResponse().getContentAsString(), BookResponse.class);
        assertThat(bookResponse.getId()).isEqualTo(addedBookId);
        assertThat(bookResponse).isNotNull();
        assertThat(bookResponse.getAuthor()).isEqualTo("test_author");
        assertThat(bookResponse.getIsbn()).isEqualTo("test_isbn");
        assertThat(bookResponse.getTitle()).isEqualTo("test_title");
    }
}