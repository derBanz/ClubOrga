@echo off
title BPM backend

call mvn compile quarkus:dev -Ddebug=5203 -DskipTests -DskipFrontend 
pause

exit /b