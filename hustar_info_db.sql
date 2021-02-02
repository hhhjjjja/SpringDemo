-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.8-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- hustar 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `hustar` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hustar`;

-- 테이블 hustar.board 구조 내보내기
CREATE TABLE IF NOT EXISTS `board` (
  `board_id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `viewcount` int(11) DEFAULT NULL,
  `wdate` date DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`board_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 테이블 데이터 hustar.board:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
/*!40000 ALTER TABLE `board` ENABLE KEYS */;

-- 테이블 hustar.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `auth` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 hustar.user:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `password`, `phone`, `email`, `auth`, `name`) VALUES
	('root', 'root', '01046421567', 'hhhjjjja@gmail.com', 1, '박현정');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
