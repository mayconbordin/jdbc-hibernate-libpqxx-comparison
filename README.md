JDBC, Hibernate and libpqxx Comparison
======================================

This is a simple benchmark (don't take it seriously) that compares a select query 
against a 60k records in a PostgreSQL database.

The test compares three implementations: C++ with libpqxx driver class, Java with
JDBC driver and Java with Hibernate ORM layer.

## Software Versions

* PostgreSQL 8.4 for Windows
* Java 
* Hibernate 3.2.5.ga
* Driver JDBC3 8.4-701
* libpqxx 3.1
* Boost 1.45
