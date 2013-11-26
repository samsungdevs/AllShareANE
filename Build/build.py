import shutil
import os
import zipfile

shutil.copy('../AllShareExtension/bin/AllShareExtension.swc', './')
zipfile.ZipFile('AllShareExtension.swc').extractall('android/')
os.remove('android/catalog.xml')
shutil.copy('../AllShareAndroidLib/AllShareAndroidLib.jar', 'android/')
shutil.copy('../AllShareExtension/src/co/mscsea/extension.xml', './')
os.system('adt -package -target ane AllShareExtension.ane extension.xml -swc AllShareExtension.swc -platform Android-ARM -C android .')