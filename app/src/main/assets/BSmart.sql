DROP TABLE IF EXISTS "jadwalsiswa";
CREATE TABLE "jadwalsiswa" ("idjadwalsiswa" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "hari" VARCHAR, "tanggal" DATETIME, "jam" INTEGER, "namaguru" VARCHAR);
DROP TABLE IF EXISTS "siswabelajar";
CREATE TABLE "siswabelajar" ("idsiswabelajar" INTEGER PRIMARY KEY  NOT NULL  DEFAULT (null) ,"namalengkap" VARCHAR,"kelas" VARCHAR,"namaprogram" VARCHAR,"level" VARCHAR);
