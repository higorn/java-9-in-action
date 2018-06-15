#!/bin/sh

MODS=/Desenv/higor/java9/bookstore/com.mycompany.core/target/classes:\
/Desenv/higor/java9/bookstore/com.mycompany.nf/target/classes:\
/Desenv/higor/java9/bookstore/com.mycompany.domain/target/classes:\
/Desenv/higor/java9/bookstore/com.mycompany.http/target/classes
MAIN=com.mycompany/com.mycompany.App

/usr/lib/jvm/jdk-10.0.1/bin/java -Dfile.encoding=UTF-8 -p $MODS -m $MAIN
