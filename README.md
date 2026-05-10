# X Android 7

Application Android native simple qui ouvre le site Twitter/X dans un `WebView`.

## Compatibilite

- Android minimum : 7.0 Nougat, API 24
- URL chargee par defaut : `https://twitter.com/`
- JavaScript, DOM storage et cookies tiers sont actives pour permettre la connexion au site.

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

