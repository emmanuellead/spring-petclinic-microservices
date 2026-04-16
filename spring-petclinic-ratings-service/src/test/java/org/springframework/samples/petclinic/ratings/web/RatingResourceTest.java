package org.springframework.samples.petclinic.ratings.web;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.samples.petclinic.ratings.model.Rating;
import org.springframework.samples.petclinic.ratings.model.RatingRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

@WebMvcTest(RatingResource.class)
@ActiveProfiles("test")
class RatingResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private RatingRepository ratingRepository;

    @Test
    void shouldReturnAverageRating() throws Exception {
        Rating r1 = new Rating();
        r1.setStars(5);
        Rating r2 = new Rating();
        r2.setStars(3);

        given(ratingRepository.findByVetId(1)).willReturn(Arrays.asList(r1, r2));

        mvc.perform(get("/ratings/stats/vet/1"))
            .andExpect(status().isOk())
            .andExpect(content().string("4.0"));
    }

    @Test
    void shouldReturnZeroWhenNoRatings() throws Exception {
        given(ratingRepository.findByVetId(2)).willReturn(Collections.emptyList());

        mvc.perform(get("/ratings/stats/vet/2"))
            .andExpect(status().isOk())
            .andExpect(content().string("0.0"));
    }

    @Test
    void shouldHandleNullStars() throws Exception {
        Rating r1 = new Rating();
        r1.setStars(null);

        given(ratingRepository.findByVetId(3)).willReturn(Collections.singletonList(r1));

        mvc.perform(get("/ratings/stats/vet/3"))
            .andExpect(status().isOk())
            .andExpect(content().string("0.0"));
    }
    @Test
    void shouldRejectNullStarsOnCreate() throws Exception {
        mvc.perform(post("/ratings/visit/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"vetId\":1, \"comment\":\"test\"}"))
            .andExpect(status().isBadRequest());
    }
    @Test
    void shouldRejectInvalidStarsOnCreate() throws Exception {
        mvc.perform(post("/ratings/visit/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"vetId\":1, \"stars\":6, \"comment\":\"test\"}"))
            .andExpect(status().isBadRequest());

        mvc.perform(post("/ratings/visit/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"vetId\":1, \"stars\":0, \"comment\":\"test\"}"))
            .andExpect(status().isBadRequest());
    }
}
