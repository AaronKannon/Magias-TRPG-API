# Magias-TRPG-API
# Português
Uma API para acessar todas as magias do sistema Tormenta RPG da Jambô Editora

A escolha desta base de dados se dá não só porque é algo que conheço e jogo, mas também devido a complexidade dos dados, já que os padrões das magias se diferem um ao outro fortemente. Além do fato de que teria que evitar redundancias no banco de dados.

Para lidar com a redundancia, deixei isto na parte do Back-End. Possívelmente Triggers no banco de dados poderia ter resultado no mesmo efeito, porém em minhas pesquisas não achei como criar triggers com o hibernate. Além disto, não queria que outros usuarios tivessem que mexer no banco, para ficar mais user-friendly. Justamente por isto que tanto a verificação de elementos sem parentesco e redundancia ficou por conta do Java.

Foi um baita desafio, levei quatro dias inteiros para programar está API. Infelizmente provavelmente não esta RESTful devido aos algoritmos programados para fazer a verificação de redundancia e entradas sem parentes.

Com mais tempo e calma, checarei este codigo para otimiza-lo e torna-lo RESTful

Venho agradecer a toda equipe do Digital Innovation Inc. e ao Santander pela oportunidade de estudo.
Venho agradecer o RoenMidnight pela base de dados onde peguei todas as magias.

# English
An API to access all the spells of the Tormenta RPG system by Jambô Editora

The choice of this database is not only because it's something I know and play, but also because of the complexity of the data, as the spell patterns differ from each other. And the fact that you would have to avoid database redundancies.

To deal with the redundancy, I leave this problem to the Back-End. Possibly Triggers in the database could have resulted in the same effect, but in my research, I didn't find how to create triggers with hibernate. In addition, to make it more user-friendly, I didn't want other users to have to deal with the database. Precisely for this reason, I decided to Java to deal with these problems.

It was a big challenge, four full days to program this API. Unfortunately, it's probably not RESTful due to the algorithms programmed to check redundancy and unrelated entries.

With more time and calm, I will check this code again to optimize and make the changes to be RESTful.

I want to thank the entire team at Digital Innovation Inc. and Santander for the opportunity to study.
I come to thank RoenMidnight for the database where I got all the spells.

