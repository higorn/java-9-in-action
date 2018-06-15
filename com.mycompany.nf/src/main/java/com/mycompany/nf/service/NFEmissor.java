package com.mycompany.nf.service;

import com.mycompany.domain.model.Book;
import com.mycompany.nf.internal.NFSubscriber;
import com.mycompany.nf.model.NF;

import java.util.concurrent.SubmissionPublisher;

public class NFEmissor {
  private SubmissionPublisher<NF> publisher;

  public NFEmissor() {
    publisher = new SubmissionPublisher<>();
    publisher.subscribe(new NFSubscriber());
  }

  public void emit(String clientName, Book book) {
    NF nf = new NF(clientName, book.getName(), 39.99);
    publisher.submit(nf);
  }

  public void close() {
    publisher.close();
  }
}
