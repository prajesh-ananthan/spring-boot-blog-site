package com.prajesh.controller;

import com.prajesh.service.NotifcationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Prajesh
 *         Created by Prajesh Ananthan on 8/7/2017.
 */

@RestController
public class PageController {

  private NotifcationService notifcationService;

  // From application.properties
  private @Value("${message.str}") String message;

  @RequestMapping("/home")
  public String home() {
    return notifcationService.toString();
  }

  @RequestMapping("/message")
  public String getMessage() {
    return message;
  }

  public NotifcationService getNotifcationService() {
    return notifcationService;
  }

  @Autowired
  public void setNotifcationService(NotifcationService notifcationService) {
    this.notifcationService = notifcationService;
  }
}