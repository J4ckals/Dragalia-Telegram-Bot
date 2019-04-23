package com.dragaliabot.database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.nio.file.Path
import java.sql.Connection

fun Database.Companion.connectSQLite(localDatabasePath: Path) = connectSQLite(localDatabasePath.toString())

fun Database.Companion.connectSQLite(localDatabasePath: String) =
    connect("jdbc:sqlite:$localDatabasePath", "org.sqlite.JDBC")

val database by lazy { Database.connectSQLite("dragalia-db.sqlite") }

fun <T> serializableTransaction(
    db: Database? = null,
    repetitionAttempts: Int = TransactionManager.manager.defaultRepetitionAttempts,
    statement: Transaction.() -> T
) = transaction(Connection.TRANSACTION_SERIALIZABLE, repetitionAttempts, db, statement)

fun <T> defaultTransaction(function: Transaction.() -> T) =
    serializableTransaction(database, statement = function)
