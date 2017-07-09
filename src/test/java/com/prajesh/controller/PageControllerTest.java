package com.prajesh.controller;

import com.prajesh.service.NotifcationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Prajesh
 *         Created by Prajesh Ananthan on 8/7/2017.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(PageController.class)
public class PageControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testsendMessage() throws Exception {
    ResultActions resultActions = mockMvc.perform(get("/service"));
    MvcResult result = resultActions.andExpect(status().isOk()).andDo(print()).andReturn();

    assertThat(result.toString(), is(new NotifcationService().toString()));
  }
}