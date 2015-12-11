Tartaruga
=========

![build status](https://travis-ci.org/mapio/tartaruga.svg?branch=master)

Libreria di supporto all'insegnamento di
[Programmazione](http://boldi.di.unimi.it/Corsi/Mus2015/) del corso di studi
in [Informatica
musicale](http://www.ccdinfmi.unimi.it/it/corsiDiStudio/2015/F3Xof2/)
dell'[Università degli Studi di Milano](http://www.unimi.it/).

Come usare la libreria
----------------------

Gli studenti possono scaricare l'ultima versione dalla pagina delle
[releases](https://github.com/mapio/tartaruga/releases) ed accedere alla
[documentazione delle API](http://mapio.github.io/tartaruga) della libreria; si
osserva che una copia della documentazione è presente anche nelle release
scaricabili dal precedente link.

Una volta scaricato il `.jar`, ad esempio con il comando

	curl -sLO https://github.com/mapio/tartaruga/releases/download/0.1-alpha/tartaruga-0.1-alpha.jar

è possibile eseguire il codice d'esempio con

	java -cp tartaruga-0.1-alpha.jar it.unimi.di.tartaruga.esempi.Quadrati

o compilare una propria classe (supponendo si chiami `MiaClasse`) che faccia
uso della libreria con

	javac -cp tartaruga-0.1-alpha.jar MiaClasse.java
	java -cp tartaruga-0.1-alpha.jar:. MiaClasse

Come contribuire
----------------

Chiunque voglia contribuire allo sviluppo può *segnalare eventuali errori* e
*formulare richieste* aprendo una
[issue](https://github.com/mapio/tartaruga/issues). Gli sviluppatori initeressati
possono fare una [fork](https://github.com/mapio/tartaruga/fork) di questo
repositoty: le richieste di [pull](https://github.com/mapio/tartaruga/pulls)
saranno considerate con molto interesse!

