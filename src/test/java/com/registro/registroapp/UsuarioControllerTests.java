package com.registro.registroapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.registro.registroapp.controller.UsuarioController;
import com.registro.registroapp.service.UsuarioService;
import com.registro.registroapp.service.builder.model.UsuarioVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    public UsuarioController usuarioController;

    @Autowired
    public UsuarioService usuarioService;

    @Test
    void testGetAllUsuarios() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/usuario")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    void testGetFindUsuarioOkResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/usuario/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void testCreateUsuario() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/usuario")
                .content(asJsonString(new UsuarioVO()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    void testUpdateUsuario() throws Exception {
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setId(1L);
        mvc.perform(MockMvcRequestBuilders
                .put("/usuario")
                .content(asJsonString(usuarioVO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteUsuario() throws Exception {
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setId(1L);
        mvc.perform(MockMvcRequestBuilders
                .delete("/usuario")
                .content(asJsonString(usuarioVO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
