@echo off
@chcp 936

choice  /c BRQ /m "输入B备份，R还原备份，Q退出。默认10秒后退出程序(不区分大小写)" /d Q /t 5

if %errorlevel%==1 (
    Goto backupFunction
) else if %errorlevel%==2 (
    Goto restoreFunction
) else (
    echo Exiting...
    exit
)

:backupFunction (
    set backupName=
    set /p backupName=请输入存档名:

    if "%backupName%"=="" (
        set backupName=%date:~0,4%%date:~5,2%%date:~8,2%
        echo 未指定文件名，取系统时间
    )

    set backupDir=%~dp0%backupName%

    echo 备份目录为:%backupDir%

    mkdir %backupDir%

    set saveDir=C:\Users\%userName%\AppData\Roaming\DarkSoulsIII

    xcopy %saveDir% %backupDir% /E /H /F

    echo 按任意键退出...
    pause>nul
    exit
)

:restoreFunction (
    echo 当前已建立的存档：
    dir /ad/b
    set restoreName=
    set /p restoreName=请输入要还原的存档名:

    if "%restoreName%"=="" (
        echo 未指定文件名,按任意键退出...
        pause>nul
        exit
    )
    set saveDir=C:\Users\%userName%\AppData\Roaming\DarkSoulsIII
    set backupDir=%~dp0%restoreName%

    if not exist %backupDir% (
        echo 指定存档不存在,请输入正确的存档名！
        echo 按任意键退出......
        pause>nul
        exit
    )

    xcopy %backupDir% %saveDir% /E /H /F

    echo 按任意键退出...
    pause>nul
    exit

)