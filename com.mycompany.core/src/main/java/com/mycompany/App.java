package com.mycompany;

import com.mycompany.domain.model.Book;
import com.mycompany.http.Books;
import com.mycompany.nf.service.NFEmissor;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class App {
  public static void main(String... args) {
    System.out.println("\nLista de livros disponíveis \n");
    List<Book> books = Books.all();
    IntStream.range(0, books.size())
        .forEach(i -> {
          System.out.println(i + " - " + books.get(i).getName());
        });

    var scanner = new Scanner(System.in);
    System.out.println("\nDigite o número do livro que quer comprar: \n");

    try {

      int number = scanner.nextInt();

      Book book = books.get(number);
      System.out.println("O livro escolhido foi: " + book.getName());

      System.out.println("\nInforme seu nome, para que possamos emitir a nota fiscal: ");
      scanner = new Scanner(System.in);
      String name = scanner.nextLine();

      NFEmissor emissor = new NFEmissor();
      emissor.emit(name, book);

      Books.findSimilar(book)
          .ifPresentOrElse(showSimilar, noSuggestions);

      // Segura a execução para o código assíncrono terminar
      System.out.println("Pressione enter para sair.");
      new Scanner(System.in).nextLine();

      emissor.close();
    } catch (Exception e) {
      System.err.println("Ops, aconteceu um erro: " + e);
    }
  }

  private static Runnable noSuggestions = () -> System.out.println(
      "\nNão temos nenhuma sugestão de livro similar no momento");

  private static Consumer<Book> showSimilar = similar -> System.out.println(
      "\nTalvez você também goste do livro: " + similar.getName());
}
