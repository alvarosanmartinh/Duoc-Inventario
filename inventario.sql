-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 29-04-2019 a las 21:43:07
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario`
--

DROP SCHEMA IF EXISTS inventario;
CREATE SCHEMA inventario;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--
USE inventario;

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `IdCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Descripcion` varchar(60) NOT NULL,
  `Eliminado` varchar(10) NOT NULL,
  PRIMARY KEY (`IdCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

DROP TABLE IF EXISTS `contacto`;
CREATE TABLE IF NOT EXISTS `contacto` (
  `email` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `Motivo` varchar(20) NOT NULL,
  `requerimiento` varchar(150) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

DROP TABLE IF EXISTS `detalleVenta`;
CREATE TABLE IF NOT EXISTS `detalleVenta` (
  `IdDetVenta` int(11) NOT NULL AUTO_INCREMENT,
  `CodigoProducto` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Total` int(11) NOT NULL,
  PRIMARY KEY (`IdDetVenta`),
  KEY `CodigoProducto` (`CodigoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Anho` int(11) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  `Modelo` varchar(20) NOT NULL,
  `Tipo` varchar(20) NOT NULL,
  `Medida` varchar(20) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Valor` int(11) NOT NULL,
  `SubCategoria` int(11) NOT NULL,
  `Nombre` varchar(90) NOT NULL,
  `Proveedor` int(11) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  `StockAdmin` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`),
  KEY `SubCategoria` (`SubCategoria`),
  KEY `Proveedor` (`Proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `IdProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(80) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Eliminado` varchar(45) NOT NULL,
  PRIMARY KEY (`IdProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subcategoria`
--

DROP TABLE IF EXISTS `subcategoria`;
CREATE TABLE IF NOT EXISTS `subcategoria` (
  `IdSubCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `Categoria` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Descripcion` varchar(60) NOT NULL,
  `Eliminado` varchar(45) NOT NULL,
  PRIMARY KEY (`IdSubCategoria`),
  KEY `Categoria` (`Categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `Rut` varchar(12) NOT NULL,
  `Clave` varchar(20) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Tipo` varchar(20) NOT NULL,
  `Eliminado` varchar(45) NOT NULL,
  PRIMARY KEY (`Rut`),
  KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

DROP TABLE IF EXISTS `venta`;
CREATE TABLE IF NOT EXISTS `venta` (
  `IdVenta` int(11) NOT NULL AUTO_INCREMENT,
  `RutCliente` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `eliminado` varchar(45) NOT NULL,
  PRIMARY KEY (`IdVenta`),
  KEY `RutCliente` (`RutCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`CodigoProducto`) REFERENCES `producto` (`Codigo`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`SubCategoria`) REFERENCES `subcategoria` (`IdSubCategoria`),
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`Proveedor`) REFERENCES `proveedor` (`IdProveedor`);

--
-- Filtros para la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  ADD CONSTRAINT `subcategoria_ibfk_1` FOREIGN KEY (`IdSubCategoria`) REFERENCES `producto` (`SubCategoria`),
  ADD CONSTRAINT `subcategoria_ibfk_2` FOREIGN KEY (`Categoria`) REFERENCES `categoria` (`IdCategoria`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `contacto` (`email`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`IdVenta`) REFERENCES `detalleventa` (`IdDetVenta`),
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`RutCliente`) REFERENCES `usuario` (`Rut`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
