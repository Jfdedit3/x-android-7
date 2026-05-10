# X Android 7

Application Android native simple qui ouvre le site X/Twitter avec GeckoView, le moteur web de Firefox embarque dans l'APK.

## Compatibilite

- Android minimum : 7.0 Nougat, API 24
- URL chargee par defaut : `https://x.com/`
- GeckoView evite de dependre du `WebView` systeme d'Android 7, souvent trop ancien pour X/Twitter.
- L'APK est beaucoup plus gros qu'une app WebView classique, parce qu'il contient le moteur web.

## Compilation

Ouvrir le dossier dans Android Studio, laisser Gradle synchroniser le projet, puis lancer :

```powershell
.\gradlew.bat assembleDebug
```

L'APK debug sera genere dans :

```text
app/build/outputs/apk/debug/app-debug.apk
```

Si Android Studio demande l'emplacement du SDK, installer au minimum une plateforme Android recente pour `compileSdk 35`.
