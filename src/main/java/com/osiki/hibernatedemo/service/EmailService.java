package com.osiki.hibernatedemo.service;

import com.osiki.hibernatedemo.payload.request.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
}
