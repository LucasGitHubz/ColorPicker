# ColorPicker

<kbd>
 <img src="https://image.noelshack.com/fichiers/2022/01/2/1641315996-img2.png"/>
</kbd>
<kbd>
 <img src="https://image.noelshack.com/fichiers/2022/01/2/1641317058-img3.png"/>
</kbd>

</br>
</br>

Ce dépôt contient _L'Application ColorPicker_ qui permet de générer un bouton flottant avec une couleur personnalisable.


## Procédure Installation
1. Dans `app/build.gradle` ajouter la dépendance suivante : _implementation 'com.github.LucasGitHubz:ColorPicker:<Release Number>'_
   Ou <Release Number> correspond à une des versions sur [cette](https://github.com/LucasGitHubz/ColorPicker/releases) page.
3. A la racine du projet dans le fichier `settings.gradle` ajouter dans `repositories {...}` : _maven { url 'https://jitpack.io' }_


## Procédure D'utilisation
Dans votre layout ajouter le bouton : 

```
 <com.example.colorpicker.FloatingButton
        android:id="@+id/colorPickerButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```

Du côté code, utiliser ensuite la fonctionnalite de _view binding_ ou butterknife pour recuperer le bouton floatant grace a son id.
Les methodes `getColor` et `setColor(int)` permettront respectivement de recuperer et programmer la couleur du bouton.

