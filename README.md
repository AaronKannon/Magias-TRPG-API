# Magias-TRPG-API
## Português
Uma API para acessar todas as magias do sistema Tormenta RPG da Jambô Editora

A escolha desta base de dados se dá não só porque é algo que conheço e jogo, mas também devido a complexidade dos dados, já que os padrões das magias se diferem um ao outro fortemente. Além do fato de que teria que evitar redundancias no banco de dados.

Para lidar com a redundancia, deixei isto na parte do Back-End. Possívelmente Triggers no banco de dados poderia ter resultado no mesmo efeito, porém em minhas pesquisas não achei como criar triggers com o hibernate. Além disto, não queria que outros usuarios tivessem que mexer no banco, para ficar mais user-friendly. Justamente por isto que tanto a verificação de elementos sem parentesco e redundancia ficou por conta do Java.

Nas minhas pesquisas, encontrei que podia criar Listeners para eventos do Hibernate antes de acontecer, eu cheguei a cria-los, mas o problema é que como o Spring cuida da Factory de maneira automatica, por de trás, me impossibilitou de aplicar o Listener. Não só isso, as checagens ocorrem no controller de Magia porque infelizmente em qualquer outro lugar que eu declarava os serviços, devido ao controle automatico do Spring, todas as declarações eram nulas.

Foi um baita desafio, levei quatro dias inteiros para programar está API. Infelizmente provavelmente não esta RESTful devido aos algoritmos programados para fazer a verificação de redundancia e entradas sem parentes.

Com mais tempo e calma, checarei este codigo para otimiza-lo e torna-lo RESTful

Venho agradecer a toda equipe do Digital Innovation Inc. e ao Santander pela oportunidade de estudo.
Venho agradecer o RoenMidnight pela base de dados onde peguei todas as magias.

## English
An API to access all the spells of the Tormenta RPG system by Jambô Editora

The choice of this database is not only because it's something I know and play, but also because of the complexity of the data, as the spell patterns differ from each other. And the fact that you would have to avoid database redundancies.

To deal with the redundancy, I leave this problem to the Back-End. Possibly Triggers in the database could have resulted in the same effect, but in my research, I didn't find how to create triggers with hibernate. In addition, to make it more user-friendly, I didn't want other users to have to deal with the database. Precisely for this reason, I decided to Java to deal with these problems.

I found that it was possible to create Listeners for Hibernate events before they happened, but the problem is that since Spring takes care of the Factory from behind, it made it impossible for me to apply the Listener. Not only that, the checks take place in the Magic controller because, when I declared services, because of the Spring's automatic control, all declarations were null.

It was a big challenge, four full days to program this API. Unfortunately, it's probably not RESTful due to the algorithms programmed to check redundancy and unrelated entries.

With more time and calm, I will check this code to optimize and make the changes to be RESTful.

I want to thank the entire team at Digital Innovation Inc. and Santander for the opportunity to study.
I come to thank RoenMidnight for the database where I got all the spells.

## JSON position
To use, copy the db.json and paste inside the C:/

## To-Do
* Adding a working search by name (because people when playing TRPG search by the spell's name)
* Adding text to the API page
* Trying to optimize the code
