-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 09 avr. 2022 à 11:57
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
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cinema`
--

INSERT INTO `cinema` (`id`, `Name`, `Adress`) VALUES
(27, 'Bristol', 'Union Street Bristol BS1 2DS'),
(26, 'Belfast', 'No. 1 Victoria Square Belfast BT1 4QG'),
(25, 'Andover', 'Anton Mill Road Andover SP10 2RW');

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
) ENGINE=MyISAM AUTO_INCREMENT=175 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `filmshow`
--

INSERT INTO `filmshow` (`id`, `SalleId`, `MovieID`, `Day`, `Hours`, `placeTaken`, `price`) VALUES
(68, 27, 335787, 'Friday', '19h', 100, 10),
(67, 27, 675353, 'Friday', '16h', 100, 10),
(66, 27, 453395, 'Tuesday', '22h', 100, 10),
(65, 27, 634649, 'Thursday', '22h', 100, 10),
(64, 27, 335787, 'Wednesday', '19h', 100, 10),
(63, 27, 453395, 'Tuesday', '16h', 100, 10),
(62, 27, 335787, 'Monday', '19h', 100, 10),
(61, 24, 675353, 'Saturday', '19h', 50, 10),
(60, 24, 675353, 'Thursday', '19h', 50, 10),
(59, 24, 675353, 'Tuesday', '13h', 50, 10),
(58, 24, 338953, 'Tuesday', '22h', 50, 10),
(57, 24, 526896, 'Sunday', '22h', 50, 10),
(56, 24, 526896, 'Friday', '13h', 50, 10),
(55, 24, 526896, 'Wednesday', '16h', 50, 9),
(54, 24, 526896, 'Monday', '19h', 50, 10),
(69, 27, 675353, 'Saturday', '19h', 100, 10),
(70, 27, 634649, 'Saturday', '10h', 100, 10),
(71, 27, 526896, 'Sunday', '16h', 100, 10),
(72, 28, 335787, 'Monday', '19h', 25, 10),
(73, 28, 335787, 'Tuesday', '22h', 25, 10),
(74, 28, 338953, 'Tuesday', '16h', 25, 10),
(75, 28, 453395, 'Wednesday', '19h', 25, 10),
(76, 28, 526896, 'Thursday', '19h', 25, 10),
(77, 28, 453395, 'Friday', '16h', 25, 10),
(78, 28, 335787, 'Friday', '22h', 25, 9),
(79, 28, 675353, 'Saturday', '19h', 25, 10),
(80, 28, 675353, 'Sunday', '19h', 25, 10),
(87, 29, 11, 'Monday', '13h', 90, 10),
(85, 29, 767, 'Tuesday', '19h', 90, 12),
(84, 29, 767, 'Monday', '22h', 90, 12),
(88, 29, 11, 'Wednesday', '16h', 90, 12),
(89, 29, 11, 'Thursday', '19h', 90, 10),
(90, 29, 767, 'Wednesday', '22h', 90, 10),
(91, 29, 11, 'Friday', '16h', 90, 12),
(92, 29, 11, 'Friday', '22h', 90, 10),
(93, 29, 767, 'Saturday', '19h', 90, 10),
(94, 29, 11, 'Sunday', '22h', 90, 10),
(95, 25, 259316, 'Monday', '13h', 75, 10),
(96, 25, 338952, 'Monday', '16h', 75, 10),
(97, 25, 338953, 'Monday', '19h', 75, 10),
(99, 25, 37724, 'Tuesday', '19h', 75, 10),
(100, 25, 206647, 'Tuesday', '22h', 75, 10),
(104, 25, 338953, 'Wednesday', '16h', 75, 10),
(105, 25, 206647, 'Wednesday', '22h', 75, 10),
(103, 25, 37724, 'Thursday', '10h', 75, 10),
(106, 25, 206647, 'Thursday', '13h', 75, 10),
(107, 25, 259316, 'Friday', '16h', 75, 10),
(108, 25, 338952, 'Friday', '19h', 75, 10),
(109, 25, 338953, 'Friday', '22h', 75, 10),
(112, 25, 206647, 'Saturday', '16h', 75, 10),
(111, 25, 338953, 'Saturday', '22h', 75, 10),
(113, 25, 206647, 'Sunday', '19h', 75, 0),
(114, 30, 811596, 'Monday', '16h', 65, 10),
(115, 30, 811596, 'Tuesday', '19h', 65, 10),
(116, 30, 811596, 'Wednesday', '16h', 65, 10),
(117, 30, 811596, 'Thursday', '19h', 65, 10),
(118, 30, 811596, 'Friday', '16h', 65, 10),
(119, 30, 811596, 'Saturday', '19h', 65, 10),
(120, 30, 811596, 'Sunday', '16h', 65, 10),
(121, 31, 604563, 'Monday', '16h', 68, 10),
(122, 31, 604563, 'Tuesday', '19h', 68, 10),
(123, 31, 604563, 'Wednesday', '22h', 68, 10),
(124, 31, 604563, 'Thursday', '16h', 68, 10),
(125, 31, 604563, 'Friday', '19h', 68, 10),
(126, 31, 15588, 'Wednesday', '16h', 68, 10),
(127, 31, 15588, 'Monday', '22h', 68, 10),
(128, 31, 15588, 'Thursday', '22h', 68, 10),
(129, 31, 15588, 'Saturday', '16h', 68, 10),
(130, 31, 15152, 'Saturday', '22h', 68, 10),
(131, 31, 15152, 'Sunday', '19h', 68, 10),
(132, 32, 604563, 'Monday', '22h', 25, 10),
(133, 32, 15152, 'Tuesday', '22h', 25, 10),
(134, 32, 15152, 'Wednesday', '22h', 25, 10),
(135, 32, 604563, 'Thursday', '22h', 25, 10),
(136, 32, 15588, 'Friday', '22h', 25, 10),
(137, 32, 604563, 'Saturday', '22h', 25, 10),
(138, 32, 604563, 'Sunday', '22h', 25, 10),
(139, 32, 811596, 'Thursday', '16h', 25, 10),
(140, 32, 811596, 'Wednesday', '16h', 25, 10),
(141, 32, 338952, 'Tuesday', '16h', 25, 10),
(142, 32, 338953, 'Monday', '16h', 25, 10),
(143, 32, 206647, 'Friday', '16h', 25, 10),
(144, 32, 206647, 'Saturday', '16h', 25, 10),
(145, 32, 811596, 'Sunday', '16h', 25, 10),
(146, 26, 129, 'Monday', '22h', 40, 10),
(147, 26, 98, 'Tuesday', '19h', 40, 10),
(148, 26, 597, 'Wednesday', '22h', 40, 10),
(149, 26, 238, 'Wednesday', '16h', 40, 10),
(150, 26, 58, 'Thursday', '19h', 40, 10),
(151, 26, 438631, 'Friday', '13h', 40, 10),
(152, 26, 597, 'Friday', '19h', 40, 10),
(153, 26, 238, 'Saturday', '16h', 40, 10),
(154, 26, 58, 'Saturday', '22h', 40, 10),
(155, 26, 597, 'Sunday', '19h', 40, 10),
(156, 33, 597, 'Tuesday', '19h', 30, 10),
(157, 33, 238, 'Monday', '22h', 30, 10),
(158, 33, 597, 'Wednesday', '10h', 30, 10),
(159, 33, 58, 'Thursday', '13h', 30, 10),
(160, 33, 129, 'Thursday', '22h', 30, 10),
(161, 33, 597, 'Friday', '19h', 30, 10),
(162, 33, 238, 'Saturday', '16h', 30, 10),
(163, 33, 98, 'Sunday', '22h', 26, 10),
(164, 34, 338953, 'Monday', '22h', 150, 8),
(165, 34, 634649, 'Tuesday', '22h', 150, 8),
(166, 34, 338953, 'Wednesday', '19h', 150, 8),
(167, 34, 129, 'Thursday', '22h', 150, 6),
(168, 34, 338953, 'Friday', '19h', 150, 10),
(169, 34, 129, 'Friday', '22h', 150, 10),
(170, 34, 597, 'Saturday', '22h', 150, 8),
(171, 34, 597, 'Sunday', '22h', 150, 8),
(172, 27, 120, 'Wednesday', '13h', 100, 10),
(173, 27, 121, 'Thursday', '13h', 100, 10),
(174, 27, 122, 'Sunday', '22h', 100, 10);

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
) ENGINE=MyISAM AUTO_INCREMENT=287 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `movie`
--

INSERT INTO `movie` (`id`, `cinemaID`, `idtmdb`, `Title`, `Overview`, `Duration`, `movieImageUrl`, `trailerUrl`) VALUES
(272, 25, 37724, 'Skyfall', 'When Bond s latest assignment goes gravely wrong, agents around the world are exposed and MI6 headquarters is attacked. While M faces challenges to her authority and position from Gareth Mallory, the new Chairman of the Intelligence and Security Committee, it s up to Bond, aided only by field agent Eve, to locate the mastermind behind the attack.', '2h23', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/izrHg2UzxG3YXTBcKFaUbYp9LWA.jpg', 'https://www.youtube.com/embed/Mej6c_59bho'),
(271, 25, 206647, 'Spectre', 'A cryptic message from Bond’s past sends him on a trail to uncover a sinister organization. While M battles political forces to keep the secret service alive, Bond peels back the layers of deceit to reveal the terrible truth behind SPECTRE.', '2h28', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/zj8ongFhtWNsVlfjOGo8pSr7PQg.jpg', 'https://www.youtube.com/embed/O-Y8-1esSLI'),
(270, 25, 259316, 'Fantastic Beasts and Where to Find Them', 'In 1926, Newt Scamander arrives at the Magical Congress of the United States of America with a magically expanded briefcase, which houses a number of dangerous creatures and their habitats. When the creatures escape from the briefcase, it sends the American wizarding authorities after Newt, and threatens to strain even further the state of magical and non-magical relations.', '2h12', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/h6NYfVUyM6CDURtZSnBpz647Ldd.jpg', 'https://www.youtube.com/embed/wJeGxDhIwHU'),
(268, 25, 338953, 'Fantastic Beasts: The Secrets of Dumbledore', 'In an effort to thwart Grindelwald s plans of raising pure-blood wizards to rule over all non-magical beings, Albus Dumbledore enlists his former student Newt Scamander, who agrees to help, though he s unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.', '2h22', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/8ZbybiGYe8XM4WGmGlhF0ec5R7u.jpg', 'https://www.youtube.com/embed/-aaw-Or2iCY'),
(269, 25, 338952, 'Fantastic Beasts: The Crimes of Grindelwald', 'Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.', '2h14', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg', 'https://www.youtube.com/embed/G8uRgZQ6zio'),
(267, 25, 811596, 'Notre-Dame on Fire', 'A film relating from the inside the Notre-Dame de Paris fire of April 2019.', '1h50', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/2pEVCUWEr1QyUqzmPguKAiCxxrZ.jpg', 'https://www.youtube.com/embed/VcoirOiEMpw'),
(265, 26, 11, 'Star Wars', 'Princess Leia is captured and held hostage by the evil Imperial forces in their effort to take over the galactic Empire. Venturesome Luke Skywalker and dashing captain Han Solo team together with the loveable robot duo R2-D2 and C-3PO to rescue the beautiful princess and restore peace and justice in the Empire.', '2h1', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/6FfCtAuVAW8XJjZ7eWeLibRLWTw.jpg', 'https://www.youtube.com/embed/XHk5kCIiGoM'),
(266, 26, 767, 'Harry Potter and the Half-Blood Prince', 'As Lord Voldemort tightens his grip on both the Muggle and wizarding worlds, Hogwarts is no longer a safe haven. Harry suspects perils may even lie within the castle, but Dumbledore is more intent upon preparing him for the final battle fast approaching. Together they work to find the key to unlock Voldemorts defenses and to this end, Dumbledore recruits his old friend and colleague Horace Slughorn, whom he believes holds crucial information. Even as the decisive showdown looms, romance blossoms for Harry, Ron, Hermione and their classmates. Love is in the air, but danger lies ahead and Hogwarts may never be the same again.', '2h33', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/o2j49x3HYJC2VH689rYxmswtSgS.jpg', 'https://www.youtube.com/embed/HcryxumRxUI'),
(264, 26, 634649, 'Spider-Man: No Way Home', 'Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.', '2h28', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg', 'https://www.youtube.com/embed/8fqv_n6YxWI'),
(263, 26, 335787, 'Uncharted', 'A young street-smart, Nathan Drake and his wisecracking partner Victor “Sully” Sullivan embark on a dangerous pursuit of “the greatest treasure never found” while also tracking clues that may lead to Nathan’s long-lost brother.', '1h56', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/sqLowacltbZLoCa4KYye64RvvdQ.jpg', 'https://www.youtube.com/embed/81-34IJPlLM'),
(262, 26, 453395, 'Doctor Strange in the Multiverse of Madness', 'Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.', '2h6', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/wRnbWt44nKjsFPrqSmwYki5vZtF.jpg', 'https://www.youtube.com/embed/2MdjoLwsokA'),
(259, 26, 526896, 'Morbius', 'Dangerously ill with a rare blood disorder, and determined to save others suffering his same fate, Dr. Michael Morbius attempts a desperate gamble. What at first appears to be a radical success soon reveals itself to be a remedy potentially worse than the disease.', '1h44', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/7gmOjg7lQXGLW8wX31ry1IdIY07.jpg', 'https://www.youtube.com/embed/TNyatOHDRoQ'),
(260, 26, 338953, 'Fantastic Beasts: The Secrets of Dumbledore', 'In an effort to thwart Grindelwald s plans of raising pure-blood wizards to rule over all non-magical beings, Albus Dumbledore enlists his former student Newt Scamander, who agrees to help, though he s unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.', '2h22', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/8ZbybiGYe8XM4WGmGlhF0ec5R7u.jpg', 'https://www.youtube.com/embed/-aaw-Or2iCY'),
(261, 26, 675353, 'Sonic the Hedgehog 2', 'After settling in Green Hills, Sonic is eager to prove he has what it takes to be a true hero. His test comes when Dr. Robotnik returns, this time with a new partner, Knuckles, in search for an emerald that has the power to destroy civilizations. Sonic teams up with his own sidekick, Tails, and together they embark on a globe-trotting journey to find the emerald before it falls into the wrong hands.', '2h2', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/6DrHO1jr3qVrViUO6s6kFiAGM7.jpg', 'https://www.youtube.com/embed/YkZ1aAPApAc'),
(273, 25, 604563, 'OSS 117: From Africa with Love', 'The third entry in secret agent OSS 117 s parodic spy adventures.', '1h57', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/6J0F1q9cJstqHbtaoS9nTQ4oCbx.jpg', 'https://www.youtube.com/embed/Dbcob9qYivI'),
(274, 25, 15588, 'OSS 117: Lost in Rio', 'French top secret agent, Hubert Bonisseur de la Bath, is sent to Rio to buy microfilms from a running nazi. To do so, he has to team up with Mossad secret services.', '1h40', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/rhv06T3gTFOShIVkQ0UipZFIyDw.jpg', 'https://www.youtube.com/embed/T8qeDWjAypo'),
(275, 25, 15152, 'OSS 117: Cairo, Nest of Spies', 'Secret agent OSS 117 foils Nazis, beds local beauties, and brings peace to the Middle East.', '1h39', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/dDVHVZVEbTV4JsB8ZjdXNmMK7rA.jpg', 'https://www.youtube.com/embed/HYobrwvSs9Q'),
(276, 27, 98, 'Gladiator', 'In the year 180, the death of emperor Marcus Aurelius throws the Roman Empire into chaos.  Maximus is one of the Roman army s most capable and trusted generals and a key advisor to the emperor.  As Marcus  devious son Commodus ascends to the throne, Maximus is set to be executed.  He escapes, but is captured by slave traders.  Renamed Spaniard and forced to become a gladiator, Maximus must battle to the death with other men for the amusement of paying audiences.', '2h35', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/ehGpN04mLJIrSnxcZBMvHeG0eDc.jpg', 'https://www.youtube.com/embed/yD0XIowNAG8'),
(277, 27, 58, 'Pirates of the Caribbean: Dead Man s Chest', 'Captain Jack Sparrow works his way out of a blood debt with the ghostly Davy Jones to avoid eternal damnation.', '2h31', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/uXEqmloGyP7UXAiphJUu2v2pcuE.jpg', 'https://www.youtube.com/embed/elqO-GNfStM'),
(278, 27, 597, 'Titanic', '101-year-old Rose DeWitt Bukater tells the story of her life aboard the Titanic, 84 years later. A young Rose boards the ship with her mother and fiancé. Meanwhile, Jack Dawson and Fabrizio De Rossi win third-class tickets aboard the ship. Rose tells the whole story from Titanic s departure through to its death—on its first and last voyage—on April 15, 1912.', '3h14', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/9xjZS2rlVxm8SFx8kPC3aIGCOYQ.jpg', 'https://www.youtube.com/embed/CHekzSiZjrY'),
(279, 27, 238, 'The Godfather', 'Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.', '2h55', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/n6PvMAKL66gavIFxOyRB6czAeQO.jpg', 'https://www.youtube.com/embed/Ew9ngL1GZvs'),
(280, 27, 438631, 'Dune', 'Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet s exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity s greatest potential-only those who can conquer their fear will survive.', '2h35', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/d5NXSklXo0qyIYkgV94XAgMIckC.jpg', 'https://www.youtube.com/embed/7jB5gCD5kjU'),
(281, 27, 129, 'Spirited Away', 'A young girl, Chihiro, becomes trapped in a strange new world of spirits. When her parents undergo a mysterious transformation, she must call upon the courage she never knew she had to free her family.', '2h5', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/39wmItIWsg5sZMyRUHLkWBcuVCM.jpg', 'https://www.youtube.com/embed/ByXuk9QqQkk'),
(282, 27, 338953, 'Fantastic Beasts: The Secrets of Dumbledore', 'In an effort to thwart Grindelwald s plans of raising pure-blood wizards to rule over all non-magical beings, Albus Dumbledore enlists his former student Newt Scamander, who agrees to help, though he s unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.', '2h22', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/8ZbybiGYe8XM4WGmGlhF0ec5R7u.jpg', 'https://www.youtube.com/embed/-aaw-Or2iCY'),
(283, 27, 634649, 'Spider-Man: No Way Home', 'Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.', '2h28', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg', 'https://www.youtube.com/embed/8fqv_n6YxWI'),
(284, 26, 120, 'The Lord of the Rings: The Fellowship of the Ring', 'Young hobbit Frodo Baggins, after inheriting a mysterious ring from his uncle Bilbo, must leave his home in order to keep it from falling into the hands of its evil creator. Along the way, a fellowship is formed to protect the ringbearer and make sure that the ring arrives at its final destination: Mt. Doom, the only place where it can be destroyed.', '2h59', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/6oom5QYQ2yQTMJIbnvbkBL9cHo6.jpg', 'https://www.youtube.com/embed/UXgbHdnoJrg'),
(285, 26, 121, 'The Lord of the Rings: The Two Towers', 'Frodo and Sam are trekking to Mordor to destroy the One Ring of Power while Gimli, Legolas and Aragorn search for the orc-captured Merry and Pippin. All along, nefarious wizard Saruman awaits the Fellowship members at the Orthanc Tower in Isengard.', '2h59', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/5VTN0pR8gcqV3EPUHHfMGnJYN9L.jpg', 'https://www.youtube.com/embed/nuTU5XcZTLA'),
(286, 26, 122, 'The Lord of the Rings: The Return of the King', 'Aragorn is revealed as the heir to the ancient kings as he, Gandalf and the other members of the broken fellowship struggle to save Gondor from Sauron s forces. Meanwhile, Frodo and Sam take the ring closer to the heart of Mordor, the dark lord s realm.', '3h21', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/rCzpDGLbOoPwLjy3OAm5NUPOTrC.jpg', 'https://www.youtube.com/embed/zckJCxYxn1g');

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
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `movieroom`
--

INSERT INTO `movieroom` (`id`, `Name`, `numbrePlace`, `idCinema`) VALUES
(34, 'Bristol MovieRoom 3', 150, 27),
(33, 'Bristol MovieRoom 2', 30, 27),
(32, 'Andover MovieRoom 4', 25, 25),
(31, 'Andover MovieRoom 3', 68, 25),
(30, 'Andover MovieRoom 2', 65, 25),
(29, 'Belfast MovieRoom 4', 90, 26),
(26, 'Bristol MovieRoom 1', 40, 27),
(27, 'Belfast MovieRoom 2', 100, 26),
(28, 'Belfast MovieRoom 3', 25, 26),
(25, 'Andover MovieRoom 1', 75, 25),
(24, 'Belfast MovieRoom 1', 50, 26);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `admin` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `mail`, `password`, `lastname`, `firstname`, `admin`) VALUES
(1, 'aurelien.bon@me.com', 'aurelien', 'Bon', 'Aurelien', 1),
(2, 'alexandre.bellard@edu.ece.fr', 'alex', 'Bellard', 'Alexandre', 1),
(3, 'valentindroubay@gmail.com', 'valentin1234', 'Droubay', 'Valentin', 0),
(4, 'pierre.escofet@hotmail.fr', 'pierrelebg', 'Escofet', 'Pierre', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
