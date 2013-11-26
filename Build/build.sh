#!/bin/bash
cp -f ../AllShareExtension/bin/AllShareExtension.swc .
unzip -o AllShareExtension.swc -d android -x catalog.xml
cp -f ../AllShareAndroidLib/AllShareAndroidLib.jar android
cp -f ../AllShareExtension/src/co/mscsea/extension.xml .
adt.bat -package -target ane AllShareExtension.ane extension.xml -swc AllShareExtension.swc -platform Android-ARM -C android .