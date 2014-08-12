#!/bin/bash
Stay_Updated="yes"

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
    if [ -f ./src/net/pocketbukkit/PocketBukkit.java ]; then
      PB="compile"
    else
      PB="download"
    fi
  fi
fi

if [ "$PB" == "jar" ]; then
  java -jar PocketBukkit.jar
else
  if [ "$PB" == "compile" ]; then
    #TODO: Compile PocketBukkit
  else
    if [ "$PB" == "download" ]; then
      echo "[INFO] [PocketBukkit] PocketBukkit downloader for Linux & Mac"
      echo "[1/3] Cleaning directory..."
      rm -r start.bat
      rm -r PocketBukkit.jar
      rm -r -f src/
      echo "Done!"
      echo "[2/3] Downloading latest PocketBukkit JAR..."
      download "http://pocketbukkit.net/download/latest"
      echo "Done!"
      echo "[3/3] Starting PocketBukkit..."
      java -jar PocketBukkit.jar
    else
      echo "[FATAL] [PocketBukkit] Unable to determine required operation!"
      exit 1
    fi
  fi
fi
