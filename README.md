<h1>Travaux Pratiques sur les Tests Unitaires</h1>

Ce dépôt contient les solutions des Travaux Pratiques (TP) 1, 2 et 3, développées dans le cadre du cursus de Data Engineer à Diginamic.

<h2>Introduction</h2>

Ce dépôt vise à présenter les solutions aux différents Travaux Pratiques donnés dans le cadre du cours sur les tests unitaires. Chaque TP est documenté séparément avec une explication détaillée du problème et de la solution apportée.

<h2>TP1</h2>

Dans l'exercice numéro 1, un bug était présent dans le code initial. Ce bug était dû à une mauvaise gestion des retours de la méthode valueOfLibelle.
Solution Apportée

<h3>Correction du Bug:</h3>
    Le premier return null a été supprimé, car il provoquait le retour de null pour toute valeur autre que la première dans la boucle.
    Le second return null a été déplacé en dehors de la boucle for, pour qu'il ne soit exécuté que si aucune correspondance n'était trouvée.

<h3>Amélioration:</h3>
    J'ai introduit une insensibilité à la casse (case insensitivity) pour que la méthode ne tienne pas compte de la taille des caractères lors de la comparaison.
    J'ai également envisagé d'ajouter une "insensibilité aux accents" (accents insensitivity), mais cela dépassait le cadre de l'exercice et était trop complexe à ce stade.

<h2>TP2</h2>

Dans ce cas, le code a bien fonctionné, le premier test a fonctionné du premier coup. Pour gérer les valeurs "nulles", j'ai dû ajouter une exception dans la première partie du code.

<h3>Tests Unitaires:</h3>
Dans le cas des chaînes vides, la fonction renvoie la longueur du seul mot. Si des valeurs sont nulls, le système throws une exception.


<h2>TP3</h2>

Lors du premier test, j'ai remarqué que le nombre total de pièces était la taille réelle du tableau moins 1, ce qui indiquait que la fonction ne fonctionnait pas correctement. J'ai dû modifier la fonction `nbPieces` pour corriger ce problème.

Pendant le deuxième test, j'ai constaté que la méthode `superficieEtage` ne fonctionnait pas correctement. La boucle ne prenait en compte que le dernier résultat sans ajouter la superficie actuelle au total. J'ai corrigé cette erreur en modifiant la boucle pour qu'elle additionne correctement la superficie courante :
```java
superficieEtage = this.pieces[i].getSuperficie() + superficieEtage;
```

Pour la méthode ajouterPiece(), j'ai remarqué que si le paramètre était null, la pièce était tout de même ajoutée. J'ai corrigé cela en ajoutant ce bloc de code au début de la fonction :

public void ajouterPiece(Piece nvPiece) {

	if (nvPiece == null) {
		return;
	}

Enfin, il y avait une erreur dans la méthode superficieTypePiece. La boucle commençait avec i = 1, ce qui ignorait le premier élément du tableau. J'ai corrigé cette erreur en faisant commencer la boucle à l'index 0.

J'ai également trouvé et corrigé quelques autres petites erreurs dans le code pour améliorer la robustesse et la précision des tests.

<h3>Auteur :</h3> 
Filip DABROWSKI