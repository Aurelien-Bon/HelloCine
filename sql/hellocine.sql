-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 30 mars 2022 à 16:59
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hellocine`
--

-- --------------------------------------------------------

--
-- Structure de la table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
CREATE TABLE IF NOT EXISTS `cinema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Adress` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cinema`
--

INSERT INTO `cinema` (`id`, `Name`, `Adress`) VALUES
(1, 'test', '1 rue du test'),
(2, 'Gaumont', '23 Rue du pater'),
(24, 'Pather', '1 rue du pater');

-- --------------------------------------------------------

--
-- Structure de la table `filmshow`
--

DROP TABLE IF EXISTS `filmshow`;
CREATE TABLE IF NOT EXISTS `filmshow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `SalleId` int(11) NOT NULL,
  `MovieID` int(11) NOT NULL,
  `Day` text NOT NULL,
  `Hours` text NOT NULL,
  `placeTaken` int(100) NOT NULL,
  `price` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `SalleId` (`SalleId`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `filmshow`
--

INSERT INTO `filmshow` (`id`, `SalleId`, `MovieID`, `Day`, `Hours`, `placeTaken`, `price`) VALUES
(33, 3, 36557, 'Wednesday', '13h', 15, 10),
(34, 3, 206647, 'Friday', '13h', 15, 10),
(35, 22, 1930, 'Wednesday', '16h', 100, 10),
(36, 22, 1930, 'Tuesday', '19h', 100, 10),
(37, 22, 1930, 'Friday', '19h', 100, 10),
(38, 1, 11, 'Monday', '13h', 150, 10),
(39, 3, 10764, 'Tuesday', '19h', 15, 5),
(41, 22, 36557, 'Saturday', '19h', 100, 9),
(42, 1, 811596, 'Thursday', '22h', 150, 10),
(43, 3, 10764, 'Saturday', '13h', 15, 10),
(44, 7, 11, 'Tuesday', '19h', 50, 10);

-- --------------------------------------------------------

--
-- Structure de la table `movie`
--

DROP TABLE IF EXISTS `movie`;
CREATE TABLE IF NOT EXISTS `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cinemaID` int(11) NOT NULL,
  `idtmdb` int(11) NOT NULL,
  `Title` text NOT NULL,
  `Overview` text NOT NULL,
  `Duration` text NOT NULL,
  `movieImageUrl` text NOT NULL,
  `trailerUrl` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cinemaID` (`cinemaID`)
) ENGINE=MyISAM AUTO_INCREMENT=251 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `movie`
--

