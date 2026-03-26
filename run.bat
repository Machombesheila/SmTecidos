@echo off
title InvenTree - Product Inventory Management System
echo ============================================
echo   InvenTree - Starting Application...
echo ============================================
echo.

REM ---- MySQL Configuration ----
set MYSQL_BIN="C:\Program Files\MySQL\MySQL Server 8.4\bin"
set MYSQL_DATA="C:\Users\Anany\mysql_data"

REM Check if MySQL is already running
tasklist /FI "IMAGENAME eq mysqld.exe" 2>NUL | find /I "mysqld.exe" >NUL
if %ERRORLEVEL% NEQ 0 (
    echo [INFO] Starting MySQL Server...
    start "" /B %MYSQL_BIN%\mysqld.exe --datadir=%MYSQL_DATA% --port=3306
    echo [INFO] Waiting for MySQL to start...
    timeout /t 5 /nobreak >NUL
    echo [INFO] MySQL Server started.
) else (
    echo [INFO] MySQL is already running.
)

REM ---- Maven Configuration ----
set MVN_CMD="C:\Program Files\Apache NetBeans\java\maven\bin\mvn.cmd"

if not exist %MVN_CMD% (
    echo [ERROR] Maven not found at %MVN_CMD%
    echo Please install Maven or update the path in this script.
    pause
    exit /b 1
)

echo [INFO] Using Maven at: %MVN_CMD%
echo [INFO] Building and running InvenTree...
echo [INFO] Application will be available at: http://localhost:8080/products
echo.

REM Run Spring Boot application
call %MVN_CMD% spring-boot:run

echo.
echo ============================================
echo   InvenTree has stopped.
echo ============================================
pause
