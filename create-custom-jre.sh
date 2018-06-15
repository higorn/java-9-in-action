#!/bin/sh

JAVA_HOME=/usr/lib/jvm/jdk-10.0.1
MODS=/Desenv/higor/java9/bookstore/com.mycompany.core/target/classes:\
/Desenv/higor/java9/bookstore/com.mycompany.nf/target/classes:\
/Desenv/higor/java9/bookstore/com.mycompany.domain/target/classes:\
/Desenv/higor/java9/bookstore/com.mycompany.http/target/classes
MODS_PATH=$JAVA_HOME/jmods/:$MODS

#$JAVA_HOME/bin/jlink --module-path $MODS_PATH --add-modules $MODS --output small-JRE
$JAVA_HOME/bin/jlink --module-path $MODS_PATH --add-modules com.mycompany --output JRE-bookstore
