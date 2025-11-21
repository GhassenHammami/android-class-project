# Ateliers Android - Développement Mobile

## Table des matières globale

- [Atelier 2 – Création d'un premier projet Android](#atelier-2--création-dun-premier-projet-android)
- [Atelier 3 – Les layouts Android](#atelier-3--les-layouts-android)
- [Atelier 7 – Les Intents Android](#atelier-7--les-intents-android)

---

# Atelier 2 – Création d'un premier projet Android

## Table des matières
- [Objectif](#objectif)
- [Travail effectué](#travail-effectué)
- [Activité 1 – Page "À propos du développeur"](#activité-1--page-à-propos-du-développeur)
- [Exemple commenté d'un élément du layout](#exemple-commenté-dun-élément-du-layout)
- [Activité 2 – Écran de connexion](#activité-2--écran-de-connexion)
- [Activité 3 – Écran d'inscription](#activité-3--écran-dinscription)
- [Bilan](#bilan)

---

## Objectif

L'objectif de cette séance était de se familiariser avec **Android Studio** et de créer un premier projet Android simple.  
Le but était de comprendre la **structure d'un projet Android**, les différents dossiers générés automatiquement et la **conception d'une interface graphique (layout)** à l'aide du langage XML.

---

## Travail effectué

Le projet nommé **project1** a été créé à partir du modèle *Empty Views Activity*.  
Lors de la configuration, nous avons défini :
- le **nom du projet**,
- le **nom du package**,
- le **langage utilisé** (Java),
- et la **version minimale du SDK**.

Une fois le projet généré, la structure obtenue est la suivante :
- **java/** → contient le code source (`MainActivity.java`)
- **res/** → contient les ressources (images, layouts, textes, couleurs…)
- **AndroidManifest.xml** → fichier de configuration principal de l'application

---

## Activité 1 – Page "À propos du développeur"

Dans cette activité, nous avons modifié le texte d'un `TextView` pour afficher le titre *"À propos du développeur"*.  
Les principales actions réalisées :
- modification du texte et de ses attributs (taille, couleur, style, alignement)  
- ajout d'une **image d'arrière-plan** dans le dossier `drawable`
- renommage de l'activité en **AboutActivity** et du layout en **activity_about.xml**

Le résultat final est une page simple contenant :
- le nom et l'adresse e-mail du développeur,  
- le site web,  
- et un bouton "Fermer".

---

## Exemple commenté d'un élément du layout

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="À propos du développeur"
    android:textColor="@color/design_default_color_primary_variant"
    android:textSize="24sp"
    android:textStyle="bold"
    android:gravity="center" />
```

### Explication des attributs

| Attribut | Description |
|----------|-------------|
| `android:layout_width` | Définit la largeur du composant. `wrap_content` ajuste la largeur automatiquement selon la longueur du texte. |
| `android:layout_height` | Définit la hauteur du composant. `wrap_content` adapte la hauteur à la taille du contenu. |
| `android:text` | Contenu affiché dans le TextView. Ici : "À propos du développeur". |
| `android:textColor` | Couleur du texte, référencée depuis le fichier `res/values/colors.xml`. |
| `android:textSize` | Taille du texte exprimée en sp (scale-independent pixels), pour une bonne lisibilité sur tous les écrans. |
| `android:textStyle` | Style du texte. La valeur `bold` rend le texte en gras. |
| `android:gravity` | Position du texte à l'intérieur du TextView. `center` le centre horizontalement et verticalement. |

---

## Activité 2 – Écran de connexion

Une nouvelle activité nommée **LoginActivity** a été ajoutée.  
Elle permettra l'authentification d'un utilisateur et contient des champs de saisie ainsi qu'un fond d'écran personnalisé.

---

## Activité 3 – Écran d'inscription

Une troisième activité a été créée pour l'inscription d'un utilisateur.  
Elle contient les champs suivants :
- **Nom et prénom**
- **Adresse e-mail**
- **Mot de passe**
- **Confirmation du mot de passe**

---

## Bilan

Cet atelier a permis de :
- comprendre la structure d'un projet Android Studio,
- apprendre à modifier les attributs XML des widgets,
- personnaliser le style d'un layout,
- et créer plusieurs activités liées entre elles.

Ce travail sert de base pour les prochains ateliers, où d'autres écrans et fonctionnalités seront ajoutés.

---

# Atelier 3 – Les layouts Android

## Table des matières
- [Objectif](#objectif-1)
- [Les trois types de layouts](#les-trois-types-de-layouts)
- [Linear Layout](#linear-layout)
- [Relative Layout](#relative-layout)
- [Constraint Layout](#constraint-layout)
- [Activité 1 – Jeu de devinette avec Linear Layout](#activité-1--jeu-de-devinette-avec-linear-layout)
- [Bilan](#bilan-1)

---

## Objectif

L'objectif de cette séance était de découvrir les différents types de **layouts** disponibles dans Android et de comprendre leurs spécificités pour créer des interfaces utilisateur adaptées.

---

## Les trois types de layouts

Dans Android, il existe trois principaux types de layouts pour organiser les éléments de l'interface :

1. **Linear Layout** - Affichage linéaire des widgets
2. **Relative Layout** - Positionnement relatif des éléments
3. **Constraint Layout** - Le plus moderne et flexible (utilisé jusqu'à présent)

---

## Linear Layout

Les widgets sont affichés de manière **linéaire** :
- **Verticale** : les éléments sont placés l'un sous l'autre
- **Horizontale** : les éléments sont placés l'un à côté de l'autre

### Attributs principaux :
- `android:orientation="vertical"` ou `android:orientation="horizontal"`
- `android:layout_weight` pour répartir l'espace disponible

---

## Relative Layout

La position des widgets est **relative** à un élément voisin ou à la zone principale.

### Attributs de positionnement :
| Attribut | Description |
|----------|-------------|
| `layout_alignParentBottom` | Le widget sera aligné selon le parent en bas |
| `layout_alignParentRight` | Le widget sera aligné selon le parent à droite |
| `layout_margin` | Le widget sera espacé depuis le bas gauche de mesure spécifique (ex: 16dp) |
| `layout_below` | Sera aligné en bas du widget spécifié |
| `layout_alignLeft` | Aligné à gauche du widget |
| `marginTop` | Espacement du haut (ex: 10dp) |
| `layout_above` | Positionné au-dessus du widget spécifié |
| `toRightOf` | Positionné à droite du widget spécifié |
| `toLeftOf` | Positionné à gauche du widget spécifié |

---

## Constraint Layout

Le **plus utilisé actuellement**, il permet de positionner et dimensionner les widgets en fonction des relations entre elles et le conteneur parent en même temps.

### Avantages :
- Performance optimisée
- Interface de design visuelle intuitive
- Flexibilité maximale pour les différentes tailles d'écran
- Moins de layouts imbriqués nécessaires

---

## Activité 1 – Jeu de devinette avec Linear Layout

### Description du jeu
Création d'un petit jeu utilisant **Linear Layout** :

1. **Génération du nombre** : Au lancement de l'application, un nombre de 3 chiffres est généré aléatoirement côté backend
2. **Objectif** : L'utilisateur doit deviner ce nombre
3. **Limite** : L'utilisateur dispose de **10 tentatives** pour le trouver
4. **Feedback** : Après chaque tentative, un message approprié sera affiché :
   - "Plus grand" si le nombre saisi est trop petit
   - "Plus petit" si le nombre saisi est trop grand
   - "Bon nombre trouvé !" si la réponse est correcte

### Interface utilisateur
- Champ de saisie pour le nombre
- Bouton "Deviner"
- Zone d'affichage des messages
- Compteur de tentatives restantes
- Bouton "Nouveau jeu" pour recommencer

---

## Bilan

Cet atelier a permis de :
- comprendre les différences entre les trois types de layouts Android,
- apprendre les attributs spécifiques de chaque layout,
- créer une application interactive avec Linear Layout,
- implémenter la logique de jeu avec gestion des tentatives et feedback utilisateur.

Cette connaissance des layouts est essentielle pour créer des interfaces utilisateur efficaces et adaptées aux différentes tailles d'écran.

---

# Atelier 7 – Les Intents Android

## Table des matières
- [Objectif](#objectif-2)
- [Notions théoriques](#notions-théoriques)
- [Intents explicites](#intents-explicites)
- [Intents implicites](#intents-implicites)
- [Activités pratiques](#activités-pratiques)
- [Bilan](#bilan-2)

---

## Objectif

L'objectif de cet atelier était de maîtriser l'utilisation des **Intents**, aussi bien explicites qu'implicites, afin de permettre la communication entre différentes activités d'une application Android ou avec d'autres applications du système.

---

## Notions théoriques

Un **Intent** est un objet Android utilisé pour :

- démarrer une nouvelle activité,
- lancer un service,
- transmettre des données,
- envoyer un broadcast,
- ou encore déléguer une action à une autre application (ex : ouvrir une page web).

Un Intent peut contenir :

- **Action** (ex : `ACTION_VIEW`, `ACTION_SEND`),
- **Data** (souvent sous forme d'URI),
- **Category** (ex : `CATEGORY_LAUNCHER`),
- **Extras** (pour transmettre des données sous forme clé-valeur),
- **Type MIME**,
- **Nom du composant** (dans le cas des Intents explicites).

---

## Intents explicites

Les **intents explicites** sont utilisés pour cibler une activité précise de l'application à l'aide du nom de la classe Java.

```java
Intent intent = new Intent(ActivityCourante.this, ActiviteCible.class);
startActivity(intent);
```

Ils sont surtout utilisés pour la **navigation interne** entre activités d'une même application.

---

## Intents implicites

Les **intents implicites** délèguent l'action à une application capable de la gérer.  
On ne précise pas la classe cible, uniquement l'action et les données.

```java
Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
startActivity(intent);
```

Le système Android sélectionne alors automatiquement l'application appropriée.

---

## Activités pratiques

### 🔹 1. Création de ListeIntentActivity

Une nouvelle activité a été créée pour regrouper et tester plusieurs types d'intents.  
L'interface contient plusieurs boutons, dont certains utilisent `MaterialButton` pour ajouter une icône.

**Exemple :**

```xml
<com.google.android.material.button.MaterialButton
    android:id="@+id/btn_soumettre"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Soumettre le choix de parcours"
    app:icon="@drawable/fb"
    android:textSize="16dp"
    app:iconGravity="textStart"
    app:iconSize="32dp"
    app:iconTint="@color/white" />
```

### 🔹 2. Passage entre deux activités : IntentSimpleActivity → IntentSimpleRetourActivity

Deux interfaces ont été créées pour illustrer :

- l'**envoi de données** d'une activité à une autre,
- puis le **retour vers l'activité initiale** avec un résultat ou un message.

### 🔹 3. Ajout d'un bouton Calculatrice dans l'activité principale

Ce bouton ouvre une activité **CalculatriceActivity** où l'utilisateur saisit deux nombres dans des `EditText`.

Une fois validés, ces valeurs sont envoyées vers une nouvelle activité **CalculerActivity**, qui :

- récupère les deux valeurs,
- effectue un calcul,
- retourne le résultat à l'activité Calculatrice,
- qui l'affiche dans un `TextView`.

### 🔹 4. Intent Implicite – Web, Téléphone, Contacts

Une nouvelle activité **IntentImpliciteActivity** regroupe plusieurs actions :

#### ✔ Ouvrir un site web

Un bouton "Visiter le site web" ouvre :  
`https://www.polytecsousse.tn/`

#### ✔ Composer un numéro

Une zone de texte permet de saisir un numéro.  
Le bouton "Composer le N°" :

- vérifie que le champ n'est pas vide,
- lance l'application Téléphone avec le numéro saisi.

#### ✔ Afficher le répertoire

Un bouton permet d'ouvrir la liste de contacts enregistrés sur le smartphone.

#### ✔ Choisir un contact

Un bouton ouvre le sélecteur de contacts et retourne le contact choisi sous forme de toast.

### 🔹 5. Navigation générale

Deux boutons supplémentaires ont été ajoutés :

- **Retour** → revenir à l'Activité principale
- **Fermer** → quitter l'application

---

## Bilan

Cet atelier a permis de :

- comprendre le fonctionnement et la structure d'un Intent,
- apprendre à utiliser les Intents explicites pour naviguer entre activités,
- manipuler les Intents implicites pour interagir avec d'autres applications (web, téléphone, contacts),
- passer des données entre activités,
- gérer des retours de résultats,
- et enrichir l'interface avec des boutons Material Design.

Les Intents sont essentiels dans Android, car ils permettent la communication interne et externe entre les composants de l'application.

---

## 📝 Notes

Ce projet suit une progression pédagogique structurée pour l'apprentissage du développement Android avec Java et Android Studio.

## 🛠️ Technologies utilisées

- **Android Studio** - Environnement de développement intégré
- **Java** - Langage de programmation
- **XML** - Langage de balisage pour les layouts
- **Android SDK** - Kit de développement logiciel Android
