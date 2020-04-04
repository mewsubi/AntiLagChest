@echo off
cd /d %~dp0
cd .
dir /s /B *.class > sources.txt
powershell -Command "(gc sources.txt) -replace 'C:\\Users\\noldea\\Documents\\Minecraft\\AntiLagChest\\build\\', '' | Out-File -encoding ASCII sources.txt"
jar cmf antilagchest.mf ../AntiLagChest.jar plugin.yml @sources.txt
cd ..