INSERT INTO `movie` (`id`, `cinemaID`, `idtmdb`, `Title`, `Overview`, `Duration`, `movieImageUrl`, `trailerUrl`) VALUES
(241, 2, 11, 'Star Wars', 'Princess Leia is captured and held hostage by the evil Imperial forces in their effort to take over the galactic Empire. Venturesome Luke Skywalker and dashing captain Han Solo team together with the loveable robot duo R2-D2 and C-3PO to rescue the beautiful princess and restore peace and justice in the Empire.', '2h1', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/6FfCtAuVAW8XJjZ7eWeLibRLWTw.jpg', 'https://www.youtube.com/embed/XHk5kCIiGoM'),
(242, 2, 1894, 'Star Wars: Episode II - Attack of the Clones', 'Following an assassination attempt on Senator Padmé Amidala, Jedi Knights Anakin Skywalker and Obi-Wan Kenobi investigate a mysterious plot that could change the galaxy forever.', '2h22', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/oZNPzxqM2s5DyVWab09NTQScDQt.jpg', 'https://www.youtube.com/embed/gYbW1F_c9eM'),
(243, 1, 36557, 'Casino Royale', 'Le Chiffre, a banker to the world s terrorists, is scheduled to participate in a high-stakes poker game in Montenegro, where he intends to use his winnings to establish his financial grip on the terrorist market. M sends Bond—on his maiden mission as a 00 Agent—to attend this game and prevent Le Chiffre from winning. With the help of Vesper Lynd and Felix Leiter, Bond enters the most important poker game in his already dangerous career.', '2h24', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/8Gv1dylImVuoj3bZtEWoL1TLl2q.jpg', 'https://www.youtube.com/embed/U4NT78c-pYs'),
(244, 1, 37724, 'Skyfall', 'When Bond s latest assignment goes gravely wrong, agents around the world are exposed and MI6 headquarters is attacked. While M faces challenges to her authority and position from Gareth Mallory, the new Chairman of the Intelligence and Security Committee, it s up to Bond, aided only by field agent Eve, to locate the mastermind behind the attack.', '2h23', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/izrHg2UzxG3YXTBcKFaUbYp9LWA.jpg', 'https://www.youtube.com/embed/Mej6c_59bho'),
(245, 24, 1930, 'The Amazing Spider-Man', 'Peter Parker is an outcast high schooler abandoned by his parents as a boy, leaving him to be raised by his Uncle Ben and Aunt May. Like most teenagers, Peter is trying to figure out who he is and how he got to be the person he is today. As Peter discovers a mysterious briefcase that belonged to his father, he begins a quest to understand his parents  disappearance – leading him directly to Oscorp and the lab of Dr. Curt Connors, his father s former partner. As Spider-Man is set on a collision course with Connors  alter ego, The Lizard, Peter will make life-altering choices to use his powers and shape his destiny to become a hero.', '2h16', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/fSbqPbqXa7ePo8bcnZYN9AHv6zA.jpg', 'https://www.youtube.com/embed/LiPl8UmDlhM'),
(246, 1, 206647, 'Spectre', 'A cryptic message from Bond’s past sends him on a trail to uncover a sinister organization. While M battles political forces to keep the secret service alive, Bond peels back the layers of deceit to reveal the terrible truth behind SPECTRE.', '2h28', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/zj8ongFhtWNsVlfjOGo8pSr7PQg.jpg', 'https://www.youtube.com/embed/O-Y8-1esSLI'),
(247, 1, 10764, 'Quantum of Solace', 'Quantum of Solace continues the adventures of James Bond after Casino Royale. Betrayed by Vesper, the woman he loved, 007 fights the urge to make his latest mission personal. Pursuing his determination to uncover the truth, Bond and M interrogate Mr. White, who reveals that the organization that blackmailed Vesper is far more complex and dangerous than anyone had imagined.', '1h46', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/e3DXXLJHGqMx9yYpXsql1XNljmM.jpg', 'https://www.youtube.com/embed/BBqYaFEWBxI'),
(248, 24, 36557, 'Casino Royale', 'Le Chiffre, a banker to the world s terrorists, is scheduled to participate in a high-stakes poker game in Montenegro, where he intends to use his winnings to establish his financial grip on the terrorist market. M sends Bond—on his maiden mission as a 00 Agent—to attend this game and prevent Le Chiffre from winning. With the help of Vesper Lynd and Felix Leiter, Bond enters the most important poker game in his already dangerous career.', '2h24', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/8Gv1dylImVuoj3bZtEWoL1TLl2q.jpg', 'https://www.youtube.com/embed/U4NT78c-pYs'),
(249, 2, 811596, 'Notre-Dame on Fire', 'A film relating from the inside the Notre-Dame de Paris fire of April 2019.', '1h50', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/2pEVCUWEr1QyUqzmPguKAiCxxrZ.jpg', 'https://www.youtube.com/embed/VcoirOiEMpw'),
(250, 1, 77338, 'The Intouchables', 'A true story of two men who should never have met – a quadriplegic aristocrat who was injured in a paragliding accident and a young man from the projects.', '1h53', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/ttx4GQl0azO6NJFWj4XNZCQOY7S.jpg', 'https://www.youtube.com/embed/0RqDiYnFxTk');

-- --------------------------------------------------------

--
-- Structure de la table `movieroom`
--

DROP TABLE IF EXISTS `movieroom`;
CREATE TABLE IF NOT EXISTS `movieroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `numbrePlace` int(11) NOT NULL,
  `idCinema` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCinema` (`idCinema`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `movieroom`
--

INSERT INTO `movieroom` (`id`, `Name`, `numbrePlace`, `idCinema`) VALUES
(1, 'Gaumont MovieRoom 1', 150, 2),
(2, 'Gaumont MovieRoom 2', 58, 2),
(3, 'test MovieRoom 1', 15, 1),
(7, 'Gaumont MovieRoom 3', 50, 2),
(8, 'test MovieRoom 2', 25, 1),
(9, 'test MovieRoom 3', 5, 1),
(10, 'Gaumont MovieRoom 4', 65, 2),
(11, 'Gaumont MovieRoom 5', 42, 2),
(13, 'test MovieRoom 4', 35, 1),
(22, 'Pather MovieRoom 1', 100, 24);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
