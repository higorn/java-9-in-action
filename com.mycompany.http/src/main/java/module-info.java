module com.mycompany.http {
  requires jdk.incubator.httpclient;
  requires transitive com.mycompany.domain;
  exports com.mycompany.http;
}