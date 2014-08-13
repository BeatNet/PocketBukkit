#!/bin/bash
Stay_Updated="no"

#Look for WGET or CURL commands
shopt -s expand_aliases
type wget > /dev/null 2>&1
if [ $? -eq 0 ]; then
  alias download="wget --no-check-certificate -q -O -"
else
  type curl >> /dev/null 2>&1
  if [ $? -eq 0 ]; then
    alias download="curl --insecure --silent --location"
  else
    echo "[FATAL] [PocketBukkit] Unable to find WGET or CURL commands!"
    exit 1
  fi
fi

#Set PocketBukkit to redownload if Stay_Updated is enabled
if [ "$Stay_Updated" == "yes" ]; then
  PB="download"
else
  PB=""
fi

#Check what files exist (If at all)
if [ "$PB" == "" ]; then
  if [ -f ./PocketBukkit.jar ]; then
    PB="jar"
  else
    if [ -f ./src/net/pocketbukkit/PocketBukkit.class ]; then
      PB="runsrc"
    else
      if [ -f ./src/net/pocketbukkit/PocketBukkit.java ]; then
        PB="compile"
      else
        PB="download"
      fi
    fi
  fi
fi

if [ "$PB" == "jar" ]; then
  java -jar PocketBukkit.jar
else
  if [ "$PB" == "compile" ]; then
    echo "[WARNING] [PocketBukkit] PocketBukkit needs to be compiled!"
    echo "[1/2] Compiling PocketBukkit..."
    javac src/net/pocketbukkit/*.java
    javac src/net/pocketbukkit/*/*.java
    javac src/net/pocketbukkit/*/*/*.java
    echo "Done!"
    echo "[2/2] Starting PocketBukkit..."
    java src/net/pocketbukkit/PocketBukkit.class
  else
    if [ "$PB" == "download" ]; then
      echo "[INFO] [PocketBukkit] PocketBukkit downloader for Linux & Mac"
      echo "[1/3] Cleaning directory..."
      if [ -f ./start.bat ]; then
        rm -r start.bat
      fi
      if [ -f ./PocketBukkit.jar ]; then
        rm -r PocketBukkit.jar
      fi
      if [ -f ./src/net/pocketbukkit/PocketBukkit.java ]; then
        rm -r -f src/
      fi
      if [ -f ./src/net/pocketbukkit/PocketBukkit.class ]; then
        rm -r -f src/
      fi
      echo "Done!"
      echo "[2/3] Downloading latest PocketBukkit JAR..."
      download "http://pocketbukkit.net/download/latest"
      echo "Done!"
      echo "[3/3] Starting PocketBukkit..."
      java -jar PocketBukkit.jar
    else
      if [ "$PB" == "runsrc" ]; then
        java src/net/pocketbukkit/PocketBukkit.class
      else
        echo "[FATAL] [PocketBukkit] Unable to determine required operation!"
        exit 1
      fi
    fi
  fi
fi
