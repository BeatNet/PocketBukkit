@echo off
set Stay_Updated=no

Title PocketBukkit Console
Cls
IF %Stay_Updated% == yes (
  set PB=download
) ELSE (
  set PB=determine
)

IF %PB% == determine (
  IF EXIST PocketBukkit.jar (
    set PB=jar
  ) ELSE (
    IF EXIST src/net/pocketbukkit/PocketBukkit.class (
      set PB=runsrc
    ) ELSE (
      IF EXIST src/net/pocketbukkit/PocketBukkit.java (
        set PB=compile
      ) ELSE (
        set PB=download
      )
    )
  )
)

IF %PB% == jar (
  java -jar PocketBukkit.jar
) ELSE (
  IF %PB% == compile (
    ECHO [WARNING] [PocketBukkit] PocketBukkit needs to be compiled!
    ECHO --------------------------------------------------------------
    ECHO [1/2] Compiling PocketBukkit...
    javac src/net/pocketbukkit/*.java
    javac src/net/pocketbukkit/*/*.java
    javac src/net/pocketbukkit/*/*/*.java
    ECHO Done!
    ECHO --------------------------------------------------------------
    ECHO [2/2] Starting PocketBukkit...
    ECHO --------------------------------------------------------------
    java src/net/pocketbukkit/PocketBukkit.class
  ) ELSE (
    IF %PB% == download (
      ECHO [INFO] [PocketBukkit] PocketBukkit downloader for Windows
      ECHO --------------------------------------------------------------
      ECHO [1/3] Cleaning directory...
      IF EXIST start.sh (
        ECHO Removing start.sh...
        del start.sh
      )
      IF EXIST PocketBukkit.jar (
        ECHO Removing PocketBukkit.jar
        del PocketBukkit.jar
      )
      IF EXIST src/net/pocketbukkit/PocketBukkit.java (
        ECHO Removing src directory...
        rmdir src/
      )
      IF EXIST src/net/pocketbukkit/PocketBukkit.class (
        ECHO Removing src directory...
        rmdir src/
      )
      ECHO Done!
      ECHO --------------------------------------------------------------
      ECHO [2/3] Downloading latest PocketBukkit JAR...
      ECHO Done!
      ECHO --------------------------------------------------------------
      ECHO [3/3] Starting PocketBukkit...
      ECHO --------------------------------------------------------------
      IF EXIST PocketBukkit.jar (
        java -jar PocketBukkit.jar
      ) ELSE (
        ECHO [FATAL] [PocketBukkit] Unable to locate PocketBukkit.jar!
        PAUSE
      )
    ) ELSE (
      IF %PB% == runsrc (
        java src/net/pocketbukkit/PocketBukkit.class
      ) ELSE (
        ECHO [FATAL] [PocketBukkit] Unable to determine required operation!
        PAUSE
      )
    )
  )
)
EXIT
