@echo off
Stay_Updated="no"

Title PocketBukkit Console
Cls
IF %Stay_Updated% == "yes" (
  PB="download"
) ELSE (
  PB=""
)

IF EXIST PocketBukkit.jar (
  PB="jar"
) ELSE (
  IF EXIST src/net/pocketbukkit/PocketBukkit.class (
    PB="runsrc"
  ) ELSE (
    IF EXIST src/net/pocketbukkit/PocketBukkit.java (
      PB="compile"
    ) ELSE (
      PB="download"
    )
  )
)

IF %PB% == "jar" (
  java -jar PocketBukkit.jar
) ELSE (
  IF %PB% == "compile" (
    echo "[WARNING] [PocketBukkit] PocketBukkit needs to be compiled!"
    echo "[1/2] Comipling PocketBukkit..."
    javac src/net/pocketbukkit/*.java
    javac src/net/pocketbukkit/*/*.java
    javac src/net/pocketbukkit/*/*/*.java
    echo "Done!"
    echo "[2/2] Starting PocketBukkit..."
    java src/net/pocketbukkit/PocketBukkit.class
  ) ELSE (
    IF %PB% == "runsrc" (
      java src/net/pocketbukkit/PocketBukkit.class
    ) ELSE (
      IF %PB% == "download" (
        echo "Downloading has not yet been implemented for the batch startup!"
        Pause
      ) ELSE (
        echo "[FATAL] [PocketBukkit] Unable to determine required function!"
        Pause
      )
    )
  )
)
Exit
