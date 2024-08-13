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

TP2

(À venir)
TP3

(À venir)