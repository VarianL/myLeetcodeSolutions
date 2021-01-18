@echo off
@chcp 936

choice  /c BRQ /m "����B���ݣ�R��ԭ���ݣ�Q�˳���Ĭ��10����˳�����(�����ִ�Сд)" /d Q /t 5

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
    set /p backupName=������浵��:

    if "%backupName%"=="" (
        set backupName=%date:~0,4%%date:~5,2%%date:~8,2%
        echo δָ���ļ�����ȡϵͳʱ��
    )

    set backupDir=%~dp0%backupName%

    echo ����Ŀ¼Ϊ:%backupDir%

    mkdir %backupDir%

    set saveDir=C:\Users\%userName%\AppData\Roaming\DarkSoulsIII

    xcopy %saveDir% %backupDir% /E /H /F

    echo ��������˳�...
    pause>nul
    exit
)

:restoreFunction (
    echo ��ǰ�ѽ����Ĵ浵��
    dir /ad/b
    set restoreName=
    set /p restoreName=������Ҫ��ԭ�Ĵ浵��:

    if "%restoreName%"=="" (
        echo δָ���ļ���,��������˳�...
        pause>nul
        exit
    )
    set saveDir=C:\Users\%userName%\AppData\Roaming\DarkSoulsIII
    set backupDir=%~dp0%restoreName%

    if not exist %backupDir% (
        echo ָ���浵������,��������ȷ�Ĵ浵����
        echo ��������˳�......
        pause>nul
        exit
    )

    xcopy %backupDir% %saveDir% /E /H /F

    echo ��������˳�...
    pause>nul
    exit

)