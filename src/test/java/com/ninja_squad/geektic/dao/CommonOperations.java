package com.ninja_squad.geektic.dao;

import com.ninja_squad.dbsetup.operation.Operation;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;

public class CommonOperations {
	public static final Operation DELETE_ALL = deleteAllFrom("AVOIR", "GEEK", "INTERET");
	public static final Operation INSERT_DATA = sequenceOf(
			insertInto("GEEK")
			.columns("id", "nom", "prenom", "mail", "sexe", "description", "photo")
            .values(1, "DUPONT", "Jean", "jean.dupont@gmail.com", 'H', "Bonjour blablabla", "jeandupont.png")
            .values(2, "CHARIOT", "Jordan", "jordan.chariot@gmail.com", "H", "Bonjour blablabla", "jordanchariot.png")
            .values(3, "BRUGERE", "KEVIN", "kevin.brugere@gmail.com", "H", "Bonjour blablabla", "renyere.png")
            .values(4, "SABATY", "Alexandra", "alexandra.sabaty@gmail.com", "F", "Bonjour blablabla", "alexandrasabaty.png")
            .values(5, "GALEA", "Baptiste", "baptiste.galea@gmail.com", "H", "Bonjour blablabla", "baptistegalea.png")
            .values(6, "CAQUANT", "Jennifer", "jennifer.caquant@gmail.com", "F", "Bonjour blablabla", "jennifercaquant.png")
            .build(),
            insertInto("INTERET")
            .columns("id", "libelle", "icone")
            .values(1, "JAVA", "java.png")
            .values(2, "C#", "csharp.png")
            .values(3, "PHP", "php.png")
            .values(4, "DELPHI", "delphi.png")
            .values(5, "TDD", "tdd.png")
            .values(6, "MCD", "mcd.png")
            .build(), 
            insertInto("AVOIR")
            .columns("id_geek", "id_interet")
			.values (1, 2)
			.values (1, 5)
			.values (1, 6)
			.values (2, 3)
			.values (2, 6)
			.values (2, 4)
			.values (3, 4)
			.values (3, 1)
			.values (4, 3)
			.values (4, 2)
			.values (5, 2)
			.values (5, 3)
			.values (5, 6)
			.values (6, 2)
			.values (6, 5)
			.values (6, 6)
            .build());
}
