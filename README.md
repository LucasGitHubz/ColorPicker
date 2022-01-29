# ColorPicker
![ColorPicker présentation](https://image.noelshack.com/fichiers/2022/01/2/1641315996-img2.png)
![ColorPicker présentation](https://image.noelshack.com/fichiers/2022/01/2/1641317058-img3.png)

Ce dépôt contient _L'Application ColorPicker_ qui permet de générer un bouton floattant avec une couleur personnalisable.


## Procédure Installation
1. **Dans app/build.gradle ajouter la dépendance suivante** : _implementation 'com.github.LucasGitHubz:ColorPicker:2.0.2'_
2. **A la racine du projet dans le fichier settings.gradle ajouter dans repositories{...}** : maven { url 'https://jitpack.io' }


## Procédure D'utilisation
**Dans votre layout ajouter le button** : 

```
 <com.example.colorpicker.FloatingButton
        android:id="@+id/colorPickerButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```


