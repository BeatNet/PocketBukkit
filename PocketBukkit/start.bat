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
    ECHO [1/2] Compiling PocketBukkit...
    javac src/net/pocketbukkit/*.java
    javac src/net/pocketbukkit/*/*.java
    javac src/net/pocketbukkit/*/*/*.java
    ECHO Done!
    ECHO [2/2] Starting PocketBukkit...
    java src/net/pocketbukkit/PocketBukkit.class
  ) ELSE (
    IF %PB% == download (
      IF EXIST start.sh (
        del start.sh
      )
      IF EXIST PocketBukkit.jar (
        del PocketBukkit.jar
      )
      IF EXIST src/net/pocketbukkit/PocketBukkit.java (
        rmdir src/
      )
      IF EXIST src/net/pocketbukkit/PocketBukkit.class (
        rm src/
      )
      XCOPY http://pocketbukkit.net/download/0001/PocketBukkit.jar
      java -jar PocketBukkit.jar
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
