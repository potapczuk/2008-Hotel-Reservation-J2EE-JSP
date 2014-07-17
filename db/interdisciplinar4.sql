# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             interdisciplinar4
# Server version:       5.0.51a
# Server OS:            Win32
# Target-Compatibility: Standard ANSI SQL
# HeidiSQL version:     3.2 Revision: 1129
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1;*/
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ANSI';*/
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;*/


#
# Database structure for database 'interdisciplinar4'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ "interdisciplinar4" /*!40100 DEFAULT CHARACTER SET utf8 */;

USE "interdisciplinar4";


#
# Table structure for table 'chale'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "chale" (
  "codChale" int(10) unsigned NOT NULL auto_increment,
  "localizacao" varchar(255) NOT NULL,
  "capacidade" int(4) NOT NULL,
  "valorAltaEstacao" double(10,2) NOT NULL,
  "valorBaixaEstacao" double(10,2) NOT NULL,
  PRIMARY KEY  ("codChale")
) AUTO_INCREMENT=16 /*!40100 DEFAULT CHARSET=utf8*/;



#
# Table structure for table 'chale_item'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "chale_item" (
  "codChaleItem" int(10) unsigned NOT NULL auto_increment,
  "codChale" int(10) unsigned NOT NULL,
  "codItem" int(10) unsigned NOT NULL,
  PRIMARY KEY  ("codChaleItem")
) AUTO_INCREMENT=36 /*!40100 DEFAULT CHARSET=utf8*/;



#
# Table structure for table 'cliente'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "cliente" (
  "codCliente" int(10) unsigned NOT NULL auto_increment,
  "nomeCliente" varchar(255) NOT NULL,
  "rgCliente" varchar(20) NOT NULL,
  "enderecoCliente" varchar(255) default NULL,
  "bairroCliente" varchar(100) default NULL,
  "cidadeCliente" varchar(100) default NULL,
  "estadoCliente" varchar(100) default NULL,
  "CEPCliente" char(10) default NULL,
  "nascimentoCliente" date default '0000-00-00',
  "telefoneResidencial" char(14) default NULL,
  "telefoneComercial" char(14) default NULL,
  "telefoneCelular" char(14) default NULL,
  PRIMARY KEY  ("codCliente")
) AUTO_INCREMENT=148 /*!40100 DEFAULT CHARSET=utf8*/;



#
# Table structure for table 'hospedagem'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "hospedagem" (
  "codHospedagem" int(10) unsigned NOT NULL auto_increment,
  "codCliente" int(10) unsigned NOT NULL,
  "codChale" int(10) unsigned NOT NULL,
  "dataInicio" datetime NOT NULL,
  "dataFim" datetime default NULL,
  "estado" int(2) default NULL,
  "qtdPessoas" int(4) default '0',
  "desconto" double(10,2) default '0.00',
  "valorFinal" double(10,2) NOT NULL,
  "diaria" double(10,2) NOT NULL,
  PRIMARY KEY  ("codHospedagem")
) AUTO_INCREMENT=26 /*!40100 DEFAULT CHARSET=utf8*/;



#
# Table structure for table 'hospedagem_servico'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "hospedagem_servico" (
  "codHospedagemServico" int(10) unsigned NOT NULL auto_increment,
  "codHospedagem" int(10) unsigned NOT NULL,
  "codServico" int(10) unsigned NOT NULL,
  "valorServico" double(10,2) NOT NULL,
  "dataServico" datetime NOT NULL,
  PRIMARY KEY  ("codHospedagemServico")
) AUTO_INCREMENT=5 /*!40100 DEFAULT CHARSET=utf8*/;



#
# Table structure for table 'item'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "item" (
  "codItem" int(10) unsigned NOT NULL auto_increment,
  "nomeItem" varchar(60) NOT NULL,
  "descricaoItem" varchar(255) default NULL,
  PRIMARY KEY  ("codItem")
) AUTO_INCREMENT=11 /*!40100 DEFAULT CHARSET=utf8*/;



#
# Table structure for table 'servico'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "servico" (
  "codServico" int(10) unsigned NOT NULL auto_increment,
  "nomeServico" varchar(100) NOT NULL,
  "valorServico" double(10,2) NOT NULL,
  PRIMARY KEY  ("codServico")
) AUTO_INCREMENT=11 /*!40100 DEFAULT CHARSET=utf8*/;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/
