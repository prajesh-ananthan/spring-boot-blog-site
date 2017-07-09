package com.prajesh.service;

import org.springframework.stereotype.Service;

/**
 * @author Prajesh
 *         Created by Prajesh Ananthan on 8/7/2017.
 */

@Service
public class NotifcationService {
  public String send() {
    return "Message sent!";
  }

  public void sendAsyc() {
    // do something
  }

  @Override
  public String toString() {
    return "NotifcationService";
  }
}
