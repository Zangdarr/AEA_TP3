# Modélisation et initialisation du jeu de la lettre qui saute
Le but du jeu est de passer d'un mot à un autre par une suite de mots tels qu'un mot et le suivant ne diffèrent que d'une lettre. 
Par exemple, on peut passer de lion à peur par la suite de mots :

lion --> pion --> paon --> pain --> paix --> poix --> poux --> pour --> peur


## Remarque sur l'application de correction d'orthographe

En effet on pourrait créer une application de correction d'orthographe à l'aide de ceci. Cependant, cette partie ne s'occuperait que de trouver les mots à distance de 1 d'une erreur qui faudrai d'abord détecter. Pour la correction, ensuite, il faudrait une base d'apprentissage qui puisse nous sortir les probabilités que chacun des mots trouvé par notre algorithme apparaîsse à la suite de la succession de mots/expressions présente dans la phrase où l'on a détecté l'erreur et du coup suggérer à l'utilisateur les plus probables d'entre eux voir carrément changer le mots pour celui le plus probable.


## Exercice 1 :
le but est, dans cette exercice, de trouver tout les successeurs possibles de chaque mots. Par successeurs j'entend des mots qui ne possèdent qu'une et une seule lettre de différence avec un mot.

L'algorithme est très simple, il s'agit de deux boucles imbriquées qui :

* parcours la liste des mots
* * parcours des mots différents de ce déjà traités ou entrain d'être traités par la première boucle
* * * si le mot courant à une différence d'une seule lettre avec, alors on ajoute une arête entre les deux mots.

(Execution du main de l'exercice 1)


## Exercice 2 : 
Le but est de calculer les composantes connexes grâce à un parcours en profondeur.
* On part d'un mot non marqué qu'on marque
* Puis on cherche un suivant non marqué qui n'as qu'une lettre de différence. 
* On marque le sommet trouvé et on repart de celui-ci comme pour le précédant.

On s'arrête lorsqu'il n'y a plus de suivant et on définit tout les mots que l'on vient de marquer dans l'ordre comme une composante connexe.

On reprend l'algorithme avec un sommet non marqué jusqu'à ce que tout les sommets soit marqués.

Grâce à cela on est capable de dire si deux mots font partie de la même composante connexe, par exemple pour lion et peur : 

        La composante du mot 'lion' est la numéro 0
        La composante du mot 'peur' est la numéro 0

(Execution du main de l'exercice 2)



## Exercice 3 : 
Le but est de calculer un chemin d'un mot à un autre s'il en existe un avec un parcours en profondeur, dès qu'un chemin est trouvé on s'arrête.
Par exemple pour lion et peur on a :

        lion pion paon pain paix noir noix joie rose roue yeux ceux deux doux leur heur peur 

* Pour ce faire, on verifie que les deux mots font partie de la même composante connexe. Pour lion et peur on est OK.
* Puis on parcour la composante connexe commune du début, jusqu'à trouver un des deux mots on ignore ceux que l'on parcours. 
* Une fois qu'on en trouve un, on considère tous les mots que l'on va croiser jusqu'à atteindre le deuxième mot(inclue bien sur).

(Execution du main de l'exercice 3)

## Exercice 4 :
Dans cet exercice on calcul le plus court chemin entre deux mots d'un dictionnaire.
En premier lieu on applique un parcour en largeur (BFS) et on obtient pour lion et peur :

        BFS : 
        lion pion paon pain paix poix poux pour peur

Ensuite on se sert de ce que l'on vient de faire pour améliorer notre calcul de chemin de l'exercice 3 avec un parcour en profondeur pour obtenir un plus court chemin :

        Amelioration de l'exo 3 :
        lion pion paon pain paix poix poux pour peur

Pour cette amélioration on modifie le DFS de l'exercice trois pour redéfinir la liste des successeurs du mot de façon a avoir tout les mots :
Lancement du DFS
* on parcours la liste des successeurs du mot
* * [SI] on a pas encore mis de père au successeur 
* * [OU SI] la profondeur qu'il faut pour atteindre succ à partir du mot est supérieur à la profondeur actuelle qui nous a permit de l'atteindre 
* * [ALORS] on le choisit le mot comme père du succ car cela signifie qu'on aura trouvé un chemin plus court pour atteindre ce succ
  On lance le DFS pour le successeur avec pour profondeur la profondeur actuelle + 1 car on s'enfonce de 1 dans le graphe.

(Execution du main de l'exercice 4)
